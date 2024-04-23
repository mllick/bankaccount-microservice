package net.sarrlick.customerservice;

import net.sarrlick.customerservice.config.GlobalConfig;
import net.sarrlick.customerservice.entities.Customer;
import net.sarrlick.customerservice.ripository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository CustomerRepository) {
        return args -> {

            List<Customer> customerList=List.of(
                    Customer.builder()
                            .firstName("John")
                            .lastName("Doe")
                            .email("joe@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Joel")
                            .lastName("Dacosta")
                            .email("joel.dacos@gmail.com")
                            .build()

            );
            CustomerRepository.saveAll(customerList);
        };
    }
}
