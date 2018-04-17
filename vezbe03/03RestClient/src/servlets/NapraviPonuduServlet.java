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

import model.Proizvod;

/**
 * Servlet implementation class NapraviPonuduServlet
 */
@WebServlet("/NapraviPonuduServlet")
public class NapraviPonuduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NapraviPonuduServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("idproizvoda");
		System.out.println("000000 "+idStr);
		String iznos = request.getParameter("ponuda");
		System.out.println("!!!!!!!!!!!" + iznos);
		URL url = new URL("http://localhost:8080/RestPrimer/rest/impl/napraviPonuduZaProizvod/" + idStr+","+iznos);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.connect();
		InputStream in = conn.getInputStream();
		conn.disconnect();

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
