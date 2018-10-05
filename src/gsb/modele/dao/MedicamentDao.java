package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.dao.ConnexionMySql;

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
	
	public static int SupprimerMedicament(Medicament medicament){
		
		int result = 0;
		String requette = "DELETE FROM MEDICAMENT WHERE MED_DEPOTLEGAL='" + medicament.getDepotLegal() + "';";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;		
	}
	
	public static int AjouterMedicament(Medicament medicament){
		
		int result = 0;
		String requette = "INSERT INTO `MEDICAMENT` (`MED_DEPOTLEGAL`, `MED_NOMCOMMERCIAL`, `MED_COMPOSITION`, `MED_EFFETS`, `MED_CONTREINDIC`, `MED_PRIXECHANTILLON`, `FAM_CODE`, `FAM_LIBELLE`) VALUES ('" + medicament.getDepotLegal() + "','" + medicament.getNomCommercial() + "','" + medicament.getComposition() + "','" + medicament.getEffets() + "','" + medicament.getContreIndication() + "','" + medicament.getPrixEchantillon() + "','" + medicament.getCodeFamille() + "','"+ medicament.getLibellefamille() +"')";
		result = ConnexionMySql.execReqMaj(requette);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	
}
