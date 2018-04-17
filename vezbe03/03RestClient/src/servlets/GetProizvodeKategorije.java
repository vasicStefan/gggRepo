package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Kategorija;
import model.Ponuda;
import model.Proizvod;

/**
 * Servlet implementation class GetProizvodeKategorije
 */
@WebServlet("/GetProizvodeKategorije")
public class GetProizvodeKategorije extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetProizvodeKategorije() {
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
		String idStr = request.getParameter("idKat");

		URL url = new URL("http://localhost:8080/RestPrimer/rest/impl/vratiProizvodeZaKategoriju/" + idStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		InputStream in = conn.getInputStream();

		
		ObjectMapper mapper = new ObjectMapper();
		List<Proizvod> proizvodi = mapper.readValue(in,
				mapper.getTypeFactory().constructCollectionType(List.class, Proizvod.class));

		
		conn.disconnect();

		request.setAttribute("proizvodi", proizvodi);
		request.getRequestDispatcher("pages/proizvodi.jsp").forward(request, response);
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
