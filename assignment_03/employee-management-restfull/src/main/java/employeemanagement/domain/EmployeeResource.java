package employeemanagement.domain;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
public class EmployeeResource extends RepresentationModel {

    private final Employee employee;


    public EmployeeResource(Employee employee) {
        this.employee = employee;
        Long id = employee.getId();
    }
}

