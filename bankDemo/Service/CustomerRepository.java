package Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import domain.Customer;

public interface CustomerRepository {
 public Customer addCustomer(String customerName);
 public Customer updateCustomer(Customer cust);
 public Customer findCustomer(String customerid);
 public Collection<Customer> listAllCustomer();
}
