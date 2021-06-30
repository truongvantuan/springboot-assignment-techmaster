package employeemanager;

import employeemanager.domain.Employee;
import employeemanager.repository.EmployeeRepository;
import employeemanager.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeService service;

    @Mock
    EmployeeRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllEmployeeTest() {
        List<Employee> employeeList = repository.findAll();
        assertEquals(2, employeeList.size());
    }


}
