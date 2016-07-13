package POJOs;

import java.io.Serializable;
import java.util.Date;

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
public class Betaling implements Serializable {
	
	@Id
	@GeneratedValue
	private int betaling_id;
	
	@Column
	private Date betaal_datum;
	
	@ManyToOne
    @JoinColumn(name="betaalwijze_id", nullable=false, insertable=false, updatable=false)
	private Betaalwijze betaalwijze;
	
	@ManyToOne
	@JoinColumn(name="klant_id", insertable=false, updatable=false)
	private Klant klant;
	
	@OneToOne
    @JoinColumn(name="factuur_id")
	private Factuur factuur;
	
	private String betalingsGegevens;	

	public int getBetaling_id() {
		return betaling_id;
	}

	public void setBetaling_id(int betaling_id) {
		this.betaling_id = betaling_id;
	}

	public Date getBetaal_datum() {
		return betaal_datum;
	}

	public void setBetaal_datum() {
		this.betaal_datum = new java.util.Date();
	}

	public Betaalwijze getBetaalwijze() {
		return betaalwijze;
	}

	public void setBetaalwijze(Betaalwijze betaalwijze) {
		this.betaalwijze = betaalwijze;
	}

	public Klant getKlant() {
		return klant;
	}

	public void setKlant(Klant klant) {
		this.klant = klant;
	}

	public Factuur getFactuur() {
		return factuur;
	}

	public void setFactuur(Factuur factuur) {
		this.factuur = factuur;
	}

	public String getBetalingsGegevens() {
		return betalingsGegevens;
	}

	public void setBetalingsGegevens(String betalingsGegevens) {
		this.betalingsGegevens = betalingsGegevens;
	}

	@Override
	public String toString() {
		return "Betaling [betaling_id=" + betaling_id + ", betaal_datum=" + betaal_datum + ", klant=" + klant
				+ ", betalingsGegevens=" + betalingsGegevens + "]";
	}
}
