package gsb.service;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

public class VisiteService {
	public static Visite rechercheVisite(String reference) {
		Visite uneVisite = null;
		try {
			if (reference == null)
				throw new Exception("Donnée obligatoire : reference");

			if (VisiteDao.rechercher(reference) == null) {
				throw new Exception("reference = " + reference + " n'est pas dans la base de données");
			}
			uneVisite = VisiteDao.rechercher(reference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return uneVisite;
	}
}
