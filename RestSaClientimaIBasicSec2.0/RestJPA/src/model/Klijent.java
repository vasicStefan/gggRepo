package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the KLIJENT database table.
 * 
 */
@Entity
@Table(name="KLIJENT")
@NamedQuery(name="Klijent.findAll", query="SELECT k FROM Klijent k")
public class Klijent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idklijenta;

	private String ime;

	private String jmbg;

	private String prezime;

	//bi-directional many-to-one association to Ponuda
	@OneToMany(mappedBy="klijent")
	@JsonIgnore
	private List<Ponuda> ponudas;

	//bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy="klijent")
	@JsonIgnore
	private List<Poruka> porukas;

	public Klijent() {
	}

	public int getIdklijenta() {
		return this.idklijenta;
	}

	public void setIdklijenta(int idklijenta) {
		this.idklijenta = idklijenta;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getJmbg() {
		return this.jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Ponuda> getPonudas() {
		return this.ponudas;
	}

	public void setPonudas(List<Ponuda> ponudas) {
		this.ponudas = ponudas;
	}

	public Ponuda addPonuda(Ponuda ponuda) {
		getPonudas().add(ponuda);
		ponuda.setKlijent(this);

		return ponuda;
	}

	public Ponuda removePonuda(Ponuda ponuda) {
		getPonudas().remove(ponuda);
		ponuda.setKlijent(null);

		return ponuda;
	}

	public List<Poruka> getPorukas() {
		return this.porukas;
	}

	public void setPorukas(List<Poruka> porukas) {
		this.porukas = porukas;
	}

	public Poruka addPoruka(Poruka poruka) {
		getPorukas().add(poruka);
		poruka.setKlijent(this);

		return poruka;
	}

	public Poruka removePoruka(Poruka poruka) {
		getPorukas().remove(poruka);
		poruka.setKlijent(null);

		return poruka;
	}

}