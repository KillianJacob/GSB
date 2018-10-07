package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Localite;
import gsb.modele.Visiteur;

public class VisiteurDao {
	public static Visiteur rechercher(String matriculeVisiteur) {
		Visiteur unVisiteur = null;
		Localite uneLocalite = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from VISITEUR where MATRICULE='" + matriculeVisiteur + "'");
		try {
			if (reqSelection.next()) {
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(7));
				//unVisiteur = new Visiteur(reqSelection.getString(),reqSelection.getString(),reqSelection.getString())
			}
			;
		} catch (Exception e) {
			//System.out.println("erreur reqSelection.next() pour la requête - select * from LOCALITE where CODEPOSTAL='"
			//		+ codeLocalite + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return null;
	}
}
