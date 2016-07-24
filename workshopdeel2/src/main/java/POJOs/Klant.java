package POJOs;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "klant")
@Component
public class Klant implements Serializable {
	
	@Id
	@GeneratedValue
	private long klant_id;
	
	@Column
    private String voornaam, achternaam, tussenvoegsel, email;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="klant")
	Set<Bestelling> bestellingSet;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="klant")
	Set<Account> accountSet;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="klant")
	Set<Factuur> factuurSet;	
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@MapKeyJoinColumn(name="adres_adres_id")
	@JoinTable(name="klant_has_adres", 
		joinColumns={@JoinColumn(name="klant_klant_id")}, 
		inverseJoinColumns={@JoinColumn(name="adres_type_id")})
	Map<Adres, AdresType> adressen = new HashMap();

    public long getKlantID() {
        return klant_id;
    }

    public void setKlantID(long klantID) {
        this.klant_id = klantID;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    

    public Set<Bestelling> getBestellingSet() {
		return bestellingSet;
	}

	public void setBestellingSet(Set<Bestelling> bestellingSet) {
		this.bestellingSet = bestellingSet;
	}

	public Set<Account> getAccountSet() {
		return accountSet;
	}

	public void setAccountSet(Set<Account> accountSet) {
		this.accountSet = accountSet;
	}

	public Set<Factuur> getFactuurSet() {
		return factuurSet;
	}

	public void setFactuurSet(Set<Factuur> factuurSet) {
		this.factuurSet = factuurSet;
	}
        public Map<Adres, AdresType> getAdressen() {
            return adressen;
        }

	@Override
    public String toString() {
        return "Klant{" + "klantID=" + klant_id + ", voornaam=" + voornaam + 
                ", achternaam=" + achternaam + ", tussenvoegsel=" + tussenvoegsel + ", email=" + email + '}';
    }
}
