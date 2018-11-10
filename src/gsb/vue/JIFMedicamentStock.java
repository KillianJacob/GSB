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

public class JIFMedicamentStock extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private ArrayList<Medicament> liste;

	public JIFMedicamentStock() {
		
		liste = new ArrayList<Medicament>();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Liste du Stock des echantillons");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
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
		panel_1.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	
		
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		
		String[] columnNames = {"Depot legal", "Nom","Effets","Libelle Famille"};
		
		String[][] data = new String[5][4];
		
		for(int i = 0; i < 5;i++){
			
			data[i][0] = "";
			data[i][1] = "";
			data[i][2] = "";
			data[i][3] = "";			
		}
		
		table = new JTable(data,columnNames);
		panel_3.add(table);	
		
	}

}
