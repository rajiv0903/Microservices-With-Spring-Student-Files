package demo.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;
import org.springframework.util.Assert;

@Region("Customer")
public class Customer implements Serializable{

	 private static final long serialVersionUID = -3860687524824507124L;

	    private EmailAddress emailAddress;
	    private String firstname, lastname;
	    private Set<Address> addresses = new HashSet<Address>();

	    @Id
	    private Long id;

	 
	    public Customer(Long id, EmailAddress emailAddress, String firstname, String lastname) {
	        Assert.hasText(firstname, "Firstname must not be null or empty!");
	        Assert.hasText(lastname, "Lastname must not be null or empty!");
	        Assert.notNull(emailAddress, "Email ID must not be null or empty!");

	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.emailAddress = emailAddress;
	        this.id = id;
	    }

	    protected Customer() {
	    }

	    public void add(Address address) {

	        Assert.notNull(address, "Address can not be null");
	        this.addresses.add(address);
	    }

	    public String getFirstname() {
	        return firstname;
	    }

	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }
	    
	    public EmailAddress getEmailAddress() {
	        return emailAddress;
	    }

	    public void setEmailAddress(EmailAddress emailAddress) {
	        this.emailAddress = emailAddress;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Set<Address> getAddresses() {
	        return Collections.unmodifiableSet(addresses);
	    }

	    @Override
	    public String toString() {
	        return "Customer{" +
	                "emailAddress=" + emailAddress +
	                ", firstname='" + firstname + '\'' +
	                ", lastname='" + lastname + '\'' +
	                ", addresses=" + addresses +
	                '}';
	    }
}
