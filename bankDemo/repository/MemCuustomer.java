package repository;

import java.text.CollationKey;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Service.CustomerRepository;
import domain.Customer;

public class MemCuustomer implements CustomerRepository {
	private static long nextId; 
	private Map<String, Customer> repo = new HashMap<>();
	
	@Override
	public Customer addCustomer(String customerName) {
		String customerId = "C" + ++nextId;
		Customer c = new Customer(customerName, customerName);
		repo.putIfAbsent(customerId, c);
		return c;
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		try {
		repo.replace(cust.getCode(), cust);
		}catch (Exception e) {

			return null;		
			}
		return cust;
	}

	@Override
	public Customer findCustomer(String customerid) {

		return repo.get(customerid);
	}

	@Override
	public Collection<Customer> listAllCustomer() {
	
		return repo.values();
	}

}
