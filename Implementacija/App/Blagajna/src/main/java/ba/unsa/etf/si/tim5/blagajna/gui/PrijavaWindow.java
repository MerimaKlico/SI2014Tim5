package ba.unsa.etf.si.tim5.blagajna.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Color;

import javax.swing.JButton;

import ba.unsa.etf.si.tim5.blagajna.dodaci.Dao;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Korisnik;
import ba.unsa.etf.si.tim5.blagajna.entiteti.Student;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PrijavaWindow {

	private JFrame frmPrijava;
	private JTextField textUser;
	private JPasswordField textPass;
	ArrayList<Korisnik> sviKorisnici=new ArrayList<Korisnik>();
	Korisnik logovaniKorisnik=new Korisnik();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrijavaWindow window = new PrijavaWindow();
					window.frmPrijava.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void ucitajSveKorisnike(){
		sviKorisnici= Dao.getInstance().dajSveKorisnike();
	}

	/**
	 * Create the application.
	 */
	public PrijavaWindow() {
		initialize();
		ucitajSveKorisnike();
		//System.out.println(sviKorisnici.get(0).getKorisnickoIme());
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrijava = new JFrame();
		frmPrijava.setTitle("Prijava");
		frmPrijava.setBounds(100, 100, 342, 201);
		frmPrijava.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrijava.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("21px"),
				ColumnSpec.decode("89px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("9px"),
				ColumnSpec.decode("53px"),
				ColumnSpec.decode("89px"),},
			new RowSpec[] {
				RowSpec.decode("34px"),
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				RowSpec.decode("20px"),
				RowSpec.decode("23px"),}));
		
		JLabel lblKorisnikoIme = new JLabel("Korisni\u010Dko ime:");
		frmPrijava.getContentPane().add(lblKorisnikoIme, "2, 2, right, center");
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		frmPrijava.getContentPane().add(lblLozinka, "2, 4, right, center");
		
		textUser = new JTextField();
		frmPrijava.getContentPane().add(textUser, "4, 2, 3, 1, fill, top");
		textUser.setColumns(10);
		
		textPass = new JPasswordField();
		frmPrijava.getContentPane().add(textPass, "4, 4, 3, 1, fill, top");
		
		JLabel lblZaboraviliSteLozinku = new JLabel("Zaboravili ste lozinku ?");
		lblZaboraviliSteLozinku.setForeground(Color.BLUE);
		frmPrijava.getContentPane().add(lblZaboraviliSteLozinku, "4, 6, 3, 1, fill, top");
		
		JButton btnPrijaviSe = new JButton("Prijavi se");
		btnPrijaviSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logovaniKorisnik.setKorisnickoIme("");
				String username=textUser.getText();
				char[] password=textPass.getPassword();
				
				String passString = new String(password);
				boolean user=false;
						
			
				
				for(int i=0;i<sviKorisnici.size();i++)
				{	
					if(sviKorisnici.get(i).getKorisnickoIme().equals(username))
					{   //System.out.println(password);
						//logovaniKorisnik.setKorisnickoIme(username);
						user=true;
						if(sviKorisnici.get(i).getLozinka().equals(passString))
						{
							
							
							logovaniKorisnik=sviKorisnici.get(i);
							MainWindow window = new MainWindow(logovaniKorisnik);
							window.frmBlagajna.setVisible(true);
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Password je netačan, pokušajte ponovo!", "InfoBox: " + "Greška", JOptionPane.INFORMATION_MESSAGE);
							textPass.setText("");
						}
						break;	
					}
				}
				
				if(user==false)
				{	//System.out.println(logovaniKorisnik.getKorisnickoIme()+"los");
					
					JOptionPane.showMessageDialog(null, "Username je netačan, pokušajte ponovo!", "InfoBox: " + "Greška", JOptionPane.INFORMATION_MESSAGE);
					textPass.setText("");
					textUser.setText("");
				}
				
			}
		});
		frmPrijava.getContentPane().add(btnPrijaviSe, "2, 8, 3, 1, right, top");
		
		JButton btnIzai = new JButton("Iza\u0111i");
		frmPrijava.getContentPane().add(btnIzai, "6, 8, fill, top");
	}
}
