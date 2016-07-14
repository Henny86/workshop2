package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DAOs.AdresTypeDao;
import POJOs.AdresType;

@Component
public class AdresTypeService {
	private AdresTypeDao adresTypeDao;

	public AdresTypeService() {
	}

	@Autowired
	public AdresTypeService(AdresTypeDao adresTypeDao) {
		this.adresTypeDao = adresTypeDao;
	}

	public void create(AdresType adresType) {
		adresTypeDao.save(adresType);
	}

	public void update(AdresType adresType) {
		adresTypeDao.update(adresType);
	}

	public void delete(AdresType adresType) {
		adresTypeDao.delete(adresType);
	}

	public AdresType findById(long id) {
		AdresType adresTypes = adresTypeDao.findByID(id);
		return adresTypes;
	}

	public List<AdresType> findAll() {
		List<AdresType> adresTypes = adresTypeDao.findAll();
		return adresTypes;
	}

}
