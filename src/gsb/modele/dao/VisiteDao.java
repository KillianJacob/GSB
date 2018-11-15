package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.Date;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteDao {
	public static Visite rechercher(String referenceVisite) {
		Visite uneVisite = null;
		Medecin unMedecin = null;
		Visiteur unVisiteur = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from VISITE where REFERENCE='" + referenceVisite + "'");
		try {
			/*
			 * (String reference, Date date, String commentaire, Medecin unMedecin, Visiteur
			 * unVisiteur) (`REFERENCE`, `DATEVISITE`, `COMMENTAIRE`, `MATRICULE`,
			 * `CODEMED`)
			 */
			if (reqSelection.next()) {
				unVisiteur = VisiteurDao.rechercher(reqSelection.getString(4));
				unMedecin = MedecinDao.Rechercher(reqSelection.getString(5));
				uneVisite = new Visite(reqSelection.getString(1), reqSelection.getDate(2), reqSelection.getString(3),
						unMedecin, unVisiteur);
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITE where REFERENCE='"
					+ referenceVisite + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}

	public static int AjouterVisite(Visite uneVisite) {
		int result = 0;
		String requette = "INSERT INTO `visite` (`REFERENCE`, `DATEVISITE`, `COMMENTAIRE`, `MATRICULE`, `CODEMED`) VALUES ('"
				+ uneVisite.getReference() + "','" + uneVisite.getDate() + "','" + uneVisite.getCommentaire() + "','"
				+ uneVisite.getUnMedecin().getCodeMed() + "','" + uneVisite.getUnVisiteur().getMatricule() + "');";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;

	}

}