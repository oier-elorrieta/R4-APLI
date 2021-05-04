package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import Controlador.ControladorPanelLogin; 
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelLogin extends JPanel {

	private ControladorPanelLogin controladorPanelLogin;

	private JButton btnSarratu;
	private JButton btnLogin;
	private JButton btnErregistratu;

	private JLabel lb_NAN;
	private JLabel lb_Pasahitza;

	private JTextField tf_NAN;
	private JPasswordField tf_Pasahitza;

	// *****************************************************************************************************************************************************************************************************

	public PanelLogin(ControladorPanelLogin controladorPanelLogin) {

		this.controladorPanelLogin = controladorPanelLogin;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnSarratu = new JButton("ATZERA ");
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnSarratu.setBounds(350, 260, 90, 30);
		add(btnSarratu);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnLogin.setBounds(165, 170, 115, 21);
		add(btnLogin);

		btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnErregistratu.setBounds(165, 210, 115, 21);
		add(btnErregistratu);

		// _______________________________________________________________________________________________________________________________________________________________________________

		tf_NAN = new JTextField();
		tf_NAN.setBounds(135, 60, 170, 19);
		add(tf_NAN);
		tf_NAN.setColumns(10);

		tf_Pasahitza = new JPasswordField();
		tf_Pasahitza.setColumns(10);
		tf_Pasahitza.setBounds(135, 120, 170, 19);
		add(tf_Pasahitza);

		// _______________________________________________________________________________________________________________________________________________________________________________

		lb_NAN = new JLabel("NAN:");
		lb_NAN.setBounds(135, 37, 170, 13);
		add(lb_NAN);

		lb_Pasahitza = new JLabel("Pasahitza:");
		lb_Pasahitza.setBounds(135, 97, 170, 13);
		add(lb_Pasahitza);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelLogin));
		this.btnLogin.addActionListener(listenerLoginBotoia(this.controladorPanelLogin));
		this.btnErregistratu.addActionListener(listenerErregistratuBotoia(this.controladorPanelLogin));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerLoginBotoia(ControladorPanelLogin controladorPanelLogin) {
		return new ActionListener() {
			@SuppressWarnings({ "deprecation" })
			public void actionPerformed(ActionEvent arg0) {
				String pasahitza = tf_Pasahitza.getText();
				String erabiltzailea = tf_NAN.getText();
				controladorPanelLogin.sartuErabiltzaile(erabiltzailea, pasahitza); 
				String lokalaMota = controladorPanelLogin.konprobatuLokala();
				String erroreaLogeatzean = controladorPanelLogin.konprobatuErabiltzailea(erabiltzailea, pasahitza);

				if (erroreaLogeatzean.equals("EZ")) {
					if (lokalaMota.equals("Bar")) {
						controladorPanelLogin.sakatuPanelTabernaBotoia();
					} else if (lokalaMota.equals("Cafetería")) {
						controladorPanelLogin.sakatuPanelKafetegiaBotoia();
					} else if (lokalaMota.equals("Restaurante")) {
						controladorPanelLogin.sakatuPanelJatetxeBotoia();
					}
				} else {
					controladorPanelLogin.ikusiPanelLogin();
				}
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerErregistratuBotoia(ControladorPanelLogin controladorPanelLogin) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelLogin.sakatuPanelErregistratuBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelLogin controladorPanelLogin) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelLogin.hasieraraBotoia();
			}
		};
	}
}
