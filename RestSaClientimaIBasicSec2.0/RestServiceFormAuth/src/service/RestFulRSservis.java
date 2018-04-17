package service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.annotations.providers.jaxb.Formatted;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Kategorija;
import model.Klijent;
import model.Ponuda;
import model.Poruka;
import model.Proizvod;
import model.Vlasnik;

@RequestScoped
@Path("restic")
public class RestFulRSservis {

	@PersistenceContext
	EntityManager em;

	@Resource
	UserTransaction ut;

	@Path("/vratiSveKategorije")
	@GET
	@Produces("application/json")
	public List<Kategorija> vratiSveKategorije() {
		if (em == null)
			System.out.println("em je null");
		List<Kategorija> kategorije = em.createQuery("SELECT k FROM Kategorija k").getResultList();
		return kategorije;
	}

//query param zbog get
	@Path("/vratiProizvodeZaKategoriju")
	@GET
	public void vratiProizvodeZaKategoriju(@QueryParam("idKat") int idKat, @Context HttpServletRequest request,
			@Context HttpServletResponse response) throws ServletException, IOException {
		System.out.println(idKat);
		Kategorija k = em.find(Kategorija.class, idKat);

		List<Proizvod> proizvodi = em.createQuery("SELECT p FROM Proizvod p where p.kategorija=:kat")
				.setParameter("kat", k).getResultList();

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../show.jsp");
		System.out.println(proizvodi.size());
		request.setAttribute("proizvodi", proizvodi);
		requestDispatcher.forward(request, response);
	}

	@Path("/napraviPonuduZaProizvod/{idProizvoda},{iznos}")
	@Produces("application/json")
	@POST
	public boolean napraviPonuduZaProizvod(@PathParam("idProizvoda") int idProizvoda, @PathParam("iznos") int iznos) {
		try {
			System.out.println("pozvan metod");
			ut.begin();
			Ponuda p = new Ponuda();
			p.setIznos(iznos);
			Klijent k = em.find(Klijent.class, 1);
			p.setKlijent(k);
			Proizvod pr = em.find(Proizvod.class, idProizvoda);
			p.setProizvod(pr);
			p.setDatumponude("datum je string, pa mogu da se zezam");
			em.persist(p);
			ut.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Path("/posaljiPorukuKlijentu")
	@Produces("application/json")
	@POST
	//form zbog post
	public boolean posaljiPorukuKlijentu(@FormParam("idKlijenta") int idKlijenta,
			@FormParam("idVlasnika") int idVlasnika, @FormParam("sadrzaj") String sadrzaj,
			@FormParam("date") String date) {
		try {
			ut.begin();
			Poruka poruka = new Poruka();
			Vlasnik v = em.find(Vlasnik.class, idVlasnika);
			System.out.println(idVlasnika);
			System.out.println(idKlijenta);
			poruka.setVlasnik(v);
			Klijent k = em.find(Klijent.class, idKlijenta);
			poruka.setKlijent(k);
			poruka.setSadrzaj(sadrzaj);
			poruka.setDatumporuke(date);
			em.persist(poruka);
			ut.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
