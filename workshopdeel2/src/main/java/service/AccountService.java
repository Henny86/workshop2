package service;

import java.util.List;

import DAOs.AccountDao;
import POJOs.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class AccountService {
    
	private  AccountDao accountDao;	
	
        public AccountService() {
				
	}
        
        @Autowired
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;		
	}
	
	public void create(Account account) {		
		accountDao.save(account);		
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
