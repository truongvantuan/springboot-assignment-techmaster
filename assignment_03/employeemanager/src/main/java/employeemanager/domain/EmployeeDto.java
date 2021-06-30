package employeemanager.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class EmployeeDto {

    @NotEmpty(message = "First name must not be empty!")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty!")
    private String lastName;

    @NotBlank(message = "Email must not be blank!")
    @Email(message = "Email must be a valid email address")
    private String email;

    private String passportNumber;

    public static Employee mapDtoToObject(EmployeeDto employeeDto) {
        var newEmployee = new Employee();
        newEmployee.setFirstName(employeeDto.getFirstName());
        newEmployee.setLastName(employeeDto.getLastName());
        newEmployee.setEmail(employeeDto.getEmail());
        newEmployee.setPassportNumber(employeeDto.getPassportNumber());
        return newEmployee;
    }
}
