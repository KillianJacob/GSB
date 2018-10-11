package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.service.MedicamentService;

public class JIFMedicamentAjout extends JIFMedicament implements ActionListener {

	JButton ajout;
	
	public JIFMedicamentAjout() {
		super();
		ajout = new JButton("Ajouter");
		pBoutons.add(ajout);
		
		ajout.addActionListener(this);	
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Ajout Medicament");
		
		
		// ajout d'un écouteur d'évènement pour la fermeture de la fenêtre
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e) {
				// le code que tu veux exécuter à la fermeture de la JInternalFrame
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		Object source = evt.getSource();
		if (source == ajout) {
			
			Medicament med = new Medicament(JTDepotLegal.getText(), JTnomCommercial.getText(), JTcomposition.getText(), JTeffet.getText(), JTContreIndication.getText(), Float.parseFloat(JTPrixEchantillon.getText()), JTCodeFamille.getText(), JTLibelleFamille.getText());
			
			try {
				if(MedicamentService.AjouterMedicament(med) == -1){
					 JOptionPane.showMessageDialog(null, "Erreur le medicament n'a pas été ajouter","Echec de l'ajout", JOptionPane.INFORMATION_MESSAGE);								
					
				}
				else{
					 JOptionPane.showMessageDialog(null,  "Le medicament " + JTnomCommercial.getText() + " a bien été ajouter",  "Ajout Reussi", JOptionPane.INFORMATION_MESSAGE);			
					 
				}
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.INFORMATION_MESSAGE);			
			};
			
		}
		
		
	}
		
	
}
