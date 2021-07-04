package employeeclient.controller;

import employeeclient.dto.model.Employee;
import employeeclient.dto.model.EmployeeDto;
import employeeclient.service.EmployeeServiceImpl;
import employeeclient.service.SearchRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    private EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping()
    public String getAll(Model model) {
        var employeeList = service.getAllEmployee();
        var searchRequest = new SearchRequest();
        model.addAttribute("employees", employeeList);
        model.addAttribute("searchRequest", searchRequest);
        return "employee-list";
    }

    @GetMapping(value = "/{id}")
    public String getOne(@PathVariable(name = "id") Long employeeId, Model model) {
        Employee employee = service.getEmployeeById(employeeId);
        model.addAttribute("user", employee);
        return "employee";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "create2";
    }

    @PostMapping(value = "/search")
    public String search(@ModelAttribute SearchRequest searchRequest, BindingResult result, Model model) {
        var employee = service.findByName(searchRequest.getKeyword());
        model.addAttribute("employees", employee);
        return "employee-list";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long employeeId) {
        service.deleteEmployee(employeeId);
        return "redirect:/employees";
    }

    @PostMapping(value = "/save")
    public String save(Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        }
        service.saveEmployee(employee);
        return "redirect:/employees";
    }
}

