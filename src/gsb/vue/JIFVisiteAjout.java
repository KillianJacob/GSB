package gsb.vue;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFVisiteAjout extends JFrame {
	protected JPanel p;
	protected JPanel pTexte;

	protected JLabel JLRéférence;
	protected JLabel JLDateVisite;
	protected JLabel JLCommentaire;
	protected JLabel JLMatriculeVisiteur;
	protected JLabel JLCodeMédecin;

	protected JTextField JTRéférence;
	protected JTextField JTDateVisite;
	protected JTextField JTCommentaire;
	protected JTextField JTMatriculeVisiteur;
	protected JTextField JTCodeMédecin;

	public JIFVisiteAjout() {
		pTexte = new JPanel(new GridLayout(5, 2));
		
		JLRéférence = new JLabel("Référence");
	}
}
