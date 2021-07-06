package employeeclient.dto.mapper;

import employeeclient.dto.model.Employee;
import employeeclient.dto.model.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public static EmployeeDto toEmployeeDto(Employee employee) {
        return new EmployeeDto()
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setEmail(employee.getEmail())
                .setPassportNumber(employee.getPassportNumber());
    }
}
