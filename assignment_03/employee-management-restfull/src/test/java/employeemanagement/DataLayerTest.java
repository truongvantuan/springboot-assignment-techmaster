package employeemanagement;

import employeemanagement.repository.EmployeeRepository;
import employeemanagement.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.assertNotNull;

@DataJpaTest
public class DataLayerTest {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    EmployeeService service;

    @Test
    public void shouldReturnOneEmployeePerOneId() {
        assertNotNull(service);
    }
}
