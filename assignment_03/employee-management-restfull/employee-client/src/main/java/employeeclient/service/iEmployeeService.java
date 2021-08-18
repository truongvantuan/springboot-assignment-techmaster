package employeeclient.service;

import employeeclient.dto.model.Employee;

import java.util.List;

public interface iEmployeeService {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long employeeId);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(Long employeeId);

    void updateEmployee(Employee employee);

    List<Employee> findByEmail(String keyword);

    List<Employee> findByName(String keyword);
}
