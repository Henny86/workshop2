package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DAOs.BetaalwijzeDao;
import POJOs.Betaalwijze;

@Component
public class BetaalwijzeService {
	
	private BetaalwijzeDao betaalwijzeDao;

	public BetaalwijzeService() {
	}

	@Autowired
	public BetaalwijzeService(BetaalwijzeDao betaalwijzeDao) {
		this.betaalwijzeDao = betaalwijzeDao;
	}

	public void create(Betaalwijze betaalwijze) {
		betaalwijzeDao.save(betaalwijze);
	}

	public void update(Betaalwijze betaalwijze) {
		betaalwijzeDao.update(betaalwijze);
	}

	public void delete(Betaalwijze betaalwijze) {
		betaalwijzeDao.delete(betaalwijze);
	}

	public Betaalwijze findById(long id) {
		Betaalwijze betaalwijze = betaalwijzeDao.findByID(id);
		return betaalwijze;
	}

	public List<Betaalwijze> findAll() {
		List<Betaalwijze> betaalwijzen = betaalwijzeDao.findAll();
		return betaalwijzen;
	}

}
