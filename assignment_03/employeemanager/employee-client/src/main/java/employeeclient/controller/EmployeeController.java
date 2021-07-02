package employeeclient.controller;

import employeeclient.domain.Employee;
import employeeclient.service.EmployeeService;
import employeeclient.service.SearchRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping()
    public String getAll(Model model) {
        var employeeList = service.getAllEmployee();
        var searchRequest = new SearchRequest();
        model.addAttribute("employees", employeeList);
        model.addAttribute("searchRequest", searchRequest);
        return "index";
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
        return "create";
    }

//    @PostMapping(value = "/create")
//    public String create(Model model) {
//        model.addAttribute("employee", new Employee());
//        return "create";
//    }

    @PostMapping(value = "/search")
    public String search(@ModelAttribute SearchRequest searchRequest, BindingResult result, Model model) {
        var employee = service.findByName(searchRequest.getKeyword());
        model.addAttribute("employees", employee);
        return "index";
    }
}

