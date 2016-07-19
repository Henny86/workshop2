package POJOs;


import java.io.Serializable;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;


@Entity
@Table
@Component
public class Artikel implements Serializable {

	@Id
	@GeneratedValue
    private Integer artikelID = 0;
 
    @Column
    @NotNull
    private Double artikelPrijs = 0.0;
  
    @Column
    @NotNull
    private String artikelNaam;
    @Column
    private String artikelBeschrijving;
    @Column
    private String artikelNummer;
    
    public Artikel() {}

	public Integer getArtikelID() {
		return artikelID;
	}

	public void setArtikelID(Integer artikelID) {
		this.artikelID = artikelID;
	}

	public Double getArtikelPrijs() {
		return artikelPrijs;
	}

	public void setArtikelPrijs(Double artikelPrijs) {
		this.artikelPrijs = artikelPrijs;
	}

	public String getArtikelNaam() {
		return artikelNaam;
	}

	public void setArtikelNaam(String artikelNaam) {
		this.artikelNaam = artikelNaam;
	}

    public String getArtikelBeschrijving() {
		return artikelBeschrijving;
	}

	public void setArtikelBeschrijving(String artikelBeschrijving) {
		this.artikelBeschrijving = artikelBeschrijving;
	}

	public String getArtikelNummer() {
		return artikelNummer;
	}

	public void setArtikelNummer() {
		int length = 10;
		Random random = new Random();
		String characters = "ABCDEFGHIJLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < length; i++) {
			sb.append(characters.charAt(random.nextInt(characters.length())));
		}
		artikelNummer = sb.toString();
	}
	
	@Override
    public int hashCode() {
        return new HashCodeBuilder(11, 29).append(artikelID).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Artikel))
            return false;
        if (obj == this)
            return true;

        Artikel anderArtikel = (Artikel) obj;
        return new EqualsBuilder().
            append(artikelID, anderArtikel.getArtikelID()).
            isEquals();
    }

	@Override
	public String toString() {
		return "Artikel [artikelID=" + artikelID + ", artikelNummer=" + artikelNummer + ", artikelPrijs=" + artikelPrijs + ", artikelNaam=" + artikelNaam
				+ ", artikelBeschrijving=" + artikelBeschrijving + "]";
	}        
}
