package gsb.vue;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFVisiteAjout extends JFrame {
	protected JPanel p;
	protected JPanel pTexte;

	protected JLabel JLR�f�rence;
	protected JLabel JLDateVisite;
	protected JLabel JLCommentaire;
	protected JLabel JLMatriculeVisiteur;
	protected JLabel JLCodeM�decin;

	protected JTextField JTR�f�rence;
	protected JTextField JTDateVisite;
	protected JTextField JTCommentaire;
	protected JTextField JTMatriculeVisiteur;
	protected JTextField JTCodeM�decin;

	public JIFVisiteAjout() {
		pTexte = new JPanel(new GridLayout(5, 2));
		
		JLR�f�rence = new JLabel("R�f�rence");
	}
}
