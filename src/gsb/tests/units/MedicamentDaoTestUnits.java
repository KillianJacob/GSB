package gsb.tests.units;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;

public class MedicamentDaoTestUnits {

	Medicament medicament;
	Visiteur visiteur;
	
	@Before
	public void setUp() throws Exception {
		
		medicament = new Medicament("TEST","","","","",0.0F,"","");
		MedicamentDao.AjouterMedicament(medicament);
		visiteur = new Visiteur("test", "", "", "", "", "",
				new Localite("",""), "", new Date(0), 0, "", ""); 
		VisiteurDao.AjouterVisiteur(visiteur);
	}

	@After
	public void tearDown() throws Exception {
		
		MedicamentDao.SupprimerMedicament(medicament);
		
	}

	
	@Test
	public void testAjouterMedicament() {
		
		Medicament medicamentTest = new Medicament("TEST1","","","","",0.0F,"","");
		assertNotSame(-1,MedicamentDao.AjouterMedicament(medicamentTest));
		MedicamentDao.SupprimerMedicament(medicamentTest);
		
		
	}	
	
	@Test
	public void testAjouterMedicamentStocker() {
		
		
		MedicamentDao.AjouterMedicamentStockerByVisiteur(medicament.getDepotLegal(),visiteur.getMatricule() , 1);
		boolean resultat = false;
		
		HashMap<Medicament,Integer> res = MedicamentDao.ListeMedicamentStockerByVisiteur(visiteur.getMatricule());
		
		if(res.containsKey(medicament)){
			
			resultat = true;
			
		}
		
		assertEquals(true,resultat);
	
		
	}	
	
	@Test
	public void testRechercherMedicament() {
		
		
		assertEquals(medicament.getDepotLegal(),MedicamentDao.RechercherMedicament("TEST").getDepotLegal());
		
	}
	
	
	

}
