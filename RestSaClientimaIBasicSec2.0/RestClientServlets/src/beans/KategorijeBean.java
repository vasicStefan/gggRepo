package beans;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.jboss.security.Base64Encoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Kategorija;

public class KategorijeBean {

	List<Kategorija> kategorije;

	public KategorijeBean() throws IOException {
System.out.println("aaaa");
		URL url = new URL("http://localhost:8080/RestServiceFormAuth/rest/restic/vratiSveKategorije");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

//		String cred = "user:user";
//		
//		String basicAuth = "Basic " + new String(new Base64Encoder().encode(cred.getBytes()));
//
//		conn.setRequestProperty("Authorization", basicAuth);
		conn.connect();

		InputStream is = conn.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		kategorije = mapper.readValue(is,
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
