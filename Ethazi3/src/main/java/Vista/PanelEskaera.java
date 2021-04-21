package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelEskaera;

import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PanelEskaera extends JPanel {

	private ControladorPanelEskaera controladorPanelEskaera;

	private JTextField tf_Titulua;
	private JTextField tf_Lokala;
	private JTextField tf_TransferentziaZenbakia;
	private JTextField tf_Helbide;
	private JLabel lb_Lokala;
	private JLabel lb_TransferentziaZenbakia;
	private JLabel argazkiak;

	private JButton btnAtzera;
	private JButton btnAurrera;
	private JButton btnSegi;
	private JRadioButton rb_Helbide;

	private JComboBox<String> cb_Produktoak = new JComboBox<String>();
	private JFormattedTextField tf;
	private JSpinner nºunidades;
	private String[] produktuak;

	private int TransferentziaZenbakia;


	// *****************************************************************************************************************************************************************************************************

	public PanelEskaera(ControladorPanelEskaera controladorPanelEskaera) {
		this.controladorPanelEskaera = controladorPanelEskaera;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// _______________________________________________________________________________________________________________________________________________________________________________

		tf_Titulua = new JTextField();
		tf_Titulua.setFont(new Font("Tahoma", Font.BOLD, 12));
		tf_Titulua.setForeground(new Color(255, 255, 255));
		tf_Titulua.setBounds(10, 5, 432, 20);
		tf_Titulua.setBackground(new Color(0, 0, 255));
		tf_Titulua.setHorizontalAlignment(SwingConstants.LEFT);
		tf_Titulua.setText(" \u2666\uFE0F Eskaera Kalkuloak \u2666\uFE0F");
		tf_Titulua.setColumns(10);
		tf_Titulua.setEditable(false);
		add(tf_Titulua);

		tf_Lokala = new JTextField(controladorPanelEskaera.konprobatuLokalarenIzena());
		tf_Lokala.setFont(new Font("Tahoma", Font.ITALIC, 9));
		tf_Lokala.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Lokala.setBounds(61, 36, 75, 20);
		tf_Lokala.setColumns(10);
		tf_Lokala.setEditable(false);
		add(tf_Lokala);

		try {
			TransferentziaZenbakia = controladorPanelEskaera.jasoTransakzioZbk();
		} catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}

		tf_TransferentziaZenbakia = new JTextField(String.valueOf(TransferentziaZenbakia));
		tf_TransferentziaZenbakia.setHorizontalAlignment(SwingConstants.CENTER);
		tf_TransferentziaZenbakia.setBounds(367, 35, 75, 20);
		tf_TransferentziaZenbakia.setColumns(10);
		tf_TransferentziaZenbakia.setEditable(false);
		add(tf_TransferentziaZenbakia);

		tf_Helbide = new JTextField("");
		tf_Helbide.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Helbide.setBounds(87, 267, 157, 20);
		tf_Helbide.setColumns(10);
		tf_Helbide.setEnabled(false);
		add(tf_Helbide);

		lb_Lokala = new JLabel("Lokala:");
		lb_Lokala.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lb_Lokala.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Lokala.setBounds(20, 39, 46, 14);
		add(lb_Lokala);

		lb_TransferentziaZenbakia = new JLabel("Trans Zbk:");
		lb_TransferentziaZenbakia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lb_TransferentziaZenbakia.setHorizontalAlignment(SwingConstants.CENTER);
		lb_TransferentziaZenbakia.setBounds(300, 38, 57, 14);
		add(lb_TransferentziaZenbakia);

		argazkiak = new JLabel();
		argazkiak.setBounds(254, 67, 188, 154);
		argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));
		add(argazkiak);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnAtzera = new JButton(" Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAtzera.setBounds(353, 266, 92, 23);
		add(btnAtzera);

		btnAurrera = new JButton(" Aurrera");
		btnAurrera.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAurrera.setBounds(254, 266, 92, 23);
		btnAurrera.setEnabled(false);
		add(btnAurrera);

		btnSegi = new JButton("\u2714\uFE0F");
		btnSegi.setHorizontalAlignment(SwingConstants.TRAILING);
		btnSegi.setBounds(388, 232, 57, 23);
		btnSegi.setEnabled(false);
		add(btnSegi);

		rb_Helbide = new JRadioButton("Helbide");
		rb_Helbide.setFont(new Font("Tahoma", Font.PLAIN, 9));
		rb_Helbide.setBounds(21, 267, 60, 20);
		add(rb_Helbide);

		// _______________________________________________________________________________________________________________________________________________________________________________

		int min = 0;
		int max = 100;
		int step = 1;
		int initValue = 0;
		SpinnerModel model = new SpinnerNumberModel(initValue, min, max, step);

		nºunidades = new JSpinner(model);
		nºunidades.setBounds(254, 233, 120, 20);
		add(nºunidades);

		tf = ((JSpinner.DefaultEditor) nºunidades.getEditor()).getTextField();
		tf.setEditable(false);

		cb_Produktoak.setBounds(30, 68, 214, 20);
		add(cb_Produktoak);

		produktuak = controladorPanelEskaera.ComboBoxaSakatu();
		for (int i = 0; i < produktuak.length; i++) {
			cb_Produktoak.addItem(produktuak[i]);
		}
		cb_Produktoak.setSelectedItem(null);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnAurrera.addActionListener(listenerLaburpeneraBotoia(this.controladorPanelEskaera));
		this.btnAtzera.addActionListener(listenerAtzeraBotoia(this.controladorPanelEskaera));
		this.cb_Produktoak.addActionListener(listenerComboBox(this.controladorPanelEskaera));
		this.btnSegi.addActionListener(listenerSegiBotoia(this.controladorPanelEskaera));
		this.rb_Helbide.addActionListener(listenerRadioButton());
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerLaburpeneraBotoia(ControladorPanelEskaera controladorPanelEskaera) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (controladorPanelEskaera.konprobatuLokala().equals("Restaurante")) {
					controladorPanelEskaera.sakatuPanelJatetxeBotoia();
				} else if (controladorPanelEskaera.konprobatuLokala().equals("Bar")) {
					controladorPanelEskaera.sakatuPanelTabernaBotoia();
				} else {
					controladorPanelEskaera.sakatuPanelKafetegiaBotoia();
				}
				try {
					controladorPanelEskaera.gordeEskaera(tf_Helbide.getText());
				} catch (ClassNotFoundException | SQLException e) { 
					e.printStackTrace();
				}
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerAtzeraBotoia(ControladorPanelEskaera controladorPanelEskaera) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(controladorPanelEskaera.konprobatuLokala().equals("Restaurante")) {
					controladorPanelEskaera.sakatuPanelJatetxeBotoia();
				}else if(controladorPanelEskaera.konprobatuLokala().equals("Bar")) {
					controladorPanelEskaera.sakatuPanelTabernaBotoia();
				}else {
					controladorPanelEskaera.sakatuPanelKafetegiaBotoia();
				}
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSegiBotoia(ControladorPanelEskaera controladorPanelEskaera) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String aukera = (String) cb_Produktoak.getSelectedItem();
				int kantitatea = Integer.parseInt(nºunidades.getValue().toString());
				int stockKantitatea = controladorPanelEskaera.begiratuStock(aukera, controladorPanelEskaera.konprobatuNIF());
				btnAurrera.setEnabled(true);
				if (kantitatea > stockKantitatea) {
					JOptionPane.showMessageDialog(null, " Ez dago hainbeste unitate stock-ean. Egin apro", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					if (kantitatea != 0) {
						controladorPanelEskaera.sartu(aukera, kantitatea);
					}
				}
				nºunidades.setValue(0);
				btnSegi.setEnabled(false);
				cb_Produktoak.setSelectedItem(null);
				argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerComboBox(ControladorPanelEskaera controladorPanelEskaera) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aukera = (String) cb_Produktoak.getSelectedItem();
				ImageIcon argazkia = (ImageIcon) controladorPanelEskaera.argazkiaAukeratu(aukera);
				if (cb_Produktoak.getSelectedItem() != null) { 
					btnSegi.setEnabled(true);	
				}
				argazkiak.setIcon(argazkia);
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerRadioButton() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rb_Helbide.isSelected() == false) {
					tf_Helbide.setEnabled(false);
				} else {
					tf_Helbide.setEnabled(true);
				}
			}
		};
	}
}
