package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DAOs.AdresDao;
import POJOs.Adres;

@Component
public class AdresService {

	private AdresDao adresDao;

	public AdresService() {
	}

	@Autowired
	public AdresService(AdresDao adresDao) {
		this.adresDao = adresDao;
	}

	public void create(Adres adres) {
		adresDao.save(adres);
	}

	public void update(Adres adres) {
		adresDao.update(adres);
	}

	public void delete(Adres adres) {
		adresDao.delete(adres);
	}

	public Adres findById(long id) {
		Adres adres = adresDao.findByID(id);
		return adres;
	}

	public List<Adres> findAll() {
		List<Adres> adressen = adresDao.findAll();
		return adressen;
	}

}
