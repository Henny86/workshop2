package DAOs;

import java.util.List;

import POJOs.Account;
import helpers.HibernateUtil;

public class AccountDao {
	HibernateUtil util = new HibernateUtil();
	
	public void create(Account account) {
		util.openCurrentSessionWithTransaction();
		util.getCurrentSession().save(account);
		util.closeCurrentSessionWithTransaction();
	}
	
	public void update(Account account) {
		util.openCurrentSessionWithTransaction();
		util.getCurrentSession().update(account);
		util.closeCurrentSessionWithTransaction();
	}
	
	public Account findByID(int accountID) {
		util.openCurrentSession();
		Account account = util.getCurrentSession().get(Account.class, accountID);
		util.closeCurrentSession();
		return account;
	}
	
	public void delete(Account account) {
		util.openCurrentSessionWithTransaction();
		util.getCurrentSession().delete(account);
		util.closeCurrentSessionWithTransaction();
	}
	
	@SuppressWarnings("unchecked")
	public List<Account> findAll() {
		util.openCurrentSession();
		List<Account> accounten = (List<Account>)util.getCurrentSession().createQuery("from " + Account.class.getSimpleName()).list();
		util.closeCurrentSession();
                return accounten;
	}
}
