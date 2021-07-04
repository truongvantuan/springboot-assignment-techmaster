package employeeclient.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@NoArgsConstructor
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

    private String profileImg;

    private String passportNumber;

    public Employee(String firstName, String lastName, String email, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passportNumber = passportNumber;
    }

}

