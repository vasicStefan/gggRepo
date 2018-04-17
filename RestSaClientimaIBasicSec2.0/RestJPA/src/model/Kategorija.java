package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the KATEGORIJA database table.
 * 
 */
@Entity
@Table(name="KATEGORIJA")
@NamedQuery(name="Kategorija.findAll", query="SELECT k FROM Kategorija k")
public class Kategorija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkategorije;

	private String naziv;

	//bi-directional many-to-one association to Proizvod
	@OneToMany(mappedBy="kategorija")
	@JsonIgnore
	private List<Proizvod> proizvods;

	public Kategorija() {
	}

	public int getIdkategorije() {
		return this.idkategorije;
	}

	public void setIdkategorije(int idkategorije) {
		this.idkategorije = idkategorije;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Proizvod> getProizvods() {
		return this.proizvods;
	}

	public void setProizvods(List<Proizvod> proizvods) {
		this.proizvods = proizvods;
	}

	public Proizvod addProizvod(Proizvod proizvod) {
		getProizvods().add(proizvod);
		proizvod.setKategorija(this);

		return proizvod;
	}

	public Proizvod removeProizvod(Proizvod proizvod) {
		getProizvods().remove(proizvod);
		proizvod.setKategorija(null);

		return proizvod;
	}

}