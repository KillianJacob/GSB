package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import gsb.modele.Medicament;

public class MedicamentDao {

	public static ArrayList<Medicament> RechercherMedicament(String depotlegal){
		
		ArrayList<Medicament> result = new ArrayList<Medicament>();
		String requette = "select * from MEDICAMENT where MED_DEPOTLEGAL ='" + depotlegal + "';";
		ResultSet reqSelection = ConnexionMySql.execReqSelection(requette);
		try {
			while(reqSelection.next()) {
				result.add(new Medicament(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3),
						reqSelection.getString(4), reqSelection.getString(5), reqSelection.getFloat(6), reqSelection.getString(7),
						reqSelection.getString(8)));
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - " + requette);
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return result; 
		
	}
	
	public static void SupprimerMedicament(){
		
		
		
	}
	
	
	
	
}
