package service;

import java.util.List;

import DAOs.AccountDao;
import POJOs.Account;

public class AccountService {
	private static AccountDao accountDao;	
	
	public AccountService() {
		accountDao = new AccountDao();		
	}
	
	public void create(Account account) {		
		accountDao.create(account);		
	}
	
	public void update(Account account) {
		accountDao.update(account);
	}
	
	public Account findByID(int accountID) {
		Account account = accountDao.findByID(accountID);
		return account;
	}
	
	public void delete(Account account) {
		accountDao.delete(account);
	}
	
	public List<Account> findAll() {
		List<Account> accounten = accountDao.findAll();
		return accounten;
	}
}
