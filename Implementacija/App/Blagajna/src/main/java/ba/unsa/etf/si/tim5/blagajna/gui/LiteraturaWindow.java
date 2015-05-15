package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JButton;

import ba.unsa.etf.si.tim5.blagajna.entiteti.Literatura;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LiteraturaWindow {

	private JFrame frmUnosDugaZa;
	private JTable table;
	private JLabel lblPrikazLiterature;
	private JPanel panel;
	private JLabel lblIsbn;
	private JLabel lblNaziv;
	private JLabel lblAutor;
	private JLabel lblKoliina;
	private JLabel lblCijena;
	private JTextField tFieldIsbn;
	private JTextField tFieldNaziv;
	private JTextField tFieldAutor;
	private JTextField tFieldKolicina;
	private JTextField tFieldCijena;
	private JButton btnUnesi;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LiteraturaWindow window = new LiteraturaWindow();
					window.frmUnosDugaZa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LiteraturaWindow() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUnosDugaZa = new JFrame();
		frmUnosDugaZa.setTitle("Literatura");
		frmUnosDugaZa.setBounds(100, 100, 467, 511);
		frmUnosDugaZa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUnosDugaZa.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(62dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblPrikazLiterature = new JLabel("Prikaz literature");
		frmUnosDugaZa.getContentPane().add(lblPrikazLiterature, "4, 4");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Id", "ISBN", "Naziv", "Autor", "Koli\u010Dina", "Cijena"
			}
		));
		//frmUnosDugaZa.getContentPane().add(table, "4, 4, fill, fill");
		
		JScrollPane scrollPane = new JScrollPane(table);
		frmUnosDugaZa.getContentPane().add(scrollPane, "4, 6, 5, 3, fill, fill");
		
		btnNewButton = new JButton("Obri\u0161i");
		frmUnosDugaZa.getContentPane().add(btnNewButton, "6, 10, 3, 1");
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Unos literature"));
		frmUnosDugaZa.getContentPane().add(panel, "4, 14, 5, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(152dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblIsbn = new JLabel("ISBN:");
		panel.add(lblIsbn, "2, 4, right, default");
		
		tFieldIsbn = new JTextField();
		panel.add(tFieldIsbn, "4, 4, fill, default");
		tFieldIsbn.setColumns(10);
		
		lblNaziv = new JLabel("Naziv:");
		panel.add(lblNaziv, "2, 6, right, default");
		
		tFieldNaziv = new JTextField();
		panel.add(tFieldNaziv, "4, 6, fill, default");
		tFieldNaziv.setColumns(10);
		
		lblAutor = new JLabel("Autor:");
		panel.add(lblAutor, "2, 8, right, default");
		
		tFieldAutor = new JTextField();
		panel.add(tFieldAutor, "4, 8, fill, default");
		tFieldAutor.setColumns(10);
		
		lblKoliina = new JLabel("Koli\u010Dina:");
		panel.add(lblKoliina, "2, 10, right, default");
		
		tFieldKolicina = new JTextField();
		panel.add(tFieldKolicina, "4, 10, fill, default");
		tFieldKolicina.setColumns(10);
		
		lblCijena = new JLabel("Cijena:");
		panel.add(lblCijena, "2, 12, right, default");
		
		tFieldCijena = new JTextField();
		panel.add(tFieldCijena, "4, 12, fill, default");
		tFieldCijena.setColumns(10);
		
		btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String isbn = tFieldIsbn.getText();
				String naziv = tFieldNaziv.getText();
				String autor = tFieldAutor.getText();
				int kolicina = Integer.parseInt(tFieldKolicina.getText());
				double cijena = Double.parseDouble(tFieldIsbn.getText());
				//Literatura l = new Literatura(1,isbn,naziv, autor, kolicina, cijena);*/
		
			}
		});
		panel.add(btnUnesi, "4, 16");
	}

}
