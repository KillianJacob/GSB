package gsb.vue;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import gsb.modele.Medicament;
import gsb.service.MedicamentService;

import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class JIFMedicamentStock extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private ArrayList<Medicament> liste;
	private String[] columnNames = {"Depot legal", "Nom","Effets","Libelle Famille"};
	
	
	public JIFMedicamentStock(MenuPrincipal menu,String matricule) {
		
		liste = new ArrayList<Medicament>();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Liste du Stock des echantillons");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Code Visiteur");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		panel_1.add(btnRechercher);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menu.ouvrirFenetre(new JIFMedicamentStock(menu,textField.getText()));
				
			}
		});
		
		String[][] data;
		if(matricule != null){
			
			try {
				liste = MedicamentService.RechercherMedicamentStocker(matricule);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			data = new String[liste.size()][4];
			
			for(int i = 0; i < liste.size();i++){
				
				data[i][0] = liste.get(i).getDepotLegal();
				data[i][1] = liste.get(i).getNomCommercial();
				data[i][2] = liste.get(i).getEffets();
				data[i][3] = liste.get(i).getLibellefamille();				
			}
			
			table = new JTable(data,columnNames);
			panel_3.add(table);				
			
		}

		
	}

}
