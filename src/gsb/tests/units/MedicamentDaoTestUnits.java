package gsb.tests.units;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentDaoTestUnits {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testAjouterMedicament() {
		
		Medicament medicament = new Medicament("MDMA","","","","",0.0F,"","");
		
		assertNotSame(-1,MedicamentDao.AjouterMedicament(medicament));
		
		
	}	
	
	@Test
	public void testRechercherMedicament() {
		
		
		
		
	}

}
