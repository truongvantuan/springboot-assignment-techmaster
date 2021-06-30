package employeemanager;

import employeemanager.domain.Employee;
import employeemanager.repository.EmployeeRepository;
import employeemanager.service.EmployeeService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertTrue;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class EmployeemanagerApplicationTests {

    @Autowired
    EmployeeService service;

    @Autowired
    EmployeeRepository repository;

    @Test
    void contextLoads() {
        List<Employee> employeeList = repository.findAll();
        assertEquals(2, employeeList.size());
    }

    @Test
    public void EmployeeSearchTest() {
        List<Employee> employeeList = repository.findAll();
        var employee1 = service.findByName("Tuan").get(0);
        assertEquals(employee1, employeeList.get(0));
    }

}
