package gsb.tests.units;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentDaoTestUnits {

	Medicament medicament;
	
	@Before
	public void setUp() throws Exception {
		medicament = new Medicament("TEST","","","","",0.0F,"","");
		MedicamentDao.AjouterMedicament(medicament);
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
	public void testRechercherMedicament() {
		
		
		assertEquals(medicament.getDepotLegal(),MedicamentDao.RechercherMedicament("TEST").get(0).getDepotLegal());
		
	}

}
