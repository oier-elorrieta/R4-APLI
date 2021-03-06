package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JPanel;
import Controlador.ControladorPanelHornikuntza;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class PanelHornikuntza extends JPanel {

	private ControladorPanelHornikuntza controladorPanelHornikuntza;

	private JButton btnSarratu;
	private JButton btnAtzera;
	private JButton btnSegi;

	private JComboBox<String> cb_Produktoak = new JComboBox<String>();
	private JFormattedTextField tf;
	private JSpinner nšunidades;
	private String[] produktuak;

	// *****************************************************************************************************************************************************************************************************

	public PanelHornikuntza(ControladorPanelHornikuntza controladorPanelHornikuntza) {

		this.controladorPanelHornikuntza = controladorPanelHornikuntza;

		setBackground(Color.LIGHT_GRAY);
		setBounds(0, 0, 450, 300);
		setLayout(null);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnSarratu = new JButton("SARRATU ");
		btnSarratu.setBounds(250, 268, 190, 21);
		btnSarratu.setFont(new Font("Tahoma", Font.ITALIC, 11));
		add(btnSarratu);

		btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(10, 268, 190, 21);
		btnAtzera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		add(btnAtzera);
		
		btnSegi = new JButton("\u2714\uFE0F");
		btnSegi.setBounds(351, 234, 89, 23);
		btnSegi.setEnabled(false);
		add(btnSegi);

		// _______________________________________________________________________________________________________________________________________________________________________________

		cb_Produktoak.setBounds(10, 25, 430, 20);
		add(cb_Produktoak);

		produktuak = controladorPanelHornikuntza.ComboBoxaSakatu();
		for (int i = 0; i < produktuak.length; i++) {
			cb_Produktoak.addItem(produktuak[i]);
		}
		cb_Produktoak.setSelectedItem(null);

		int min = 0;
		int max = 100;
		int step = 1;
		int initValue = 0;
		SpinnerModel model = new SpinnerNumberModel(initValue, min, max, step);

		nšunidades = new JSpinner(model);
		nšunidades.setBounds(10, 234, 331, 23);
		tf = ((JSpinner.DefaultEditor) nšunidades.getEditor()).getTextField();
		tf.setEditable(false);

		add(nšunidades);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.cb_Produktoak.addActionListener(listenerComboBox(this.controladorPanelHornikuntza));
		this.btnSegi.addActionListener(listenerSegiBotoia(this.controladorPanelHornikuntza));
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelHornikuntza));
		this.btnAtzera.addActionListener(listenerAtzeraBotoia(this.controladorPanelHornikuntza));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSegiBotoia(ControladorPanelHornikuntza controladorPanelHornikuntza) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (controladorPanelHornikuntza.konprobatuLokala().equals("Restaurante")) {
					controladorPanelHornikuntza.sakatuPanelJatetxeBotoia();
				} else if (controladorPanelHornikuntza.konprobatuLokala().equals("Bar")) {
					controladorPanelHornikuntza.sakatuPanelTabernaBotoia();
				} else {
					controladorPanelHornikuntza.sakatuPanelKafetegiaBotoia();
				}

				String nomProduktua = (String) cb_Produktoak.getSelectedItem();
				int kantitatea = Integer.parseInt(nšunidades.getValue().toString());
				String nif = controladorPanelHornikuntza.konprobatuNIF();
				try {
					controladorPanelHornikuntza.sartuHornikuntza(nomProduktua, nif,kantitatea);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelHornikuntza controladorPanelHornikuntza) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelHornikuntza.sakatuAtzeraBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerAtzeraBotoia(ControladorPanelHornikuntza controladorPanelHornikuntza) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (controladorPanelHornikuntza.konprobatuLokala().equals("Restaurante")) {
					controladorPanelHornikuntza.sakatuPanelJatetxeBotoia();
				} else if (controladorPanelHornikuntza.konprobatuLokala().equals("Bar")) {
					controladorPanelHornikuntza.sakatuPanelTabernaBotoia();
				} else {
					controladorPanelHornikuntza.sakatuPanelKafetegiaBotoia();
				}
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerComboBox(ControladorPanelHornikuntza controladorPanelHornikuntza) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cb_Produktoak.getSelectedItem() != null) {
					btnSegi.setEnabled(true);
				}
			}
		};
	}
}
