package POJOs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Account {
	
	@Id
	@GeneratedValue
	int account_id;
	
	@Column
	String naam;
	
	@ManyToOne
    @JoinColumn(name="Klant_id", nullable=false)
    private Klant klant;
	
	@Column
	Date create_datum;
	
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public Klant getKlant() {
		return klant;
	}
	public void setKlant(Klant klant) {
		this.klant = klant;
	} 
	public Date getCreate_datum() {
		return create_datum;
	}
	public void setCreate_datum() {
		this.create_datum = new java.util.Date();
	} 
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", naam=" + naam + ", klant=" + klant + ", create_datum="
				+ create_datum + "]";
	}
}
