package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.util.HibernateUtil;



import org.hibernate.Query;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.Panel;

import javax.swing.JList;

import java.awt.Choice;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;

import java.awt.ScrollPane;

import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.List;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import org.hibernate.Session;

import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainWindow {

	JFrame frmBlagajna;
	private JTable table;
	private JTextField textField;
	ArrayList<Student> sviStudenti;
	Korisnik user=new Korisnik();
	boolean userExist=false;

	public void ucitajSveStudente() {

		/*
		 * Session session = HibernateUtil.getSessionFactory().openSession();
		 * org.hibernate.Transaction t=session.beginTransaction();
		 * 
		 * String statement = "SELECT * FROM Student"; org.hibernate.Query query
		 * = session.createQuery(statement);
		 * 
		 * t.commit(); ArrayList<Student> list =
		 * (ArrayList<Student>)query.list();
		 */
		sviStudenti = Dao.getInstance().dajSveStudente();		
        
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < sviStudenti.size(); i++) {
			
			
			model.addRow(new Object[] { sviStudenti.get(i).getId(),
					sviStudenti.get(i).getIme() + sviStudenti.get(i).getPrezime(),
					sviStudenti.get(i).getIndeks(),
					sviStudenti.get(i).getTroskoviSkolarine(),
					sviStudenti.get(i).getTroskoviLiterature() }
					);
		}

	}

	/**
	 * Create the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmBlagajna.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static ArrayList<Student> studenti = new ArrayList<Student>();
	
	public MainWindow() {
		initialize();
	}
	
	public MainWindow(Korisnik k) {
		
		user=k;
		initialize();
		
		
		ucitajSveStudente();
	
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBlagajna = new JFrame();
		frmBlagajna.setTitle("Blagajna\r\n");
		frmBlagajna.setBounds(100, 100, 673, 466);
		frmBlagajna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		FormLayout formLayout = new FormLayout(
				new ColumnSpec[] { FormFactory.UNRELATED_GAP_COLSPEC,
						ColumnSpec.decode("75px:grow"),
						ColumnSpec.decode("122px:grow"),
						ColumnSpec.decode("129px:grow"),
						ColumnSpec.decode("128px:grow"),
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("94px:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"), RowSpec.decode("33px"),
						RowSpec.decode("fill:269px:grow"),
						RowSpec.decode("max(25dlu;default)"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, });
		frmBlagajna.getContentPane().setLayout(formLayout);

		JLabel lblDo = new JLabel("Dobar dan, ");
		lblDo.setVerticalAlignment(SwingConstants.TOP);
		lblDo.setHorizontalAlignment(SwingConstants.RIGHT);
		frmBlagajna.getContentPane().add(lblDo, "2, 4");

		JLabel lblIme = new JLabel("{Ime}");
		lblIme.setText(user.getIme());
		frmBlagajna.getContentPane().add(lblIme, "3, 4");
		//if(userExist==true)
		//System.out.println(user.ge);
		
		JLabel label = new JLabel("Pretraga po:");
		frmBlagajna.getContentPane().add(label, "3, 5, center, default");

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Indeks",
				"Ime", "Dug za skolarinu", "Dug za literaturu" }));
		frmBlagajna.getContentPane().add(comboBox, "4, 5");

		textField = new JTextField();
		frmBlagajna.getContentPane().add(textField, "5, 5");
		textField.setColumns(10);

		JButton btnPretrai = new JButton("Pretra\u017Ei");
		btnPretrai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String izbor = comboBox.getSelectedItem().toString();
				
				// session.beginTransaction();
				//System.out.println(izbor);
				studenti.clear();
				if (izbor == "Indeks") {
				
					
					String indeks = textField.getText();

					//String statement = "SELECT * FROM Student WHERE indeks="
							//+ Integer.parseInt(indeks);
					
					//Query query = session.createQuery("from Student where  = :id ");
					//query.setParameter("id", indeks);
					//List<?> list = query.list();

					//Query query = session.createQuery(statement);
					//ArrayList<Student> list = (ArrayList<Student>)query.list();
					//java.util.List list=query.list();
					
					for (int i = 0; i < sviStudenti.size(); i++) {
						if(sviStudenti.get(i).getIndeks()== Integer.parseInt(indeks))
							studenti.add(sviStudenti.get(i));
					}
					//System.out.println(studenti.size());
					//studenti = list;
		
					
					DefaultTableModel model = (DefaultTableModel) table
							.getModel();
						model.setRowCount(0);
					for (int i = 0; i < studenti.size(); i++) {
						model.addRow(new Object[] {
								studenti.get(i).getId(),
								studenti.get(i).getIme()
										+ studenti.get(i).getPrezime(),
								studenti.get(i).getIndeks(),
								studenti.get(i).getTroskoviSkolarine(),
								studenti.get(i).getTroskoviLiterature() });
					}

					// Student dbStudent = (Student)session.get(Student.class,
					// indeks);

					// table.add()
				}

				else if (izbor == "Ime") {
					String ime = textField.getText();

					for (int i = 0; i < sviStudenti.size(); i++) {
						if(sviStudenti.get(i).getIme().contains(ime))
							studenti.add(sviStudenti.get(i));
					}
					
					DefaultTableModel model = (DefaultTableModel) table
							.getModel();
						model.setRowCount(0);
					for (int i = 0; i < studenti.size(); i++) {
						model.addRow(new Object[] {
								studenti.get(i).getId(),
								studenti.get(i).getIme()
										+ studenti.get(i).getPrezime(),
								studenti.get(i).getIndeks(),
								studenti.get(i).getTroskoviSkolarine(),
								studenti.get(i).getTroskoviLiterature() });
					}
				}

				else if (izbor == "Dug za skolarinu") {
					String dugSkolarina = textField.getText();

					for (int i = 0; i < sviStudenti.size(); i++) {
						if(sviStudenti.get(i).dajDugZaSkolarinu()==Double.parseDouble(dugSkolarina))
							studenti.add(sviStudenti.get(i));
					}
					
					DefaultTableModel model = (DefaultTableModel) table
							.getModel();
					model.setRowCount(0);
					for (int i = 0; i < studenti.size(); i++) {
						model.addRow(new Object[] {
								studenti.get(i).getId(),
								studenti.get(i).getIme()
										+ studenti.get(i).getPrezime(),
								studenti.get(i).getIndeks(),
								studenti.get(i).getTroskoviSkolarine(),
								studenti.get(i).getTroskoviLiterature() });
					}
					// String s = table.getValueAt(1, 1).toString();
					// JOptionPane.showMessageDialog(null,s,"Message",JOptionPane.INFORMATION_MESSAGE);
				}

				else if (izbor == "Dug za literaturu") {
					String dugLiteratura = textField.getText();

					for (int i = 0; i < sviStudenti.size(); i++) {
						if(sviStudenti.get(i).getTroskoviLiterature()==Double.parseDouble(dugLiteratura))
							studenti.add(sviStudenti.get(i));
					}
					
					DefaultTableModel model = (DefaultTableModel) table
							.getModel();
					model.setRowCount(0);
					for (int i = 0; i < studenti.size(); i++) {
						model.addRow(new Object[] {
								studenti.get(i).getId(),
								studenti.get(i).getIme()
										+ studenti.get(i).getPrezime(),
								studenti.get(i).getIndeks(),
								studenti.get(i).getTroskoviSkolarine(),
								studenti.get(i).getTroskoviLiterature() });
					}

				}
				
			}
		});

		// List getStudentsByName(String name)
		// {
		// Session currentSession = sessionFactory.getCurrentSession();

		// List<Student> list = currentSession.createCriteria(Student.class)
		// .add(Restrictions.eq("name", name))
		// .list();
		// return list;
		// }
		frmBlagajna.getContentPane().add(btnPretrai, "6, 5");

		JScrollPane scrollPane = new JScrollPane();
		frmBlagajna.getContentPane().add(scrollPane, "2, 6, 7, 1");

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Ime i Prezime", "Indeks",
				"Dug za \u0161koralinu", "Dug za literaturu" }));

		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()!=-1){
					int indexSelektovani = table.getSelectedRow();
					long idStudenta = (long) Integer.parseInt((table.getValueAt(
							indexSelektovani, 0).toString()));
					
					Session session1 = HibernateUtil.getSessionFactory().openSession();

					for (int i = 0; i < sviStudenti.size(); i++) {
						if (sviStudenti.get(i).getId() == idStudenta) {

							sviStudenti.get(i).obrisiStudenta(session1);
							session1.close();
							sviStudenti.remove(i);
							
							DefaultTableModel model = (DefaultTableModel) table
									.getModel();
							model.setRowCount(0);
							for (int j = 0; j < sviStudenti.size(); j++) {
								model.addRow(new Object[] {
										sviStudenti.get(j).getId(),
										sviStudenti.get(j).getIme()
												+ sviStudenti.get(j).getPrezime(),
										sviStudenti.get(j).getIndeks(),
										sviStudenti.get(j).getTroskoviSkolarine(),
										sviStudenti.get(j).getTroskoviLiterature() });
							}

						}
					}
					}
					else {
						JOptionPane.showMessageDialog(null, "Morate selektovati nekog studenta!", "InfoBox: " + "Greška", JOptionPane.INFORMATION_MESSAGE);
						    
						
					}
			}
		});

		JButton btnUredi = new JButton("Detalji/\r\nUredi");
		btnUredi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
					int indexSelektovani = table.getSelectedRow();
					long idStudenta = (long) Integer.parseInt((table.getValueAt(
							indexSelektovani, 0).toString()));

					for (int i = 0; i < sviStudenti.size(); i++) {
						if (sviStudenti.get(i).getId() == idStudenta) {
							UnosWindow window = new UnosWindow(sviStudenti.get(i));
							window.frmUnosStudenta.setVisible(true);

						}
					}
					}
					else {
						JOptionPane.showMessageDialog(null, "Morate selektovati nekog studenta!", "InfoBox: " + "Greška", JOptionPane.INFORMATION_MESSAGE);
						    
						
					}
			}
		});

		JButton button = new JButton("Uplate");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Student s = new Student();
				
				if(table.getSelectedRow()!=-1){
				int indexSelektovani = table.getSelectedRow();
				long idStudenta = (long) Integer.parseInt((table.getValueAt(
						indexSelektovani, 0).toString()));

				for (int i = 0; i < sviStudenti.size(); i++) {
					if (sviStudenti.get(i).getId() == idStudenta) {
						DugWindow window = new DugWindow(sviStudenti.get(i));
						window.frmDugovanjaUplate.setVisible(true);

					}
				}
				}
				else {
					JOptionPane.showMessageDialog(null, "Morate selektovati nekog studenta!", "InfoBox: " + "Greška", JOptionPane.INFORMATION_MESSAGE);
					    
					
				}

				// DugWindow window = new DugWindow(s);
				// window.frmDugovanjaUplate.setVisible(true);
			}
		});
		frmBlagajna.getContentPane().add(button, "3, 7");

		JButton btnZaduiKnjigu = new JButton("Kupi literaturu");
		btnZaduiKnjigu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1){
					int indexSelektovani = table.getSelectedRow();
					long idStudenta = (long) Integer.parseInt((table.getValueAt(
							indexSelektovani, 0).toString()));

					for (int i = 0; i < sviStudenti.size(); i++) {
						if (sviStudenti.get(i).getId() == idStudenta) {
							KupiLiteraturuWindow window = new KupiLiteraturuWindow(sviStudenti.get(i));
							window.frmKupovinaLiterature.setVisible(true);

						}
					}
					}
					else {
						JOptionPane.showMessageDialog(null, "Morate selektovati nekog studenta!", "InfoBox: " + "Greška", JOptionPane.INFORMATION_MESSAGE);
						    
						
					}
			}
		});
		frmBlagajna.getContentPane()
				.add(btnZaduiKnjigu, "4, 7, right, default");
		frmBlagajna.getContentPane().add(btnUredi, "5, 7, center, default");
		frmBlagajna.getContentPane().add(btnObrisi, "8, 7, fill, default");
		JMenuBar menuBar = new JMenuBar();
		frmBlagajna.setJMenuBar(menuBar);
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);

		JMenuItem mntmUplate = new JMenuItem("Promijeni lozinku");
		mntmUplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PromjenaLozinkeWindow window = new PromjenaLozinkeWindow();
					window.frmPromjenaLozinke.setVisible(true);
			}
		});
		//mntmUplate.addMouseListener(new MouseAdapter() {
			//@Override
			//public void mouseClicked(MouseEvent e) {
			//	PromjenaLozinkeWindow window = new PromjenaLozinkeWindow();
			//	window.frmPromjenaLozinke.setVisible(true);
			//}
		//});
		mnFile.add(mntmUplate);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmNapusti = new JMenuItem("Napusti");
		mnFile.add(mntmNapusti);

		JMenu mnUredi = new JMenu("Uredi");
		menuBar.add(mnUredi);

		JMenuItem mntmUrediUposlenike = new JMenuItem("Uredi korisnike");
		mntmUrediUposlenike.setVisible(false);
		mnUredi.add(mntmUrediUposlenike);

		JMenuItem mntmLiteratura = new JMenuItem("Uredi literaturu");
		mnUredi.add(mntmLiteratura);

		JMenu mnDodaj = new JMenu("Dodaj");
		menuBar.add(mnDodaj);

		JMenuItem mntmDodajStudenta = new JMenuItem("Dodaj studenta");
		mnDodaj.add(mntmDodajStudenta);

		JMenuItem mntmDodajKorisnika = new JMenuItem("Dodaj korisnika");
		mnDodaj.add(mntmDodajKorisnika);

		JMenuItem mntmDodajLiteraturu = new JMenuItem("Dodaj literaturu");
		mnDodaj.add(mntmDodajLiteraturu);

		JMenu mnIzvjetaj = new JMenu("Izvje\u0161taj");
		menuBar.add(mnIzvjetaj);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	}

}
