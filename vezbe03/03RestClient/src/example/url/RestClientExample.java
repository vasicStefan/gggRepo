package example.url;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Kategorija;

public class RestClientExample {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:8080/02Rest/rest/impl/kategorije");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		InputStream in = conn.getInputStream();

		ObjectMapper mapper = new ObjectMapper();
		List<Kategorija> kategorije = mapper.readValue(in,
				mapper.getTypeFactory().constructCollectionType(List.class, Kategorija.class));

		for (Kategorija k : kategorije)
			System.out.println(k.getNaziv());

		conn.disconnect();

	}

}
