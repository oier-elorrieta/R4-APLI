package Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelLaburpena;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class PanelLaburpena extends JPanel {

	private ControladorPanelLaburpena controladorPanelLaburpena;

	private JButton btnSegi;

	private JLabel lb_1_;
	private JLabel lb_2_;
	private JLabel lb_3_;
	private JLabel lb_Erosketa;
	private JLabel lb_Nombre;
	private JLabel lb_Total;
	private JLabel lb_TotalCant;
	private JLabel lb_LaburpenIzena;
	private JLabel lb_LaburpenKopurua;
	private JLabel lb_LaburpenPrezioa;
	private int anyo;
	private int mes;
	private int dia;
	

	// *****************************************************************************************************************************************************************************************************

	public PanelLaburpena(ControladorPanelLaburpena controladorPanelLaburpena){

		this.controladorPanelLaburpena = controladorPanelLaburpena;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		Calendar fecha = new GregorianCalendar();

		anyo = fecha.get(Calendar.YEAR);
		mes = fecha.get(Calendar.MONTH);
		dia = fecha.get(Calendar.DAY_OF_MONTH);

		// _______________________________________________________________________________________________________________________________________________________________________________

		String izena = controladorPanelLaburpena.pantailaratuIzena();
		String kopuru = controladorPanelLaburpena.pantailaratuKopurua();
		String prezioa = controladorPanelLaburpena.pantailaratuPrezioa();
		double diruTotala = controladorPanelLaburpena.diruTotala();

		// _______________________________________________________________________________________________________________________________________________________________________________

		lb_Erosketa = new JLabel("EROSKETA");
		lb_Erosketa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb_Erosketa.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Erosketa.setBounds(10, 11, 430, 30);
		add(lb_Erosketa);

		lb_1_ = new JLabel("_____________________________________________________________");
		lb_1_.setBounds(10, 27, 430, 14);
		add(lb_1_);

		lb_2_ = new JLabel("_____________________________________________________________");
		lb_2_.setBounds(10, 51, 430, 14);
		add(lb_2_);

		lb_3_ = new JLabel("_____________________________________________________________");
		lb_3_.setBounds(10, 250, 430, 14);
		add(lb_3_);

		lb_Nombre = new JLabel(controladorPanelLaburpena.konprobatuLokalarenIzena());
		lb_Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Nombre.setBounds(10, 47, 430, 14);
		add(lb_Nombre);

		lb_Total = new JLabel("TOTAL EUR: ");
		lb_Total.setHorizontalAlignment(SwingConstants.LEFT);
		lb_Total.setBounds(10, 245, 155, 20);
		add(lb_Total);

		lb_TotalCant = new JLabel(diruTotala + "€");
		lb_TotalCant.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_TotalCant.setBounds(315, 252, 125, 10);
		add(lb_TotalCant);

		lb_LaburpenIzena = new JLabel(izena);
		lb_LaburpenIzena.setVerticalAlignment(SwingConstants.TOP);
		lb_LaburpenIzena.setBounds(10, 100, 170, 139);
		add(lb_LaburpenIzena);
		
		lb_LaburpenKopurua = new JLabel(kopuru);
		lb_LaburpenKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lb_LaburpenKopurua.setVerticalAlignment(SwingConstants.TOP);
		lb_LaburpenKopurua.setBounds(145, 100, 160, 140);
		add(lb_LaburpenKopurua);
		
		lb_LaburpenPrezioa = new JLabel(prezioa);
		lb_LaburpenPrezioa.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_LaburpenPrezioa.setVerticalAlignment(SwingConstants.TOP);
		lb_LaburpenPrezioa.setBounds(315, 100, 125, 139);
		add(lb_LaburpenPrezioa);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnSegi = new JButton("\u2714");
		btnSegi.setBounds(10, 270, 430, 20);
		add(btnSegi);
		
		JLabel lblNewLabel = new JLabel("Produktua");
		lblNewLabel.setBounds(10, 75, 125, 15);
		add(lblNewLabel);
		
		JLabel lblKopurua = new JLabel("Kopurua");
		lblKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblKopurua.setBounds(145, 74, 160, 15);
		add(lblKopurua);
		
		JLabel lblPrezioa = new JLabel("Prezioa");
		lblPrezioa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezioa.setBounds(315, 74, 125, 15);
		add(lblPrezioa);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnSegi.addActionListener(listenerBotonHasierara(this.controladorPanelLaburpena));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerBotonHasierara(ControladorPanelLaburpena controladorPanelLaburpena) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorPanelLaburpena.sartuTiene(anyo, mes, dia); 
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}


				if (controladorPanelLaburpena.konprobatuLokala().equals("Restaurante")) {
					controladorPanelLaburpena.sakatuPanelJatetxeBotoia();
				} else if (controladorPanelLaburpena.konprobatuLokala().equals("Bar")) {
					controladorPanelLaburpena.sakatuPanelTabernaBotoia();
				} else {
					controladorPanelLaburpena.sakatuPanelKafetegiaBotoia();
				}

			}
		};
	}
}
