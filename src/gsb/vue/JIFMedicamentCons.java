/*
 * Créé le 17 nov. 2014
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.dao.MedecinDao;
import gsb.service.MedicamentService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * @author Isabelle 17 nov. 2014 TODO Pour changer le modèle de ce commentaire
 *         de type généré, allez à : Fenêtre - Préférences - Java - Style de
 *         code - Modèles de code
 */
public class JIFMedicamentCons extends JIFMedicament implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	private JButton premier;
	private JButton suivant;
	private JButton precedent;
	private JButton dernier;
	JTextField recherche;
	JLabel rechercheTexte;
	JButton rechercheButton;
	private ArrayList<Medicament> lesMedicaments;
	private int indiceEnCours;

	public JIFMedicamentCons() {
		super();
		premier = new JButton("Premier");
		pBoutons.add(premier);
		suivant = new JButton("Suivant");
		pBoutons.add(suivant);
		precedent = new JButton("Precedent");
		pBoutons.add(precedent);
		dernier = new JButton("Dernier");
		pBoutons.add(dernier);
		// déclaration des sources d'évènements
		premier.addActionListener(this);
		suivant.addActionListener(this);
		precedent.addActionListener(this);
		dernier.addActionListener(this);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Consultation données Medicament");
		
		JPanel pRecherche = new JPanel(); // panneau supportant la recherche
		
		recherche = new JTextField(10);
		rechercheTexte = new JLabel("Rechercher :");
		rechercheButton = new JButton("Rechercher");
		pRecherche.add(rechercheTexte);		
		pRecherche.add(recherche);
		pRecherche.add(rechercheButton);
		p.add(pRecherche);
		rechercheButton.addActionListener(this);
		
		// récupération des données Medecin dans la collection
		try {
			lesMedicaments = MedicamentService.RechercherToutMedicament();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		indiceEnCours = 0;

		if (lesMedicaments.size() != 0) { // si collection non vide, affichage des données du premier Medecin
			Medicament med = lesMedicaments.get(0);
			remplirText(med);
		}

		// ajout d'un écouteur d'évènement pour la fermeture de la fenêtre
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e) {
				// le code que tu veux exécuter à la fermeture de la JInternalFrame
			}
		});
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source == premier) {
			indiceEnCours = 0;
			Medicament med = lesMedicaments.get(indiceEnCours);
			remplirText(med);
		} else if (source == dernier) {
			indiceEnCours = lesMedicaments.size() - 1;
			Medicament med = lesMedicaments.get(indiceEnCours);
			remplirText(med);
		} else if (source == precedent) {
			if (indiceEnCours > 0)
				indiceEnCours = indiceEnCours - 1;
			Medicament med = lesMedicaments.get(indiceEnCours);
			remplirText(med);
		} else if (source == suivant) {
			if (indiceEnCours < (lesMedicaments.size() - 1))
				indiceEnCours = indiceEnCours + 1;
			Medicament med = lesMedicaments.get(indiceEnCours);
			remplirText(med);
		}
		else if (source == rechercheButton){
			
			Medicament med = null;
			
			for(int i =0; i < lesMedicaments.size();i++){
				
				if(lesMedicaments.get(i).getNomCommercial().toLowerCase().indexOf(recherche.getText().toLowerCase()) != -1){
					
					indiceEnCours = i;
					med = lesMedicaments.get(i);
					remplirText(med);
				}
				
			}
			if(med == null){
				
				 JOptionPane.showMessageDialog(null, "Medicament " + recherche.getText() + " est introuvable" , "Erreur", JOptionPane.INFORMATION_MESSAGE);			
					
				
			}
			
			
			
			
		}
	} // fin actionPerformed

}
