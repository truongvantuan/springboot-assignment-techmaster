package employeeclient.repository;


import employeeclient.dto.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Loading Database: "
                    + repository.save(new Employee("Van Tuan", "Truong",
                    "truongvantuan@outlook.com.vn", "123456789")));
            log.info("Loading Database: "
                    + repository.save(new Employee("Laurette", "Tybalt",
                    "ltybalt0@stanford.edu", "987654321")));
            log.info("Loading Database: "
                    + repository.save(new Employee("Nghe Muu", "Truong",
                    "nghemuu@china.com.vn", "793847555")));
            log.info("Loading Database: "
                    + repository.save(new Employee("Tyson", "Haldon",
                    "thaldon0@economist.com", "457568567")));
        };
    }
}
