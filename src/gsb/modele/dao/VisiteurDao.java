package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.Date;

import gsb.modele.Localite;
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
}
