package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import gsb.modele.Localite;
import gsb.modele.Medicament;
import gsb.modele.Visiteur;

public class VisiteurDao {
	public static Visiteur rechercher(String matriculeVisiteur) {
		Visiteur unVisiteur = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from VISITEUR where MATRICULE='" + matriculeVisiteur + "'");
		try {
			/*(String matricule, String nom, String prenom, String login, String mdp, String adresse,
					Localite uneLocalite, String telephone, Date dateEntree, int prime, String codeUnite, String nomUnite)
			(`MATRICULE`, `NOM`, `PRENOM`, `LOGIN`, `MDP`, `ADRESSE`, `CODEPOSTAL`, `DATEENTREE`, `CODEUNIT`, `NOMUNIT`)*/
			
			if (reqSelection.next()) {
				Localite uneLocalite = LocaliteDao.rechercher(reqSelection.getString(7));
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5),
						reqSelection.getString(6), uneLocalite, "00 00 00 00 00", reqSelection.getDate(8), 0,
						reqSelection.getString(9), reqSelection.getString(10));
				}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITEUR where MATRICULE='"
					+ matriculeVisiteur + "'");

			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	

	public static int AjouterVisiteur(Visiteur visiteur){
		
		int result = 0;
		String requette = "INSERT INTO `visiteur` (`MATRICULE`, `NOM`, `PRENOM`, `LOGIN`, `MDP`, `ADRESSE`, `CODEPOSTAL`, `DATEENTREE`, `CODEUNIT`, `NOMUNIT`) VALUES ('"+ visiteur.getMatricule() + "', '" + visiteur.getNom() + "', '" + visiteur.getPrenom() + "', '" + visiteur.getLogin() + "', '" + visiteur.getMdp() + "', '" + visiteur.getAdresse() + "', '" +"code" + "', '" + visiteur.getDateEntree() + "', '" + visiteur.getCodeUnite() + "', '" + visiteur.getNomUnite() + "');";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;
		
	}	
	
	public static boolean VisiteurExist(String matricule){

		boolean result = false;;
		String requette = "SELECT COUNT(*) FROM VISITEUR WHERE `MATRICULE`= '" + matricule + "';";
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
	
}
