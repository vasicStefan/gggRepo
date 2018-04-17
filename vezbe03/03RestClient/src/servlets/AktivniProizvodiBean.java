package servlets;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Kategorija;
import model.Proizvod;

public class AktivniProizvodiBean {

	private List<Proizvod> proizvodi;

	public AktivniProizvodiBean() throws Exception {

		URL url = new URL("http://localhost:8080/RestPrimer/rest/impl/vratiSveAktivneProizvode");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		InputStream in = conn.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		proizvodi = mapper.readValue(in,
				mapper.getTypeFactory().constructCollectionType(List.class, Proizvod.class));
		System.out.println(proizvodi.size());
		conn.disconnect();

	}
	
	public List<Proizvod> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(List<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}
	
	
}
