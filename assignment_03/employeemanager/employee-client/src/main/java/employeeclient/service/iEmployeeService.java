package employeeclient.service;

import employeeclient.domain.Employee;
import employeeclient.domain.EmployeeDto;

import java.util.List;

public interface iEmployeeService {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long employeeId);

    Employee saveEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);

    void updateEmployee(EmployeeDto employeeDto, Long employeeId);

    List<Employee> findByEmail(String keyword);

    List<Employee> findByName(String keyword);
}
