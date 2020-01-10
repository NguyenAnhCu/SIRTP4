package jpa;

import domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			Date toDay = new Date();
			DatePropose datePropose = new DatePropose();
			datePropose.setPause(true);
			datePropose.setDateProsope(toDay);
			manager.persist(datePropose);

			Sondage sondage = new Sondage() ;
			Participant p1 = new Participant();
			p1.setEmail("kouassives@gmail.com");
			p1.setNom("KOUASSI");
			p1.setPreNom("Yves");
			Participant p2 = new Participant();
			p2.setEmail("kouassives@live.com");
			p2.setNom("KOUASSI");
			p2.setPreNom("Yves");
			Reunion reunion = new Reunion();
			reunion.setIntitule("RDV 1 : Projet PRO");
			reunion.setResume("Choisir Le projet");
			sondage.setCreateur(p1);
			sondage.setReunion(reunion);
			Reponse r1 = new Reponse();
			Reponse r2 = new Reponse();
			r1.setAuteur(p1);
			r1.setSondage(sondage);
			r1.setDateReponse(datePropose);
			r2.setAuteur(p2);
			r2.setSondage(sondage);
			r2.setDateReponse(datePropose);


			manager.persist(reunion);
			manager.persist(sondage);
			manager.persist(r1);
			manager.persist(r2);
			manager.persist(p1);
			manager.persist(p2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
