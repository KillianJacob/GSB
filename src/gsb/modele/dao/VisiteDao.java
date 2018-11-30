package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
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
			if (reqSelection.next()) {
				unMedecin = MedecinDao.Rechercher(reqSelection.getString(4));
				unVisiteur = VisiteurDao.rechercher(reqSelection.getString(5));
				uneVisite = new Visite(reqSelection.getString(1), reqSelection.getDate(2),
						reqSelection.getString(3), unMedecin, unVisiteur);
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
	
	public static int SupprimerVisite(Visite visite){
		
		int result = 0;
		String requette = "DELETE FROM VISITE WHERE REFERENCE='" + visite.getReference() + "';";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;		
	}
	
	public static int AjouterVisite(Visite visite){
		
		int result = 0;
		String requette = "INSERT INTO `VISITE` (`REFERENCE`, `DATEVISITE`, `COMMENTAIRE`, `MATRICULE`, `CODEMED`) VALUES ('" + visite.getReference() + "', '" + visite.getDate().toString() + "', '" + visite.getCommentaire() + "', '" + visite.getUnVisiteur().getMatricule() + "', '" + visite.getUnMedecin().getCodeMed() + "')";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

	public static boolean VisiteExist(String ref){
		
		boolean result = false;;
		String requette = "SELECT COUNT(*) FROM VISITE WHERE `REFERENCE`= '" + ref + "';";
		ResultSet reqSelection = ConnexionMySql.execReqSelection(requette);
		try {
			if(reqSelection.next()) {
				if(reqSelection.getInt(1) > 0){
					
					result = true;
					
				}
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - " + requette);
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();			
		
		
		return result;
		
	}
	
	public static int ModifierVisite(Visite visite){
		
		int result = 0;
		String requette = "UPDATE VISITE SET `DATEVISITE` = '"+ visite.getDate() +"', `COMMENTAIRE` = '"+ visite.getCommentaire() +"', `MATRICULE`= '"+ visite.getUnVisiteur().getMatricule() +"', `CODEMED` = '" + visite.getUnMedecin().getCodeMed() + "' WHERE REFERENCE='" + visite.getReference() + "';";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;		
	}
	
	
}
