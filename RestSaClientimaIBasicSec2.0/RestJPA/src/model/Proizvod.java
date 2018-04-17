package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the PROIZVOD database table.
 * 
 */
@Entity
@Table(name="PROIZVOD")
@NamedQuery(name="Proizvod.findAll", query="SELECT p FROM Proizvod p")
public class Proizvod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproizvoda;

	private byte aktivan;

	private String opis;

	private double pocetnacena;

	//bi-directional many-to-one association to Ponuda
	@OneToMany(mappedBy="proizvod")
	@JsonIgnore
	private List<Ponuda> ponudas;

	//bi-directional many-to-one association to Kategorija
	@ManyToOne
	@JoinColumn(name="IDKATEGORIJE")
	@JsonIgnore
	private Kategorija kategorija;

	//bi-directional many-to-one association to Vlasnik
	@ManyToOne
	@JoinColumn(name="IDVLASNIKA")
	private Vlasnik vlasnik;

	public Proizvod() {
	}

	public int getIdproizvoda() {
		return this.idproizvoda;
	}

	public void setIdproizvoda(int idproizvoda) {
		this.idproizvoda = idproizvoda;
	}

	public byte getAktivan() {
		return this.aktivan;
	}

	public void setAktivan(byte aktivan) {
		this.aktivan = aktivan;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public double getPocetnacena() {
		return this.pocetnacena;
	}

	public void setPocetnacena(double pocetnacena) {
		this.pocetnacena = pocetnacena;
	}

	public List<Ponuda> getPonudas() {
		return this.ponudas;
	}

	public void setPonudas(List<Ponuda> ponudas) {
		this.ponudas = ponudas;
	}

	public Ponuda addPonuda(Ponuda ponuda) {
		getPonudas().add(ponuda);
		ponuda.setProizvod(this);

		return ponuda;
	}

	public Ponuda removePonuda(Ponuda ponuda) {
		getPonudas().remove(ponuda);
		ponuda.setProizvod(null);

		return ponuda;
	}

	public Kategorija getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Vlasnik getVlasnik() {
		return this.vlasnik;
	}

	public void setVlasnik(Vlasnik vlasnik) {
		this.vlasnik = vlasnik;
	}

}