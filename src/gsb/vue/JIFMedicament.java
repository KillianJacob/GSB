/*
 * Créé le 22 mars 2012
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Medicament;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFMedicament extends JInternalFrame {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;

	protected JLabel JLDepotlegal;
	protected JLabel JLnomCommercial;
	protected JLabel JLcomposition;
	protected JLabel JLeffet;
	protected JLabel JLContreIndication;
	protected JLabel JLPrixEchantillon;
	protected JLabel JLCodeFamille;
	protected JLabel JLLibelleFamille;

	protected JTextField JTDepotLegal;
	protected JTextField JTnomCommercial;
	protected JTextField JTcomposition;
	protected JTextField JTeffet;
	protected JTextField JTContreIndication;
	protected JTextField JTPrixEchantillon;
	protected JTextField JTCodeFamille;
	protected JTextField JTLibelleFamille;

	public JIFMedicament() {
		p = new JPanel(); // panneau principal de la fenêtre
		pBoutons = new JPanel(); // panneau supportant les boutons
		pTexte = new JPanel(new GridLayout(9, 2));

		JLDepotlegal = new JLabel("Depot Legal");
		JLnomCommercial = new JLabel("Nom Commercial");
		JLcomposition = new JLabel("Composition");
		JLeffet = new JLabel("Effet");
		JLContreIndication = new JLabel("Contre Indication");
		JLPrixEchantillon = new JLabel("Prix Echantillon");
		JLCodeFamille = new JLabel("Code Famille");
		JLLibelleFamille = new JLabel("Libelle Famille");

		JTDepotLegal = new JTextField(20);
		JTDepotLegal.setMaximumSize(JTDepotLegal.getPreferredSize());
		JTnomCommercial = new JTextField();
		JTcomposition = new JTextField();
		JTeffet = new JTextField(1);
		JTContreIndication = new JTextField(1);
		JTPrixEchantillon = new JTextField();
		JTCodeFamille = new JTextField();
		JTLibelleFamille = new JTextField();

		pTexte.add(JLDepotlegal);
		pTexte.add(JTDepotLegal);
		pTexte.add(JLnomCommercial);
		pTexte.add(JTnomCommercial);
		pTexte.add(JLcomposition);
		pTexte.add(JTcomposition);
		pTexte.add(JLeffet);
		pTexte.add(JTeffet);
		pTexte.add(JLContreIndication);
		pTexte.add(JTContreIndication);
		pTexte.add(JLPrixEchantillon);
		pTexte.add(JTPrixEchantillon);
		pTexte.add(JLCodeFamille);
		pTexte.add(JTCodeFamille);
		pTexte.add(JLLibelleFamille);
		pTexte.add(JTLibelleFamille);

		// mise en forme de la fenêtre

		p.add(pTexte);
		p.add(pBoutons);
		Container contentPane = getContentPane();
		contentPane.add(p);

	}

	public void remplirText(Medicament medicament) { // méthode qui permet de remplir les zones de texte à partir des
													// valeurs passées en paramètres
		JTDepotLegal.setText(medicament.getDepotLegal());
		JTnomCommercial.setText(medicament.getNomCommercial());
		JTcomposition.setText(medicament.getComposition());
		JTeffet.setText(medicament.getEffets());
		JTContreIndication.setText(medicament.getContreIndication());
		JTPrixEchantillon.setText(Float.toString(medicament.getPrixEchantillon()));
		JTCodeFamille.setText(medicament.getCodeFamille());
		JTLibelleFamille.setText(medicament.getLibellefamille());
	}

	public void viderText() { // méthode qui permet de vider les zones de texte
		JTDepotLegal.setText("");
		JTnomCommercial.setText("");
		JTcomposition.setText("");
		JTeffet.setText("");
		JTContreIndication.setText("");
		JTPrixEchantillon.setText("");
		JTCodeFamille.setText("");
		JTLibelleFamille.setText("");
	}

}
