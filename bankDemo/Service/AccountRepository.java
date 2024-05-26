package Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import domain.Account;

public interface AccountRepository {
	public Account addAccount(String ownerId);
	public Account updateAccount(Account accountCode);
	public Account findAccount(String accountCode);
	public Collection<Account> listAllAccount();
	public Collection<Account> listAccountOwnByname(String ownerId);
	 
}
