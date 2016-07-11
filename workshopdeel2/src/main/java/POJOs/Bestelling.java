package POJOs;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import POJOs.BestelArtikel;

@Entity
@Table
public class Bestelling {

	@Id
	@GeneratedValue
	private int bestelling_id;

	@Column
	String bestelNummer;

	@Column
	private Date bestel_datum;

	@ManyToOne
	@JoinColumn(name = "klant_id", nullable = false)
	private Klant klant;

	@OneToMany(mappedBy = "bestelling", targetEntity = BestelArtikel.class, fetch = FetchType.EAGER)
	private Set<BestelArtikel> bestelArtikelSet;

	@OneToOne
	@JoinColumn(name = "factuur_id")
	private Factuur factuurSet;

	public int getBestelling_id() {
		return bestelling_id;
	}

	public void setBestelling_id(int bestelling_id) {
		this.bestelling_id = bestelling_id;
	}

	public String getBestelNummer() {
		return bestelNummer;
	}

	public void setBestelNummer() {
		int length = 10;
		Random random = new Random();
		String characters = "ABCDEFGHIJLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++) {
			sb.append(characters.charAt(random.nextInt(characters.length())));
		}
		bestelNummer = sb.toString();
	}

	public Date getBestel_datum() {
		return bestel_datum;
	}

	public void setBestel_datum() {
		this.bestel_datum = new java.util.Date();
	}

	public Set<BestelArtikel> getBestelArtikelSet() {
		return bestelArtikelSet;
	}

	public void setBestelArtikelSet(Set<BestelArtikel> bestelArtikelSet) {
		this.bestelArtikelSet = bestelArtikelSet;
	}

	public Klant getKlant() {
		return klant;
	}

	public void setKlant(Klant klant) {
		this.klant = klant;
	}

	public Factuur getFactuurSet() {
		return factuurSet;
	}

	public void setFactuurSet(Factuur factuurSet) {
		this.factuurSet = factuurSet;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(37, 41).append(bestelling_id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Bestelling))
			return false;
		if (obj == this)
			return true;

		Bestelling anderArtikel = (Bestelling) obj;
		return new EqualsBuilder().append(bestelling_id, anderArtikel.getBestelling_id()).isEquals();
	}

	@Override
	public String toString() {
		return "Bestelling [bestelling_id=" + bestelling_id + ", bestelNummer=" + bestelNummer + ", bestel_datum="
				+ bestel_datum + ", klant=" + klant + "]";
	}
}
