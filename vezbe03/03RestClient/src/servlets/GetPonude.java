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

import model.Ponuda;
import model.Proizvod;

/**
 * Servlet implementation class GetPonude
 */
@WebServlet("/GetPonude")
public class GetPonude extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPonude() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("idProiz");

		URL url = new URL("http://localhost:8080/RestPrimer/rest/impl/vratiPonudeZaProizvod?idProizvoda=" + idStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		InputStream in = conn.getInputStream();

		
		ObjectMapper mapper = new ObjectMapper();
		List<Ponuda> ponude = mapper.readValue(in,
				mapper.getTypeFactory().constructCollectionType(List.class, Ponuda.class));

		System.out.println("aaaaaaaaaaaaaaa" +ponude.size());
		
		
		conn.disconnect();

		request.setAttribute("ponude", ponude);
		request.getRequestDispatcher("pages/ponude.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
