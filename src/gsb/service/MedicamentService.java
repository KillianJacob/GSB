package gsb.service;

import java.util.ArrayList;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {

	
	public static Medicament RechercherMedicament(String DepotLegal) throws Exception{
		
		
		if(DepotLegal == null || DepotLegal == ""){
			
			throw new Exception("Depot Legal Invalide");
			
		}
		
		return MedicamentDao.RechercherMedicament(DepotLegal);
		
	}

	public static ArrayList<Medicament> RechercherToutMedicament() throws Exception{
		
		
		return MedicamentDao.RechercherToutMedicament();
		
	}
	
	
	public static int AjouterMedicament(Medicament medicament) throws Exception{

		if(medicament.getDepotLegal() == null 
				|| medicament.getCodeFamille() == null 
				|| medicament.getComposition() == null 
				|| medicament.getContreIndication() == null
				|| medicament.getEffets() == null
				|| medicament.getLibellefamille() == null
				|| medicament.getNomCommercial() == null
				){
			
			throw new Exception("Donnée null");


		}
		if(medicament.getDepotLegal().equals("")
				|| medicament.getCodeFamille().equals("")
				|| medicament.getComposition().equals("")
				|| medicament.getContreIndication() .equals("")
				|| medicament.getEffets() .equals("")
				|| medicament.getLibellefamille() .equals("")
				|| medicament.getNomCommercial() .equals("")
				){
			
			
			throw new Exception("Donnée null");
		}
		if(MedicamentDao.MedicamentExist(medicament.getDepotLegal())){
			
			throw new Exception("Le medicament éxiste Deja");
			
		}
		if(medicament.getCodeFamille().length() > 3){
			
			throw new Exception("Code Famille Trop long");
			
		}
		
		return MedicamentDao.AjouterMedicament(medicament);


	}
	
	public static void ModifierMedicament(Medicament medicament) throws Exception{
		
		if(medicament.getDepotLegal() == null 
				|| medicament.getCodeFamille() == null 
				|| medicament.getComposition() == null 
				|| medicament.getContreIndication() == null
				|| medicament.getEffets() == null
				|| medicament.getLibellefamille() == null
				|| medicament.getNomCommercial() == null
				){
			
			throw new Exception("Donnée null");


		}
		
		MedicamentDao.ModifierMedicament(medicament);
		
		
		
	}
	
	public static void SuppprimerMedicament(Medicament medicament) throws Exception{
		
		if(medicament.getDepotLegal() == null 
				|| medicament.getCodeFamille() == null 
				|| medicament.getComposition() == null 
				|| medicament.getContreIndication() == null
				|| medicament.getEffets() == null
				|| medicament.getLibellefamille() == null
				|| medicament.getNomCommercial() == null
				){
			
			throw new Exception("Donnée null");


		}
		
		if(!MedicamentDao.MedicamentExist(medicament.getDepotLegal())){
			
			throw new Exception("Medicament Inexistant");			
			
		}
		
		MedicamentDao.SupprimerMedicament(medicament);
		
		
		
	}	
	


}
