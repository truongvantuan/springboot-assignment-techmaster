package employeemanager.domain;

import lombok.Data;

@Data
public class EmployeeDto {

    private String firstName;
    private String lastName;
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
