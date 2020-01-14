package jpa;

import domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;
import java.util.List;

public class JpaTest {
	EntityManager manager;
	public JpaTest(EntityManager manager){
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.populateDataBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.readDataBase();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}

	private void populateDataBase() throws Exception {
		Date toDay = new Date();
		DatePropose datePropose = new DatePropose();
		datePropose.setPause(true);
		datePropose.setDateProsope(toDay);
		LieuPropose lieuPropose = new LieuPropose();
		lieuPropose.setLieu("PARIS");


		Alimentation mangue = new Alimentation();
		Alimentation poivre = new Alimentation();
		mangue.setTypeAlimentation(TypeAlimentation.PREFERENCE);
		mangue.setLibelle("Mangue");
		poivre.setLibelle("Poivre");
		poivre.setTypeAlimentation(TypeAlimentation.ALLERGIE);
		manager.persist(mangue);
		manager.persist(poivre);


		Sondage sondage = new Sondage() ;
		Utilisateur p1 = new Utilisateur();
		p1.setEmail("kouassives@gmail.com");
		p1.setNom("KOUASSI");
		p1.setPreNom("Yves");
		p1.addPrefereneces(mangue);
		manager.persist(p1);
		Utilisateur p2 = new Utilisateur();
		p2.setEmail("kouassives@live.com");
		p2.setNom("TI");
		p2.setPreNom("ANAIS");
		p2.addAllergies(poivre);
		manager.persist(p2);
		Reunion reunion = new Reunion();
		reunion.setIntitule("RDV 1 : Projet PRO");
		reunion.setResume("Choisir Le projet");
		reunion.addDateProposes(datePropose);
		sondage.setCreateur(p1);
		sondage.setReunion(reunion);
		sondage.setType(Type.LIEU);
		manager.persist(sondage);

		Reponse r1 = new Reponse();
		Reponse r2 = new Reponse();
		r1.setParticipant(p1);
		r1.setSondage(sondage);
		r1.setLieuPropose(lieuPropose);
		r2.setParticipant(p2);
		r2.setSondage(sondage);
		r2.setLieuPropose(lieuPropose);





		// Creation participant pour generer les id
		manager.persist(reunion);
        manager.persist(datePropose);
        manager.persist(lieuPropose);
        manager.persist(r1);
        manager.persist(r2);
		// Creation d'une assidute
		Assidute assidute = new Assidute();
		assidute.setParticipant(p1);
		assidute.setReunion(reunion);
		manager.persist(assidute);
        manager.persist(r1);
        manager.persist(r2);
    }

	private void readDataBase(){
		List<Sondage> sondages = manager.createQuery("select s From Sondage as s",Sondage.class).getResultList();
		System.out.println("Nombre de sondage : " + sondages.size());
		for(Sondage s : sondages)
			System.out.println("Créateur de Sondage: "+s.getCreateur().getNom());


	}

}
