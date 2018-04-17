package servlets;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Kategorija;
import model.Proizvod;

public class AktivniBean {
	private List<Kategorija> kategorije;

	public AktivniBean() throws Exception {

		URL url = new URL("http://localhost:8080/RestPrimer/rest/impl/vratiSveKategorije");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		InputStream in = conn.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		kategorije = mapper.readValue(in,
				mapper.getTypeFactory().constructCollectionType(List.class, Kategorija.class));
		conn.disconnect();

	}

	public List<Kategorija> getKategorije() {
		return kategorije;
	}

	public void setKategorije(List<Kategorija> kategorije) {
		this.kategorije = kategorije;
	}

}
