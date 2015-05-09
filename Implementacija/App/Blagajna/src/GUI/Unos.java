package GUI;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Dodaci.GodinaStudija;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;

import java.awt.Choice;
import java.awt.Button;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Unos {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_10;
	private JTextField textField_11;
	private JLabel lblGodinaKojuUpisje;
	private JLabel lblPopust;
	private JTextField textField_13;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_1;
	private JButton btnUnesi;
	private JLabel lblKm;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Unos window = new Unos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Unos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 779, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(15dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(126dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(201dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(24dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(68dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(26dlu;default)"),}));
			
			panel = new JPanel();
			panel.setBorder(BorderFactory.createTitledBorder("Li�ni podaci"));
			frame.getContentPane().add(panel, "2, 2, 5, 1, fill, fill");
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("right:default"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(116dlu;default)"),
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("right:default"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(126dlu;default)"),},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));
			
				
				JLabel lblNewLabel = new JLabel("Ime:");
				panel.add(lblNewLabel, "2, 2");
				
				textField = new JTextField();
				panel.add(textField, "4, 2");
				textField.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("Mjesto ro\u0111enja:");
				panel.add(lblNewLabel_2, "8, 2");
				
				textField_1 = new JTextField();
				panel.add(textField_1, "10, 2");
				textField_1.setColumns(10);
				
				JLabel lblPrezime = new JLabel("Prezime:");
				panel.add(lblPrezime, "2, 4");
				
				textField_2 = new JTextField();
				panel.add(textField_2, "4, 4");
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("Op\u0107ina ro\u0111enja:");
				panel.add(lblNewLabel_3, "8, 4");
				
				textField_6 = new JTextField();
				panel.add(textField_6, "10, 4");
				textField_6.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("Ime roditelja:");
				panel.add(lblNewLabel_1, "2, 6");
				
				textField_3 = new JTextField();
				panel.add(textField_3, "4, 6");
				textField_3.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel("Dr\u017Eava ro\u0111enja:");
				panel.add(lblNewLabel_4, "8, 6");
				
				textField_7 = new JTextField();
				panel.add(textField_7, "10, 6");
				textField_7.setColumns(10);
				
				JLabel lblBrojTelefona = new JLabel("Broj telefona:");
				panel.add(lblBrojTelefona, "2, 8");
				
				textField_4 = new JTextField();
				panel.add(textField_4, "4, 8");
				textField_4.setColumns(10);
				
				JLabel lblAdresaPrebivalita = new JLabel("Adresa prebivali\u0161ta:");
				panel.add(lblAdresaPrebivalita, "8, 8");
				
				textField_8 = new JTextField();
				panel.add(textField_8, "10, 8");
				textField_8.setColumns(10);
				
				JLabel lblJmbg = new JLabel("JMBG:");
				panel.add(lblJmbg, "2, 10");
				
				textField_5 = new JTextField();
				panel.add(textField_5, "4, 10");
				textField_5.setColumns(10);
				
				JLabel lblOpinaPrebivalita = new JLabel("Op\u0107ina prebivali\u0161ta:");
				panel.add(lblOpinaPrebivalita, "8, 10");
				
				textField_9 = new JTextField();
				panel.add(textField_9, "10, 10");
				textField_9.setColumns(10);
				
				panel_1 = new JPanel();
				panel_1.setBorder(BorderFactory.createTitledBorder("Podaci o studiju"));
				frame.getContentPane().add(panel_1, "2, 4, 5, 1, fill, fill");
				panel_1.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("right:default"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(104dlu;default):grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("right:default"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,},
					new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,}));
				
				lblNewLabel_5 = new JLabel("Broj indeksa:");
				panel_1.add(lblNewLabel_5, "2, 2, right, default");
				
				textField_10 = new JTextField();
				panel_1.add(textField_10, "4, 2, left, default");
				textField_10.setColumns(10);
				
				lblNewLabel_6 = new JLabel("Tro\u0161kovi strudija:");
				panel_1.add(lblNewLabel_6, "8, 2, right, default");
				
				textField_11 = new JTextField();
				panel_1.add(textField_11, "10, 2, fill, default");
				textField_11.setColumns(10);
				
				lblKm = new JLabel("KM");
				panel_1.add(lblKm, "12, 2");
				
				lblGodinaKojuUpisje = new JLabel("Godina koju upisje:");
				panel_1.add(lblGodinaKojuUpisje, "2, 4, right, default");
				
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(GodinaStudija.values()));
				panel_1.add(comboBox, "4, 4, fill, default");
				
				lblPopust = new JLabel("Popust:");
				panel_1.add(lblPopust, "8, 4, right, default");
				
				textField_13 = new JTextField();
				panel_1.add(textField_13, "10, 4, fill, default");
				textField_13.setColumns(10);
				
				lblNewLabel_7 = new JLabel("%");
				panel_1.add(lblNewLabel_7, "12, 4");
				
				btnUnesi = new JButton("Unesi");
				frame.getContentPane().add(btnUnesi, "2, 6, 3, 1");
				
				btnNewButton_1 = new JButton("Iza\u0111i");
				frame.getContentPane().add(btnNewButton_1, "6, 6, right, default");
	}

}