package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import Service.AccountRepository;
import domain.Account;

public class MemAccountRepo implements AccountRepository{
	private static long nextCode = 0;
	private final Map<String, Account> repo = new HashMap<>();
	@Override
	public Account addAccount(String ownerId) {
		String accountCode = "A" + ++nextCode;
	
		Account acc = new Account(accountCode, ownerId, 0.0);
		if(repo.putIfAbsent(accountCode, acc) == null) return acc;
		return null;
		
		
	}

	@Override
	public Account updateAccount(Account accountCode) {
		try {
			repo.replace(accountCode.geCode(), accountCode);
			}catch (Exception e) {

				return null;		
				}
			return accountCode;
	}

	@Override
	public Account findAccount(String accountCode) {
		return repo.get(accountCode);
	}

	@Override
	public Collection<Account> listAllAccount() {
		return repo.values();
	}

	@Override
	public Collection<Account> listAccountOwnByname(String ownerId) {
		return repo.values()
		.stream()
		.filter(a -> a.getownercode()
				.equals(ownerId)).toList();
	}

}
