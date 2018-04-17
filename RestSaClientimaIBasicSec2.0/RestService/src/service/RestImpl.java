package service;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Kategorija;
import model.Klijent;
import model.Ponuda;
import model.Poruka;
import model.Proizvod;
import model.Vlasnik;

@RequestScoped 
@Path("/impl")
@PermitAll
public class RestImpl {

	@PersistenceContext
	EntityManager em;

	@Resource
	UserTransaction ut;
	

	@Path("/vratiSveKategorije")
	@GET
	@Produces("application/json")
	public List<Kategorija> vratiSveKategorije() {
		List<Kategorija> kategorije = em.createQuery("SELECT k FROM Kategorija k").getResultList();
		return kategorije;
	}

	
	@Path("/vratiProizvodeZaKategoriju/{idKat}")
	@GET
	@Produces("application/json")
	public List<Proizvod> vratiProizvodeZaKategoriju(@PathParam("idKat") int idKat) {
		Kategorija k = em.find(Kategorija.class, idKat);

		List<Proizvod> proizvodi = em.createQuery("SELECT p FROM Proizvod p where p.kategorija=:kat")
				.setParameter("kat", k).getResultList();
		return proizvodi;

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
	@Consumes("application/json")
	@POST
	@RolesAllowed("random")
	public boolean posaljiPorukuKlijentu(PorukaData p) {// klijent, vlasnik,
														// sadrzaj, datum
		try {
			ut.begin();
			Poruka poruka = new Poruka();
			Vlasnik v = em.find(Vlasnik.class, p.getIdVlasnika());
			poruka.setVlasnik(v);
			Klijent k = em.find(Klijent.class, p.getIdKlijenta());
			poruka.setKlijent(k);
			poruka.setSadrzaj(p.getSadrzaj());
			poruka.setDatumporuke(p.getDate());
			em.persist(poruka);
			ut.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
