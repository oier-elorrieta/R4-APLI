package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;  
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Controlador.ControladorPanelErregistratu;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelErregistratu extends JPanel {

	private ControladorPanelErregistratu controladorPanelErregistratu; 

	private JButton btnSarratu;
	private JButton btnErregistratu;
	private JButton btnAtzera;

	private JTextField tf_Izena;
	private JTextField tf_Abizena;
	private JPasswordField tf_Pasahitza;
	private JTextField tf_NAN;
	private JTextField tf_NIF;

	private JLabel lb_Pasahitza;
	private JLabel lb_NAN;
	private JLabel lb_NIF;
	private JLabel lb_Abizena;
	private JLabel lb_Izena;

	// *****************************************************************************************************************************************************************************************************

	public PanelErregistratu(ControladorPanelErregistratu controladorPanelErregistratu) {

		this.controladorPanelErregistratu = controladorPanelErregistratu; 

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(250, 236, 190, 21);
		add(btnSarratu);

		btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnErregistratu.setBounds(250, 118, 190, 21);
		add(btnErregistratu);

		btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnAtzera.setBounds(250, 181, 190, 21);
		add(btnAtzera);

		// _______________________________________________________________________________________________________________________________________________________________________________

		tf_Izena = new JTextField();
		tf_Izena.setBounds(10, 61, 190, 19);
		add(tf_Izena);
		tf_Izena.setColumns(10);

		tf_Abizena = new JTextField();
		tf_Abizena.setColumns(10);
		tf_Abizena.setBounds(10, 120, 190, 19);
		add(tf_Abizena);

		tf_Pasahitza = new JPasswordField();
		tf_Pasahitza.setColumns(10);
		tf_Pasahitza.setBounds(10, 236, 190, 19);
		add(tf_Pasahitza);

		tf_NAN = new JTextField();
		tf_NAN.setColumns(10);
		tf_NAN.setBounds(10, 182, 190, 19);
		add(tf_NAN);

		tf_NIF = new JTextField();
		tf_NIF.setColumns(10);
		tf_NIF.setBounds(250, 61, 190, 19);
		add(tf_NIF);

		// _______________________________________________________________________________________________________________________________________________________________________________

		lb_Pasahitza = new JLabel("Pasahitza:");
		lb_Pasahitza.setBounds(10, 212, 190, 13);
		add(lb_Pasahitza);

		lb_Abizena = new JLabel("Abizena:");
		lb_Abizena.setBounds(10, 96, 190, 13);
		add(lb_Abizena);

		lb_Izena = new JLabel("Izena:");
		lb_Izena.setBounds(10, 37, 190, 13);
		add(lb_Izena);

		lb_NIF = new JLabel("NIF:");
		lb_NIF.setBounds(250, 37, 190, 13);
		add(lb_NIF);

		lb_NAN = new JLabel("NAN:");
		lb_NAN.setBounds(10, 158, 190, 13);
		add(lb_NAN);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelErregistratu));
		this.btnErregistratu.addActionListener(listenerErregistratuBotoia(this.controladorPanelErregistratu));
		this.btnAtzera.addActionListener(listenerAtzeraBotoia(this.controladorPanelErregistratu));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerErregistratuBotoia(ControladorPanelErregistratu controladorPanelErregistratu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				String izena = tf_Izena.getText();
				String abizena = tf_Abizena.getText();
				@SuppressWarnings("deprecation")
				String pasahitza = tf_Pasahitza.getText();
				String NAN = tf_NAN.getText();
				String nif = tf_NIF.getText();
				boolean luzeeraEgokia = controladorPanelErregistratu.konprobatuErabiltzaileAtributuenLuzeera(NAN, izena, abizena, pasahitza, nif);
				boolean badagoNAN = controladorPanelErregistratu.begiratuNAN(NAN);
				boolean onanif = controladorPanelErregistratu.begiratuNIF(nif); 
				if(luzeeraEgokia == true) {
					if(badagoNAN == true) {
						JOptionPane.showMessageDialog(null, "Erabiltzaile hau badago erregistratuta datu basean", "ERROR", JOptionPane.ERROR_MESSAGE); 
						controladorPanelErregistratu.ikusiPanelErregistratu();
					}else if(onanif == false) {
						JOptionPane.showMessageDialog(null, "NIF ez dago erregistratuta datu basean", "ERROR", JOptionPane.ERROR_MESSAGE);
						controladorPanelErregistratu.ikusiPanelErregistratu();
					}else {
						try {
							controladorPanelErregistratu.sakatuErregistratuBotoia(NAN, izena, abizena, pasahitza, nif);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}	
					}		
					controladorPanelErregistratu.sakatuPanelLogin();
				}else {
					controladorPanelErregistratu.sakatuPanelLogin();
				} 
			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelErregistratu controladorPanelErregistratu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelErregistratu.sakatuItxiBotoia();			}
		};
	} 

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerAtzeraBotoia(ControladorPanelErregistratu controladorPanelErregistratu) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelErregistratu.sakatuAtzeraBotoia();
			}
		};
	} 
}
