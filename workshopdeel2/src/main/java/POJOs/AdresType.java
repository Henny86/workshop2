package POJOs;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class AdresType {
	
	@Id
	@GeneratedValue
	private int adres_type_id;
	
	@Column
	private String adres_type;
	
	@ManyToMany
	private Set<Adres> adressen;
	
	private static final String[] type = {"Post adres", "Factuur adres", "Bezoek adres"};

	public int getAdres_type_id() {
		return adres_type_id;
	}

	public void setAdres_type_id(int adres_type_id) {
		this.adres_type_id = adres_type_id;
	}

	public String getAdres_type() {
		return adres_type;
	}

	public void setAdres_type(int adres_type) {
		this.adres_type = type[adres_type];
	}

	public static String[] getType() {
		return type;
	}	
	
	public Set<Adres> getAdressen() {
		return adressen;
	}

	public void setAdressen(Set<Adres> adressen) {
		this.adressen = adressen;
	}

	@Override
	public String toString() {
		return "AdresType [adres_type_id=" + adres_type_id + ", adres_type=" + adres_type + "]";
	}	
	
}
