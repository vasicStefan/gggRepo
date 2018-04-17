package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PONUDA database table.
 * 
 */
@Entity
@Table(name="PONUDA")
@NamedQuery(name="Ponuda.findAll", query="SELECT p FROM Ponuda p")
public class Ponuda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idponude;

	private String datumponude;

	private double iznos;

	//bi-directional many-to-one association to Proizvod
	@ManyToOne
	@JoinColumn(name="IDPROIZVODA")
	private Proizvod proizvod;

	//bi-directional many-to-one association to Klijent
	@ManyToOne
	@JoinColumn(name="IDKLIJENTA")
	private Klijent klijent;

	public Ponuda() {
	}

	public int getIdponude() {
		return this.idponude;
	}

	public void setIdponude(int idponude) {
		this.idponude = idponude;
	}

	public String getDatumponude() {
		return this.datumponude;
	}

	public void setDatumponude(String datumponude) {
		this.datumponude = datumponude;
	}

	public double getIznos() {
		return this.iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public Proizvod getProizvod() {
		return this.proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public Klijent getKlijent() {
		return this.klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

}