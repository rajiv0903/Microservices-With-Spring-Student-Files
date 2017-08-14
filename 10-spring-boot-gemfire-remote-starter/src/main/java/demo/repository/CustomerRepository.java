package demo.repository;

import java.util.List;

import org.springframework.data.gemfire.repository.GemfireRepository;
import org.springframework.data.gemfire.repository.Query;

import demo.model.Customer;
import demo.model.EmailAddress;

public interface CustomerRepository extends GemfireRepository<Customer, Long> {

	List<Customer> findAll();

	List<Customer> findByLastname(String lastname);

	@Query("SELECT * FROM /Customer x where x.emailAddress = $1")
	Customer findByEmailAddress(EmailAddress emailAddress);

}
