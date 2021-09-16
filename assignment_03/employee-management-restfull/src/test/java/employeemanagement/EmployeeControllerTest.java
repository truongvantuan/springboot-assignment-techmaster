package employeemanagement;

import employeemanagement.controller.EmployeeController;
import employeemanagement.domain.Employee;
import employeemanagement.domain.EmployeeModelAssembler;
import employeemanagement.repository.EmployeeRepository;
import employeemanagement.service.EmployeeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tuân theo nguyên lý auto-configuration của Spring Framework, chỉ cần dùng annotation @WebMvcTest
 * Không chỉ đảm bảm tự động cấu hình, còn lược bỏ các bean trong Spring Context chỉ còn liên quan đến Spring MVC
 * Đảm bảo pass Class cần test vào.
 */
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    private static final String BASE_PATH = "/api/employees";
    private static final long ID = 1;
    private Employee employee;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @MockBean
    private EmployeeModelAssembler assembler;

    // Khởi tạo dữ liệu test
    private Employee initEmployees() {
        employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("tuan");
        employee.setLastName("truong");
        employee.setEmail("truongvantuan@outlook.com.vn");
        employee.setPassportNumber("123456789");
        return employee;
    }

    /**
     * Một request có nhiều thành phần, ta lần lượt bóc tách và test riêng từng thành phần.
     * Đầu tiên là ResponseStatus.
     *
     * @throws Exception
     */
    @Test
    public void shouldOkWhenMakeRequest() throws Exception {
        when(service.getEmployeeById(1L)).thenReturn(initEmployees());
        final ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH + "/" + ID));
        actions.andExpect(status().is(200));
        verifyJson(actions);
    }

    private void verifyJson(final ResultActions action) throws Exception {
        action.andExpect(jsonPath("firstName", Matchers.is(employee.getFirstName())))
                .andExpect(jsonPath("lastName", Matchers.is(employee.getLastName())))
                .andExpect(jsonPath("email", Matchers.is(employee.getEmail())))
                .andExpect(jsonPath("passportNumber", Matchers.is(employee.getPassportNumber())));
    }

    @Test
    public void shouldReturnAllEmployees() throws Exception {
        when(service.getAllEmployee()).thenReturn(Arrays.asList(initEmployees()));
        this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", Matchers.is("Tuan")));
    }

    @Test
    public void shouldReturnOneEmployeeWithOneId() throws Exception {
        when(service.getEmployeeById(1L))
                .thenReturn(new Employee(1L, "tuan", "truong", "tuan@truong.vn", "12345"));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/1"))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$[0].firstName", Matchers.is("tuan")));
    }
}
