package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controlador.ControladorPanelKomanda;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PanelKomanda extends JPanel {

	private ControladorPanelKomanda controladorPanelKomanda;

	private JTextField tf_Titulua;
	private JTextField tf_Fecha;
	private JTextField tf_Lokala;
	private JTextField tf_TransferentziaZenbakia;
	private JTextField tf_Totala;

	private JLabel lb_Data;
	private JLabel lb_Lokala;
	private JLabel lb_TransferentziaZenbakia;
	private JLabel lb_Totala;
	private JLabel argazkiak;

	private JButton btnAtzera;
	private JButton btnAurrera;
	private JButton btnSegi;
	private JRadioButton rdbtnLehenengoa;
	private JRadioButton rdbtnBigarrena;
	private JRadioButton rdbtnPostre;

	private JComboBox<String> cb_Platerrak = new JComboBox<String>();
	private JComboBox<String> cb_Mota = new JComboBox<String>();
	private JComboBox<String> cb_Produktoak = new JComboBox<String>();
	private JSpinner nºunidades;
	private String[] platerrak;
	private String[] produktuak;
	private String[] platerMotak;

	private int TransferentziaZenbakia;
	private int anyo;
	private int mes;
	private int dia;

	// *****************************************************************************************************************************************************************************************************

	public PanelKomanda(ControladorPanelKomanda controladorPanelKomanda) {
		this.controladorPanelKomanda = controladorPanelKomanda;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		Calendar fecha = new GregorianCalendar();

		anyo = fecha.get(Calendar.YEAR);
		mes = fecha.get(Calendar.MONTH);
		dia = fecha.get(Calendar.DAY_OF_MONTH);

		// _______________________________________________________________________________________________________________________________________________________________________________

		tf_Titulua = new JTextField();
		tf_Titulua.setFont(new Font("Tahoma", Font.BOLD, 12));
		tf_Titulua.setForeground(new Color(255, 255, 255));
		tf_Titulua.setBounds(10, 5, 432, 20);
		tf_Titulua.setBackground(new Color(0, 0, 255));
		tf_Titulua.setHorizontalAlignment(SwingConstants.LEFT);
		tf_Titulua.setText(" \u2666\uFE0F Komanda Kalkuloak \u2666\uFE0F");
		tf_Titulua.setColumns(10);
		tf_Titulua.setEditable(false);
		add(tf_Titulua);

		tf_Fecha = new JTextField(dia + "/" + (mes + 1) + "/" + anyo);
		tf_Fecha.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Fecha.setBounds(367, 36, 75, 20);
		tf_Fecha.setColumns(10);
		tf_Fecha.setEditable(false);
		add(tf_Fecha);

		tf_Lokala = new JTextField(controladorPanelKomanda.konprobatuLokalarenIzena());
		tf_Lokala.setFont(new Font("Tahoma", Font.ITALIC, 9));
		tf_Lokala.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Lokala.setBounds(61, 36, 75, 20);
		tf_Lokala.setColumns(10);
		tf_Lokala.setEditable(false);
		add(tf_Lokala);

		try {
			TransferentziaZenbakia = controladorPanelKomanda.jasoTransakzioZbk();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		tf_TransferentziaZenbakia = new JTextField(String.valueOf(TransferentziaZenbakia));
		tf_TransferentziaZenbakia.setHorizontalAlignment(SwingConstants.CENTER);
		tf_TransferentziaZenbakia.setBounds(226, 36, 75, 20);
		tf_TransferentziaZenbakia.setColumns(10);
		tf_TransferentziaZenbakia.setEditable(false);
		add(tf_TransferentziaZenbakia);

		tf_Totala = new JTextField("0.0");
		tf_Totala.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Totala.setBounds(61, 267, 183, 20);
		tf_Totala.setColumns(10);
		tf_Totala.setEditable(false);
		add(tf_Totala);

		// _______________________________________________________________________________________________________________________________________________________________________________

		lb_Data = new JLabel("Data:");
		lb_Data.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lb_Data.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Data.setBounds(328, 39, 46, 14);
		add(lb_Data);

		lb_Lokala = new JLabel("Lokala:");
		lb_Lokala.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lb_Lokala.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Lokala.setBounds(20, 39, 46, 14);
		add(lb_Lokala);

		lb_TransferentziaZenbakia = new JLabel("Trans Zbk:");
		lb_TransferentziaZenbakia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lb_TransferentziaZenbakia.setHorizontalAlignment(SwingConstants.CENTER);
		lb_TransferentziaZenbakia.setBounds(170, 39, 57, 14);
		add(lb_TransferentziaZenbakia);

		lb_Totala = new JLabel("Totala:");
		lb_Totala.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Totala.setBounds(20, 270, 46, 14);
		add(lb_Totala);

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
		add(btnAurrera);

		btnSegi = new JButton("\u2714\uFE0F");
		btnSegi.setHorizontalAlignment(SwingConstants.TRAILING);
		btnSegi.setBounds(388, 232, 57, 23);
		btnSegi.setEnabled(false);
		add(btnSegi);

		rdbtnLehenengoa = new JRadioButton("Lehenengoa");
		rdbtnLehenengoa.setBounds(30, 134, 211, 21);
		rdbtnLehenengoa.setEnabled(false);
		add(rdbtnLehenengoa);

		rdbtnBigarrena = new JRadioButton("Bigarrena");
		rdbtnBigarrena.setBounds(30, 165, 211, 21);
		rdbtnBigarrena.setEnabled(false);
		add(rdbtnBigarrena);

		rdbtnPostre = new JRadioButton("Postre");
		rdbtnPostre.setBounds(30, 200, 211, 21);
		rdbtnPostre.setEnabled(false);
		add(rdbtnPostre);

		// _______________________________________________________________________________________________________________________________________________________________________________

		int min = 0;
		int max = 100;
		int step = 1;
		int initValue = 0;
		SpinnerModel model = new SpinnerNumberModel(initValue, min, max, step);

		nºunidades = new JSpinner(model);
		nºunidades.setBounds(254, 233, 120, 20);
		add(nºunidades);

		cb_Platerrak = new JComboBox<String>();
		cb_Platerrak.setBounds(30, 68, 214, 20);
		add(cb_Platerrak);

		platerrak = controladorPanelKomanda.platerrakJaso();
		produktuArrayaPantailaratu(platerrak);

		cb_Mota = new JComboBox<String>();
		cb_Mota.setBounds(30, 233, 214, 20);
		add(cb_Mota);

		platerMotak = controladorPanelKomanda.platerMotak();
		for (int i = 0; i < platerMotak.length; i++) {
			cb_Mota.addItem(platerMotak[i]);
		}
		cb_Mota.setSelectedItem(null);

		cb_Produktoak = new JComboBox<String>();
		cb_Produktoak.setBounds(30, 99, 214, 20);
		add(cb_Produktoak);

		produktuak = controladorPanelKomanda.ComboBoxaSakatuProduktuak();
		for (int i = 0; i < produktuak.length; i++) {
			cb_Produktoak.addItem(produktuak[i]);
		}
		cb_Produktoak.setSelectedItem(null);

		try {
			controladorPanelKomanda.hasieratuOperaciones();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnAurrera.addActionListener(listenerLaburpeneraBotoia(this.controladorPanelKomanda));
		this.btnAtzera.addActionListener(listenerAtzeraBotoia(this.controladorPanelKomanda));
		this.cb_Platerrak.addActionListener(listenerComboBox(this.controladorPanelKomanda));
		this.btnSegi.addActionListener(listenerSegiBotoia(this.controladorPanelKomanda));
		this.rdbtnLehenengoa.addActionListener(listenerRdbbtnLehenengoa(this.controladorPanelKomanda));
		this.rdbtnBigarrena.addActionListener(listenerRdbtnBigarrena(this.controladorPanelKomanda));
		this.rdbtnPostre.addActionListener(listenerRdbtnPostre(this.controladorPanelKomanda));
		this.cb_Mota.addActionListener(listenerPlaterrak(this.controladorPanelKomanda));
		this.cb_Produktoak.addActionListener(listenerProduktuak(this.controladorPanelKomanda));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerLaburpeneraBotoia(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelKomanda.sakatuLaburpeneraBotoia();
				try {
					controladorPanelKomanda.sartuKomanda(anyo, mes, dia);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				controladorPanelKomanda.ofrece();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerAtzeraBotoia(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorPanelKomanda.ezabatuKomanda();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				if (controladorPanelKomanda.konprobatuLokala().equals("Restaurante")) {
					controladorPanelKomanda.sakatuPanelJatetxeBotoia();
				} else if (controladorPanelKomanda.konprobatuLokala().equals("Bar")) {
					controladorPanelKomanda.sakatuPanelTabernaBotoia();
				} else {
					controladorPanelKomanda.sakatuPanelKafetegiaBotoia();
				}
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSegiBotoia(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String aukeraPlaterra = (String) cb_Platerrak.getSelectedItem();
				String aukeraProduktua = (String) cb_Produktoak.getSelectedItem();
				int kantitatea = Integer.parseInt(nºunidades.getValue().toString());

				if (aukeraPlaterra != null) {
					int platerKodea = controladorPanelKomanda.platerKodea(aukeraPlaterra);
					if (kantitatea != 0) {
						controladorPanelKomanda.sartu(aukeraPlaterra, kantitatea);
						try {
							controladorPanelKomanda.incluye(platerKodea, kantitatea);
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
				} else {
					int stockKantitatea = controladorPanelKomanda.begiratuStock(aukeraProduktua,
							controladorPanelKomanda.konprobatuNIF());
					if (kantitatea > stockKantitatea) {
						JOptionPane.showMessageDialog(null, " Ez dago hainbeste unitate stock-ean. Egin apro", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (kantitatea != 0) {
							controladorPanelKomanda.sartu(aukeraProduktua, kantitatea);
						}
					}
				}

				String diruTotala = String.valueOf(controladorPanelKomanda.diruTotala());
				tf_Totala.setText(diruTotala);

				rdbtnLehenengoa.setEnabled(false);
				rdbtnLehenengoa.setSelected(false);
				rdbtnBigarrena.setEnabled(false);
				rdbtnBigarrena.setSelected(false);
				rdbtnPostre.setEnabled(false);
				rdbtnPostre.setSelected(false);
				cb_Mota.setSelectedItem(null);
				cb_Platerrak.setSelectedItem(null);
				cb_Produktoak.setSelectedItem(null);
				nºunidades.setValue(0);
				cb_Platerrak.setEnabled(false);
				cb_Produktoak.setEnabled(true);
				cb_Mota.setEnabled(true);
				argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerComboBox(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aukeratutakoa = (String) cb_Platerrak.getSelectedItem();
				aukeratuBat("Platerra");
				if (aukeratutakoa == null) {
					btnSegi.setEnabled(false);
				} else {
					btnSegi.setEnabled(true);
				}
				ImageIcon argazkia = (ImageIcon) controladorPanelKomanda.argazkiaPlaterraAukeratu(aukeratutakoa);
				argazkiak.setIcon(argazkia);
			}
		};
	}

	private ActionListener listenerProduktuak(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aukeratutakoa = (String) cb_Produktoak.getSelectedItem();
				aukeratuBat("Produktua");
				if (aukeratutakoa == null) {
					btnSegi.setEnabled(false);
				} else {
					btnSegi.setEnabled(true);
				}
				ImageIcon argazkia = (ImageIcon) controladorPanelKomanda.argazkiaPlaterraAukeratu(aukeratutakoa);
				argazkiak.setIcon(argazkia);
			}
		};
	}

	private ActionListener listenerRdbbtnLehenengoa(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String platerMota = (String) cb_Mota.getSelectedItem();
				String tipoa = "Primero";
				int zbk = 1;
				produktuakEtaMotaJaso(platerMota, tipoa, zbk);
				argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));
			}
		};
	}

	private ActionListener listenerRdbtnBigarrena(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String platerMota = (String) cb_Mota.getSelectedItem();
				String tipoa = "Segundo";
				int zbk = 2;
				produktuakEtaMotaJaso(platerMota, tipoa, zbk);
				argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));
			}
		};
	}

	private ActionListener listenerRdbtnPostre(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String platerMota = (String) cb_Mota.getSelectedItem();
				String tipoa = "Postre";
				int zbk = 3;
				produktuakEtaMotaJaso(platerMota, tipoa, zbk);
				argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));
			}
		};
	}

	private ActionListener listenerPlaterrak(ControladorPanelKomanda controladorPanelKomanda) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cb_Platerrak.setEnabled(true);
				rdbtnLehenengoa.setEnabled(true);
				rdbtnBigarrena.setEnabled(true);
				rdbtnPostre.setEnabled(true);
				rdbtnLehenengoa.setSelected(false);
				rdbtnBigarrena.setSelected(false);
				rdbtnPostre.setSelected(false);
				String platerMota = (String) cb_Mota.getSelectedItem();
				aukeratuBat("Mota");
				String[] platerMotaArabera = controladorPanelKomanda.platerMotaArabera(platerMota);
				produktuArrayaPantailaratu(platerMotaArabera);
				argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));
			}
		};
	}

	private void produktuakEtaMotaJaso(String platerMota, String tipoa, int zbk) {
		JRadioButton botoia = aukeratutakoBotoia(zbk);
		if (botoia.isSelected() == true) {
			produktuak = controladorPanelKomanda.platerMota(platerMota, tipoa);
			produktuArrayaPantailaratu(produktuak);
		} else {
			rdbtnLehenengoa.setEnabled(true);
			rdbtnBigarrena.setEnabled(true);
			rdbtnPostre.setEnabled(true);
			produktuak = controladorPanelKomanda.platerMotaArabera(platerMota);
			produktuArrayaPantailaratu(produktuak);
			argazkiak.setIcon(new ImageIcon("argazkiak/blanco.jpg"));
		}
	}

	private JRadioButton aukeratutakoBotoia(int zbk) {
		if (zbk == 1) {
			rdbtnBigarrena.setEnabled(false);
			rdbtnPostre.setEnabled(false);
			return rdbtnLehenengoa;
		} else if (zbk == 2) {
			rdbtnLehenengoa.setEnabled(false);
			rdbtnPostre.setEnabled(false);
			return rdbtnBigarrena;
		} else {
			rdbtnBigarrena.setEnabled(false);
			rdbtnLehenengoa.setEnabled(false);
			return rdbtnPostre;
		}
	}

	private void produktuArrayaPantailaratu(String[] produktuak) {
		cb_Platerrak.removeAllItems();
		for (int i = 0; i < produktuak.length; i++) {
			cb_Platerrak.addItem(produktuak[i]);
		}
		cb_Platerrak.setSelectedItem(null);
	}

	private void aukeratuBat(String aukeratutakoa) {

		if (aukeratutakoa.equals("Platerra")) {
			cb_Platerrak.setEnabled(true);
			cb_Produktoak.setEnabled(false);
			cb_Mota.setEnabled(true);
		}
		if (aukeratutakoa.equals("Mota")) {
			cb_Mota.setEnabled(true);
			cb_Produktoak.setEnabled(false);
			cb_Platerrak.setEnabled(true);
		}
		if (aukeratutakoa.equals("Produktua")) {
			cb_Platerrak.setEnabled(false);
			cb_Mota.setEnabled(false);
			cb_Produktoak.setEnabled(true);
			rdbtnLehenengoa.setEnabled(false);
			rdbtnLehenengoa.setSelected(false);
			rdbtnBigarrena.setEnabled(false);
			rdbtnBigarrena.setSelected(false);
			rdbtnPostre.setEnabled(false);
			rdbtnPostre.setSelected(false);
		}
	}
}