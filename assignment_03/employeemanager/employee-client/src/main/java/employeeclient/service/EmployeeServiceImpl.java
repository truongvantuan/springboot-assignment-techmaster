package employeeclient.service;

import employeeclient.dto.mapper.EmployeeMapper;
import employeeclient.dto.model.Employee;
import employeeclient.exception.ResourceNotFoundException;
import employeeclient.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements iEmployeeService {

    private EmployeeRepository repository;

    private EmployeeMapper mapper;

    EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long employeeId) {
        return repository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException(employeeId));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        var employee = repository.findById(employeeId);
        if (employee.isPresent()) {
            repository.delete(employee.get());
        } else {
            throw new ResourceNotFoundException(employeeId);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        var updatedEmployee = getEmployeeById(employee.getId());
        updatedEmployee.setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setEmail(employee.getEmail())
                .setPassportNumber(employee.getPassportNumber());
    }

    public List<Employee> findByEmail(String keyword) {
        var email = keyword.toLowerCase();
        if (keyword.isEmpty() || keyword.isBlank()) {
            return repository.findAll();
        }
        return repository.findAll().stream()
                .filter(employee -> employee.getEmail().contains(email)
                        || employee.getEmail().contains(email))
                .collect(Collectors.toList());
    }

    public List<Employee> findByName(String keyword) {
        String name = keyword.toLowerCase();
        return repository.findAll().stream()
                .filter(employee -> employee.getFirstName().toLowerCase().contains(name)
                        || employee.getLastName().toLowerCase().contains(name))
                .collect(Collectors.toList());
    }
}
