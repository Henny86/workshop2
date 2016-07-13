package POJOs;

import java.util.Date;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Factuur {
	
	@Id
	@GeneratedValue
	int factuur_id;
	
	@Column
	private Date factuur_datum;
	
	@Column
	private String factuurNummer;
	
	@ManyToOne
    @JoinColumn(name="Klant_id", nullable=false)
    private Klant klant; 
	
	@OneToOne
	@JoinColumn(name="bestelling_id")
	private Bestelling bestelling;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="factuur")
	private Set<Betaling> betalingSet;
	
	public int getFactuur_id() {
		return factuur_id;
	}
	public void setFactuur_id(int factuur_id) {
		this.factuur_id = factuur_id;
	}
	public Date getFactuur_datum() {
		return factuur_datum;
	}
	public void setFactuur_datum() {
		this.factuur_datum = new java.util.Date();
	}
	public String getFactuurNummer() {
		return factuurNummer;
	}
	public void setFactuurNummer() {
		int length = 10;
		Random random = new Random();
		String characters = "ABCDEFGHIJLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < length; i++) {
			sb.append(characters.charAt(random.nextInt(characters.length())));
		}
		factuurNummer = sb.toString();
	}
	public Klant getKlant() {
		return klant;
	}
	public void setKlant(Klant klant) {
		this.klant = klant;
	}
	public Bestelling getBestelling() {
		return bestelling;
	}
	public void setBestelling(Bestelling bestelling) {
		this.bestelling = bestelling;
	}
	public Set<Betaling> getBetalingSet() {
		return betalingSet;
	}
	public void setBetalingSet(Set<Betaling> betalingSet) {
		this.betalingSet = betalingSet;
	}
	@Override
	public String toString() {
		return "Factuur [factuur_id=" + factuur_id + ", factuurNummer" + factuurNummer + ", factuur_datum=" + factuur_datum + ", klant=" + klant + "]";
	}	
}
