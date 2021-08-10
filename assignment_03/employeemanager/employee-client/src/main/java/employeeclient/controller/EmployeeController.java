package employeeclient.controller;

import employeeclient.dto.model.Employee;
import employeeclient.service.EmployeeServiceImpl;
import employeeclient.service.SearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    private EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    /**
     * Lấy toàn bộ danh sách employee.
     *
     * @param model
     * @return đổ dữ liệu vào template employee-list
     */
    @GetMapping()
    public String getAll(Model model) {
        var employeeList = service.getAllEmployee();
        var searchRequest = new SearchRequest();
        model.addAttribute("employees", employeeList);
        model.addAttribute("searchRequest", searchRequest);
        log.info("getAll() đã được gọi >>>"); // show log in console
        return "employee-list";
    }

    /**
     * Lấy về thông tin employee theo id truyền vào từ url path
     *
     * @param employeeId map từ id
     * @param model
     * @return
     */
    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable(name = "id") Long employeeId, Model model) {
        var employee = service.getEmployeeById(employeeId);
        model.addAttribute("user", employee);
        log.info("get employee name " + employee.getFullName());
        return "employee";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        }
        service.saveEmployee(employee);
        return "redirect:/employees";
    }

    @PostMapping(value = "/search")
    public String search(@ModelAttribute SearchRequest searchRequest, BindingResult result, Model model) {
        var employees = service.findByName(searchRequest.getKeyword());
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long employeeId) {
        service.deleteEmployee(employeeId);
        return "redirect:/employees";
    }

    @GetMapping(value = "/edit/{id}")
    public String editOne(@PathVariable("id") Long employeeId, Model model) {
        var title = "Update information " + service.getEmployeeById(employeeId).getFullName();
        var employee = service.getEmployeeById(employeeId);
        model.addAttribute("title", title);
        model.addAttribute("employee", employee);
        return "edit";
    }
}

