/*
 * Cr�� le 22 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.modele.dao;

import gsb.modele.Localite;
import gsb.modele.Medecin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Isabelle 22 f�vr. 2015 TODO Pour changer le mod�le de ce commentaire
 *         de type g�n�r�, allez � : Fen�tre - Pr�f�rences - Java - Style de
 *         code - Mod�les de code
 */
public class MedecinDao {
	
	public static int AjouterMedecin(Medecin med){
		int result = 0;
		String requette = "INSERT INTO `MEDECIN` (`CODEMED`, `NOM`, `PRENOM`, `ADRESSE`, `CODEPOSTAL`, `TELEPHONE`, `POTENTIEL`, `SPECIALITE`) VALUES ('" + med.getCodeMed() + "','" 
		+ med.getNom() +"','"+ med.getPrenom() +"','"+ med.getAdresse() +"','"+ med.getLaLocalite().getCodePostal() +"','"+ med.getTelephone()+"','"+ med.getPotentiel() +"','"+ med.getSpecialite()+"')";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;
}

public static int SupprimerMedecin(Medecin med){
	int result = 0;
	String requette = "DELETE FROM MEDECIN WHERE CODEPOSTAL='" + med.getLaLocalite().getCodePostal() + "';";
	result = ConnexionMySql.execReqMaj(requette);
	ConnexionMySql.fermerConnexionBd();
	return result;	
}

	public static Medecin rechercher(String codeMedecin) {
		Medecin unMedecin = null;
		Localite uneLocalite = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from MEDECIN where CODEMED ='" + codeMedecin + "'");
		try {
			if (reqSelection.next()) {
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(5));
				unMedecin = new Medecin(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3),
						reqSelection.getString(4), uneLocalite, reqSelection.getString(6), reqSelection.getString(7),
						reqSelection.getString(8));
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from MEDECIN where CODEMED ='"
					+ codeMedecin + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unMedecin;
	}

	public static ArrayList<Medecin> retournerCollectionDesMedecins() {
		ArrayList<Medecin> collectionDesMedecins = new ArrayList<Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select CODEMED from MEDECIN");
		try {
			while (reqSelection.next()) {
				String codeMedecin = reqSelection.getString(1);
				collectionDesMedecins.add(MedecinDao.rechercher(codeMedecin));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedecins()");
		}
		return collectionDesMedecins;
	}

	public static HashMap<String, Medecin> retournerDictionnaireDesMedecins() {
		HashMap<String, Medecin> diccoDesMedecins = new HashMap<String, Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select CODEMED from MEDECIN");
		try {
			while (reqSelection.next()) {
				String codeMedecin = reqSelection.getString(1);
				diccoDesMedecins.put(codeMedecin, MedecinDao.rechercher(codeMedecin));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedecins()");
		}
		return diccoDesMedecins;
	}

}
