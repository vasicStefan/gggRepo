package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PORUKA database table.
 * 
 */
@Entity
@Table(name="PORUKA")
@NamedQuery(name="Poruka.findAll", query="SELECT p FROM Poruka p")
public class Poruka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idporuke;

	private String datumporuke;

	private String sadrzaj;

	//bi-directional many-to-one association to Klijent
	@ManyToOne
	@JoinColumn(name="IDKLIJENTA")
	private Klijent klijent;

	//bi-directional many-to-one association to Vlasnik
	@ManyToOne
	@JoinColumn(name="IDVLASNIKA")
	private Vlasnik vlasnik;

	public Poruka() {
	}

	public int getIdporuke() {
		return this.idporuke;
	}

	public void setIdporuke(int idporuke) {
		this.idporuke = idporuke;
	}

	public String getDatumporuke() {
		return this.datumporuke;
	}

	public void setDatumporuke(String datumporuke) {
		this.datumporuke = datumporuke;
	}

	public String getSadrzaj() {
		return this.sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public Klijent getKlijent() {
		return this.klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public Vlasnik getVlasnik() {
		return this.vlasnik;
	}

	public void setVlasnik(Vlasnik vlasnik) {
		this.vlasnik = vlasnik;
	}

}