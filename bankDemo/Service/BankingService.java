package Service; //Application

import java.util.Collection;
import java.util.List;
import java.util.Set;

import domain.Account;
import domain.Customer;

public class BankingService {
	private AccountRepository accounts;
	private CustomerRepository customers;
	
	public BankingService(AccountRepository a,CustomerRepository c) {
		accounts = a;
		customers = c;
		//make it can write in db or flie or memory
	}

	

	public Account addAccount(String ownerId) {
		if (ownerId == null) return null;
		if(findCustomer(ownerId) == null) return null;
		return accounts.addAccount(ownerId);
	}


	public Account deposit(String accountCode,double deposit) {
		Account a = findAccount(accountCode);
		if(!a.deposit(deposit))return null;
		return accounts.updateAccount(a);
	}

	public Account findAccount(String accountCode) {
		if(accountCode == null)return null;
		return accounts.findAccount(accountCode);
	}

	public Collection<Account> listAllAccount() {
		return accounts.listAllAccount();
	}

	public Collection<Account> listAccountOwnByname(String ownerId) {
		return accounts.listAccountOwnByname(ownerId);
	}

	public Customer registerCustomer(String customerName) {
		if (customerName == null) return null;
		return customers.addCustomer(customerName);
	}

	public Customer renameCustomer(String customerId,String name ) {
		if(customerId == null ||  name == null)return null;
		Customer c = customers.findCustomer(customerId);
		c.setName(name);
		return customers.updateCustomer(c);
	}

	public Customer findCustomer(String customerid) {
		if(customerid == null)return null;
		return customers.findCustomer(customerid);
	}

	public Collection<Customer> listAllCustomer() {
		return customers.listAllCustomer();
	}
	
}
