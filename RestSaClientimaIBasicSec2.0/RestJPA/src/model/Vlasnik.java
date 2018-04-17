package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the VLASNIK database table.
 * 
 */
@Entity
@Table(name="VLASNIK")
@NamedQuery(name="Vlasnik.findAll", query="SELECT v FROM Vlasnik v")
public class Vlasnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idvlasnika;

	private String ime;

	private String jmbg;

	private String prezime;

	//bi-directional many-to-one association to Poruka
	@OneToMany(mappedBy="vlasnik")
	@JsonIgnore
	private List<Poruka> porukas;

	//bi-directional many-to-one association to Proizvod
	@OneToMany(mappedBy="vlasnik")
	@JsonIgnore
	private List<Proizvod> proizvods;

	public Vlasnik() {
	}

	public int getIdvlasnika() {
		return this.idvlasnika;
	}

	public void setIdvlasnika(int idvlasnika) {
		this.idvlasnika = idvlasnika;
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

	public List<Poruka> getPorukas() {
		return this.porukas;
	}

	public void setPorukas(List<Poruka> porukas) {
		this.porukas = porukas;
	}

	public Poruka addPoruka(Poruka poruka) {
		getPorukas().add(poruka);
		poruka.setVlasnik(this);

		return poruka;
	}

	public Poruka removePoruka(Poruka poruka) {
		getPorukas().remove(poruka);
		poruka.setVlasnik(null);

		return poruka;
	}

	public List<Proizvod> getProizvods() {
		return this.proizvods;
	}

	public void setProizvods(List<Proizvod> proizvods) {
		this.proizvods = proizvods;
	}

	public Proizvod addProizvod(Proizvod proizvod) {
		getProizvods().add(proizvod);
		proizvod.setVlasnik(this);

		return proizvod;
	}

	public Proizvod removeProizvod(Proizvod proizvod) {
		getProizvods().remove(proizvod);
		proizvod.setVlasnik(null);

		return proizvod;
	}

}