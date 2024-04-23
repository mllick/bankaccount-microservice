package net.sarrlick.customerservice.ripository;


import net.sarrlick.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

