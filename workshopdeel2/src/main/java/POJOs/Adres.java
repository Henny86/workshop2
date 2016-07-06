package POJOs;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;



@Entity
@Table
public class Adres {
	
	@Id
	@GeneratedValue
	private int adres_id;
    
	@Column
    private String straatnaam, postcode, toevoeging, woonplaats;
    
	@Column
    private int huisnummer;  
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="klant_has_adres", 
		joinColumns={@JoinColumn(name="adre_adres_id")}, 
		inverseJoinColumns={@JoinColumn(name="adres_type_id")})
	private Set<AdresType> adresTypes;
    
    public Adres() {}

	public int getAdres_id() {
		return adres_id;
	}

	public void setAdres_id(int adres_id) {
		this.adres_id = adres_id;
	}

	public String getStraatnaam() {
		return straatnaam;
	}

	public void setStraatnaam(String straatnaam) {
		this.straatnaam = straatnaam;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getToevoeging() {
		return toevoeging;
	}

	public void setToevoeging(String toevoeging) {
		this.toevoeging = toevoeging;
	}

	public int getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}
	
    public Set<AdresType> getAdresTypes() {
		return adresTypes;
	}

	public void setAdresTypes(Set<AdresType> adresTypes) {
		this.adresTypes = adresTypes;
	}

	@Override
    public int hashCode() {
        return new HashCodeBuilder(13, 45).append(straatnaam).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Adres))
            return false;
        if (obj == this)
            return true;

        Adres nieuwAdres = (Adres) obj;
        return new EqualsBuilder().
            append(straatnaam, nieuwAdres.getStraatnaam()).
            append(postcode, nieuwAdres.getPostcode() ).
            append(huisnummer, nieuwAdres.getHuisnummer() ). 
                append(woonplaats, nieuwAdres.getWoonplaats() ).
                append(toevoeging, nieuwAdres.getToevoeging() ).
            isEquals();
    }

	@Override
	public String toString() {
		return "Adres [adres_id=" + adres_id + ", straatnaam=" + straatnaam + ", postcode=" + postcode + ", toevoeging="
				+ toevoeging + ", huisnummer=" + huisnummer + ", woonplaats=" + woonplaats + "]";
	}
        
}
