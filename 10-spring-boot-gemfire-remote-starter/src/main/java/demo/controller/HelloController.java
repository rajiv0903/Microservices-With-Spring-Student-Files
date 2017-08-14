package demo.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.model.Customer;
import demo.model.EmailAddress;
import demo.repository.CustomerRepository;

@Component
public class HelloController {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    CustomerRepository customerRepository = null;

    public void doSomeStuff(){

        System.out.println("Creating new Customer");
        Customer customer = new Customer(1L,new EmailAddress("customer@customer.com"),"1","Last");
        Customer customer2 = new Customer(2L,new EmailAddress("customer2@customer.com"),"2","Last");
        Customer customer3 = new Customer(3L,new EmailAddress("customer3@customer.com"),"3","Last");

        customerRepository.save(customer);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        List <Customer> customers = customerRepository.findAll();

        System.out.println("Found a few Customers, How Many = " + customers.size());


        Customer customers2 = customerRepository.findByEmailAddress(new EmailAddress("customer@customer.com"));




    }

}
