package POJOs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bestelling_has_artikel")
public class BestelArtikel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long bestelling_artikel_id;

	@ManyToOne
	@JoinColumn(name = "artikel_artikel_id", nullable = false)
	private Artikel artikel;

	@ManyToOne
	@JoinColumn(name = "bestelling_bestelling_id", nullable = false)
	private Bestelling bestelling;

	@Column
	private int artikel_aantal;

	public long getBestelling_artikel_id() {
		return bestelling_artikel_id;
	}

	public void setBestelling_artikel_id(long bestelling_artikel_id) {
		this.bestelling_artikel_id = bestelling_artikel_id;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public Bestelling getBestelling() {
		return bestelling;
	}

	public void setBestelling(Bestelling bestelling) {
		this.bestelling = bestelling;
	}

	public int getArtikel_aantal() {
		return artikel_aantal;
	}

	public void setArtikel_aantal(int artikel_aantal) {
		this.artikel_aantal = artikel_aantal;
	}
	public String toString() {
		return "BestellingArtikelId: " + getBestelling_artikel_id() + "\nBestelling: " + getBestelling()
			+ "\nArtikel: " + getArtikel() + "\nArtikelaantal: " + getArtikel_aantal();			
	}
}
