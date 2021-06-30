package employeemanager.service;

import employeemanager.domain.Employee;
import employeemanager.domain.EmployeeDto;
import employeemanager.exception.ResourceNotFoundException;
import employeemanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long employeeId) {
        return repository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException(employeeId));
    }

    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee newEmployee = EmployeeDto.mapDtoToObject(employeeDto);
        return repository.save(newEmployee);
    }

    public void deleteEmployee(Long employeeId) {
        var employee = repository.findById(employeeId);
        if (employee.isPresent()) {
            repository.delete(employee.get());
        } else {
            throw new ResourceNotFoundException(employeeId);
        }
    }

    public void updateEmployee(EmployeeDto employeeDto, Long employeeId) {
        Employee employee = EmployeeDto.mapDtoToObject(employeeDto);
        employee.setId(employeeId);
        var newEmployee = repository.findById(employeeId);
        if (newEmployee.isPresent()) {
            repository.save(employee);
        } else {
            throw new ResourceNotFoundException(employeeId);
        }
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
