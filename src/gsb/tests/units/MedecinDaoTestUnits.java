package gsb.tests.units;

import static org.junit.Assert.assertNotSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.dao.LocaliteDao;
import gsb.modele.dao.MedicamentDao;

public class MedecinDaoTestUnits {

	Medecin medecin;
	Localite localite;

	@Before
	public void setUp() throws Exception {
		
		localite = new Localite("00000","Ville");
		LocaliteDao.AjouterLocalite(localite);
		Medecin = "codeMed", "String nom", "String prenom", "String adresse", localite, "String telephone",
				"String potentiel"," String specialite")
		MedicamentDao.AjouterMedicament(medicament);
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		LocaliteDao.SupprimerLocalite(localite);
		
	}
	
	@Test
	public void testAjouterLocalite() {
		
		Medicament localiteTest = new Localite("00000","Ville");
		assertNotSame(-1,LocaliteDao.AjouterLocalite(localiteTest));
		LocaliteDao.SupprimerLocalite(localiteTest);


	}
}
