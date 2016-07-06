package POJOs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Betaalwijze {
	
	@Id
	@GeneratedValue
	private int betaalwijze_id;
	
	@Column
	private Date betaal_datum;
	
	@Column
	private String betaalwijze;
	
	private static final String[] wijze = {"Contant", "Pin betaling", "IDeal", "Creditcard"};

	public int getBetaalwijze_id() {
		return betaalwijze_id;
	}

	public void setBetaalwijze_id(int betaalwijze_id) {
		this.betaalwijze_id = betaalwijze_id;
	}

	public Date getBetaal_datum() {
		return betaal_datum;
	}

	public void setBetaal_datum(Date betaal_datum) {
		this.betaal_datum = betaal_datum;
	}

	public String getBetaalwijze() {
		return betaalwijze;
	}

	public void setBetaalwijze(int betaalwijze) {
		this.betaalwijze = wijze[betaalwijze];
	}

	public static String[] getWijze() {
		return wijze;
	}

	@Override
	public String toString() {
		return "Betaalwijze [betaalwijze_id=" + betaalwijze_id + ", betaal_datum=" + betaal_datum + ", betaalwijze="
				+ betaalwijze + "]";
	}
}
