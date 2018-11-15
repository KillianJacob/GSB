package gsb.tests.units;

import static org.junit.Assert.assertNotSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.dao.LocaliteDao;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.MedicamentDao;

public class MedecinDaoTestUnits {

	Medecin medecin;
	Localite localite;

	@Before
	public void setUp() throws Exception {
		
		localite = new Localite("00000","Ville");
		LocaliteDao.AjouterLocalite(localite);
		medecin = new Medecin ("codeMed", "nom", "prenom", "adresse", localite, "telephone",
				"potentiel", "specialite");
		MedecinDao.AjouterMedecin(medecin);
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		MedecinDao.SupprimerMedecin(medecin);
		
	}
	
	@Test
	public void testAjouterLocalite() {
		
		Medecin medecinTest = new Medecin ("codeMed", "String nom", "String prenom", "String adresse", localite, "String telephone",
				"String potentiel"," String specialite");
		assertNotSame(-1,MedecinDao.AjouterMedecin(medecinTest));
		MedecinDao.SupprimerMedecin(medecinTest);


	}
}
