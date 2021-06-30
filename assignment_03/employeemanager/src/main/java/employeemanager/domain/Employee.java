package employeemanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String passportNumber;

    public Employee(String firstName, String lastName, String email, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passportNumber = passportNumber;
    }
}
