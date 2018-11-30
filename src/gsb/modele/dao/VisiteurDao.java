package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteurDao {
	
	public static Visiteur rechercher(String MatriculeVisiteur) {
		Visiteur unVisiteur = null;
		String req = "select * from VISITEUR where MATRICULE='" + MatriculeVisiteur + "';";
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection(req);
		try {
			if (reqSelection.next()) {
				
				Localite loc = LocaliteDao.rechercher(reqSelection.getString(7));
				
				unVisiteur = new Visiteur(reqSelection.getString(0),reqSelection.getString(1),reqSelection.getString(2)
						,reqSelection.getString(3),reqSelection.getString(4),reqSelection.getString(5),reqSelection.getString(6),loc,reqSelection.getString(8),reqSelection.getDate(9),reqSelection.getInt(10),reqSelection.getString(11),reqSelection.getString(12));
				
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - " + req);
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}
	
	public static int AjouterVisiteur(Visiteur visiteur){
		
		int result = 0;
		String requette = "INSERT INTO `visiteur` (`MATRICULE`, `NOM`, `PRENOM`, `LOGIN`, `MDP`, `ADRESSE`, `CODEPOSTAL`, `DATEENTREE`, `CODEUNIT`, `NOMUNIT`) VALUES ("
				+ "'" + visiteur.getMatricule() + "', "
				+ "'" + visiteur.getNom() + "', "
				+ "'" + visiteur.getPrenom() + "', "
				+ "'" + visiteur.getLogin() + "', "
				+ "'" + visiteur.getMdp() + "', "
				+ "'" + visiteur.getAdresse() + "', "
				+ "'" + visiteur.getCodePostal() + "', "
				+ "'" + visiteur.getDateEntree().toString() + "', "
				+ "'" + visiteur.getCodeUnite() + "', "
				+ " '" + visiteur.getNomUnite() + "');";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	public static int SupprimerVisiteur(String matricule){
		
		int result = 0;
		String requette = "DELETE FROM VISITEUR WHERE MATRICULE='" + matricule + "';";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;		
	}
	
	public static int SupprimerVisiteur(Visiteur visiteur){
		
		int result = 0;
		String requette = "DELETE FROM VISITEUR WHERE MATRICULE='" + visiteur.getMatricule() + "';";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;		
	}
	
	public static boolean VisiteurExist(String Matricule){
		
		boolean result = false;;
		String requette = "SELECT COUNT(*) FROM VISITEUR WHERE `MATRICULE`= '" + Matricule + "';";
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
