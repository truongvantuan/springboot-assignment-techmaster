package employeeclient.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "First name must not be empty!")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty!")
    private String lastName;

    @NotBlank(message = "Email must not be blank!")
    @Email(message = "Email must be a valid email address")
    private String email;

    private String photoUrls;

    @NotEmpty(message = "Please provide a valid Passport Number")
    private String passportNumber;

    public Employee(String firstName, String lastName, String email, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passportNumber = passportNumber;
    }

    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }

}

