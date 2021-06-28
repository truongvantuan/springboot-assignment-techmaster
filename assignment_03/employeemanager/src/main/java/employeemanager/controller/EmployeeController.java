package employeemanager.controller;

import employeemanager.domain.Employee;
import employeemanager.domain.EmployeeModelAssembler;
import employeemanager.exception.ResourceNotFoundException;
import employeemanager.repository.EmployeeRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    private EmployeeRepository repository;

    private EmployeeModelAssembler assembler;

    EmployeeController(EmployeeRepository employeeRepository, EmployeeModelAssembler employeeModelAssembler) {
        this.repository = employeeRepository;
        this.assembler = employeeModelAssembler;
    }

    @GetMapping(value = "/employees")
    public CollectionModel<EntityModel<Employee>> all() {
        List<EntityModel<Employee>> employees = repository.findAll().stream()
                .map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(employees,
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }

    @GetMapping(value = "/employees/{id}")
    public EntityModel<Employee> one(@PathVariable("id") Long employeeId) {
        Employee employee = repository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException(employeeId));
        return assembler.toModel(employee);
    }
}
