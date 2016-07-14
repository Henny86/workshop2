package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DAOs.BetalingDao;
import POJOs.Betaling;

@Component
public class BetalingService {
	
	private BetalingDao betalingDao;

	public BetalingService() {
	}

	@Autowired
	public BetalingService(BetalingDao betalingDao) {
		this.betalingDao = betalingDao;
	}

	public void create(Betaling betaling) {
		betalingDao.save(betaling);
	}

	public void update(Betaling betaling) {
		betalingDao.update(betaling);
	}

	public void delete(Betaling betaling) {
		betalingDao.delete(betaling);
	}

	public Betaling findById(long id) {
		Betaling betaling = betalingDao.findByID(id);
		return betaling;
	}

	public List<Betaling> findAll() {
		List<Betaling> betalingen = betalingDao.findAll();
		return betalingen;
	}

}
