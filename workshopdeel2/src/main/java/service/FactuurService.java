package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DAOs.FactuurDao;
import POJOs.Factuur;

@Component
public class FactuurService {

	private FactuurDao factuurDao;

	public FactuurService() {
	}

	@Autowired
	public FactuurService(FactuurDao factuurDao) {
		this.factuurDao = factuurDao;
	}

	public void create(Factuur factuur) {
		factuurDao.save(factuur);
	}

	public void update(Factuur factuur) {
		factuurDao.update(factuur);
	}

	public void delete(Factuur factuur) {
		factuurDao.delete(factuur);
	}

	public Factuur findById(long id) {
		Factuur factuur = factuurDao.findByID(id);
		return factuur;
	}

	public List<Factuur> findAll() {
		List<Factuur> facturen = factuurDao.findAll();
		return facturen;
	}

}
