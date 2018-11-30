package gsb.service;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

public class VisiteService {
	public static Visite rechercheVisite(String reference) {
		Visite uneVisite = null;
		try {
			if (reference == null)
				throw new Exception("Donn�e obligatoire : reference");

			if (VisiteDao.rechercher(reference) == null) {
				throw new Exception("reference = " + reference + " n'est pas dans la base de donn�es");
			}
			uneVisite = VisiteDao.rechercher(reference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return uneVisite;
	}
	
	public static int AjouterVisite(Visite uneVisite) throws Exception {
		if(uneVisite.getReference()==null
				||uneVisite.getDate()==null
				||uneVisite.getCommentaire()==null
				||uneVisite.getUnVisiteur().getMatricule()==null
				||uneVisite.getUnMedecin().getCodeMed()==null
		){
			throw new Exception("Donn�e null");
		}
		if(VisiteDao.VisiteExist(uneVisite.getReference())){
			
			
			throw new Exception("La visite existe d�ja");			
		}
		
		return VisiteDao.AjouterVisite(uneVisite);
	}
}
