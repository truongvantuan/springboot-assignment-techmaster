package employeeclient.dto.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class EmployeeDto {

    private String firstName;

    private String lastName;

    private String email;

    private String passportNumber;

    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }
}
