package employeemanagement.controller;

import employeemanagement.domain.Employee;
import employeemanagement.domain.EmployeeDto;
import employeemanagement.domain.EmployeeModelAssembler;
import employeemanagement.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Validated
@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {

    private EmployeeService service;

    private EmployeeModelAssembler assembler;

    EmployeeController(EmployeeService employeeService, EmployeeModelAssembler employeeModelAssembler) {
        this.service = employeeService;
        this.assembler = employeeModelAssembler;
    }

    @Operation(summary = "Lấy tất cả employee")
    @GetMapping
    public CollectionModel<EntityModel<Employee>> getAll() {
        List<EntityModel<Employee>> employees = service.getAllEmployee()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(employees,
                linkTo(methodOn(EmployeeController.class).getAll()).withRel("employees"));
    }

    @Operation(summary = "Lấy về employee theo id")
    @GetMapping(value = "/{id}")
    public EntityModel<Employee> getOne(@PathVariable("id")
                                        @Min(value = 1)
                                        @Max(value = 100) Long employeeId) {
        Employee employee = service.getEmployeeById(employeeId);
        return assembler.toModel(employee);
    }

    @GetMapping(value = "/search")
    public CollectionModel<EntityModel<Employee>> search(@RequestParam(name = "email", required = true)
                                                                 String keyword) {
        List<EntityModel<Employee>> employees = service.findByEmail(keyword).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(employees,
                linkTo(methodOn(EmployeeController.class).getAll()).withRel("employees"));
    }

    /**
     * @GetMapping(value = "/employees/search")
     * public CollectionModel<EntityModel<Employee>> search(@RequestParam(name = "name") String keyword) {
     * List<EntityModel<Employee>> employees = service.findByName(keyword).stream()
     * .map(assembler::toModel)
     * .collect(Collectors.toList());
     * return CollectionModel.of(employees,
     * linkTo(methodOn(EmployeeController.class).getAll()).withRel("employees"));
     * }
     */

    @PostMapping()
    public EntityModel<Employee> newEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        var employee = service.saveEmployee(employeeDto);
        return assembler.toModel(employee);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") Long employeeId) {
        service.deleteEmployee(employeeId);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody EmployeeDto employeeDto, @PathVariable long id) {
        service.updateEmployee(employeeDto, id);
        return ResponseEntity.ok().build();
    }

}
