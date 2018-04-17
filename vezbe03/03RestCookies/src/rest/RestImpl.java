package rest;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import model.Kategorija;
import model.Klijent;
import model.Ponuda;
import model.Proizvod;

@RequestScoped
@Path("impl")
public class RestImpl {

	@PersistenceContext
	EntityManager em;

	@Resource
	UserTransaction ut;

	@Path("/hello")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayHello() {
		return Response.ok().entity("zdravo").build();
	}

	@Path("/helloCookie")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHelloCookie() {
		return Response.ok().entity("zdravo sa kolacicem")
				.cookie(new NewCookie("ovojnazivkolacica", "vrednost kolacica")).build();
	}

	@Path("/konzumacijaKolacica")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void cookieConsumation(@CookieParam("ovojnazivkolacica") Cookie cookie) {
		System.out.println(cookie);
		System.out.println(
				"##################     " + cookie.getName() + "  " + cookie.getValue() + "     ##################");
	}

	// anotirati rest
	@Path("/kategorije")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Kategorija> vratiSveKategorije() {
		// implementirati vracanje svih kategorija
		List<Kategorija> kategorije = em.createNamedQuery("Kategorija.findAll").getResultList();
		return kategorije;
	}

	// anotirati rest
	@Path("/kategorija/{idKateraaajaaa}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Kategorija vratiKategoriju(@PathParam("idKateraaajaaa") int id) {
		Kategorija kategorija = em.find(Kategorija.class, id);
		return kategorija;
	}

	@Path("/kategorija")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Kategorija vratiKategorijuQ(@QueryParam("id") int id) {
		Kategorija kategorija = em.find(Kategorija.class, id);
		return kategorija;
	}

	@Path("/kreirajPonudu")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void ubaciPonudu(@FormParam("idKli") int idKli, @FormParam("idPorizv") int idPorizv,
			@FormParam("iznos") int iznos) throws NotSupportedException, SystemException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		ut.begin();
		Ponuda p = new Ponuda();
		Klijent k = em.find(Klijent.class, idKli);
		p.setKlijent(k);
		Proizvod prv = em.find(Proizvod.class, idPorizv);
		p.setProizvod(prv);
		p.setIznos(iznos);
		p.setDatumponude("kdhjalgfjdajdae");
		em.persist(p);
		ut.commit();
	}

	@Path("/aaa")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void ubaciPonudu(Kategorija k) {
		System.out.println(k);
	}

}
