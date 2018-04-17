package model;

public class PorukaData {

	// klijent, vlasnik, sadrzaj, datum

	private int idKlijenta;
	private int idVlasnika;
	private String sadrzaj;
	private String date;

	public PorukaData() {
	}

	public PorukaData(int idKlijenta, int idVlasnika, String sadrzaj, String date) {
		super();
		this.idKlijenta = idKlijenta;
		this.idVlasnika = idVlasnika;
		this.sadrzaj = sadrzaj;
		this.date = date;
	}

	public int getIdKlijenta() {
		return idKlijenta;
	}

	public void setIdKlijenta(int idKlijenta) {
		this.idKlijenta = idKlijenta;
	}

	public int getIdVlasnika() {
		return idVlasnika;
	}

	public void setIdVlasnika(int idVlasnika) {
		this.idVlasnika = idVlasnika;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
