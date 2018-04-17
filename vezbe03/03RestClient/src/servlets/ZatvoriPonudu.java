package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.PorukaData;

/**
 * Servlet implementation class ZatvoriPonudu
 */
@WebServlet("/ZatvoriPonudu")
public class ZatvoriPonudu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ZatvoriPonudu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idPonude = request.getParameter("idPonude");
		URL url = new URL("http://localhost:8080/RestPrimer/rest/impl/zatvoriPonudu?idPonude=" + idPonude);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.connect();
		InputStream in = conn.getInputStream();
		conn.disconnect();

		PorukaData pd = new PorukaData();
		pd.setDate("datum");
String idKlijenta = request.getParameter("idKlijenta");
		pd.setIdKlijenta(Integer.parseInt(idKlijenta));
		String idVlasnika = request.getParameter("idVlasnika");
		pd.setIdVlasnika(Integer.parseInt(idVlasnika));
		pd.setSadrzaj("cestitam pobedili ste!!!");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(pd);

		System.out.println(json);
		
		url = new URL("http://localhost:8080/RestPrimer/rest/impl/posaljiPorukuKlijentu");
		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		
		OutputStream os = conn.getOutputStream();
		os.write(json.getBytes());
		os.flush();
		conn.connect();
		in = conn.getInputStream();
		conn.disconnect();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
