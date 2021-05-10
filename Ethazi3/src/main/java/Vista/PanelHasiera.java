package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import Controlador.ControladorPanelHasiera;

@SuppressWarnings("serial")
public class PanelHasiera extends JPanel {

	private ControladorPanelHasiera controladorPanelHasiera;

	private JButton btnDatuBasePo;
	private JButton btnBigData;
	private JButton btnSarratu;
	private JTextField tf_1;
	private JTextField tf_2;

	// *****************************************************************************************************************************************************************************************************

	public PanelHasiera(ControladorPanelHasiera controladorPanelHasiera) {
		this.controladorPanelHasiera = controladorPanelHasiera;

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		// _______________________________________________________________________________________________________________________________________________________________________________

		btnDatuBasePo = new JButton("Datu basea populatu");
		btnDatuBasePo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDatuBasePo.setBounds(10, 77, 200, 150);
		add(btnDatuBasePo);

		btnBigData = new JButton("BIG DATA");
		btnBigData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBigData.setBounds(220, 77, 220, 150);
		add(btnBigData);

		btnSarratu = new JButton("SARRATU");
		btnSarratu.setBounds(351, 238, 89, 23);
		add(btnSarratu);

		// _______________________________________________________________________________________________________________________________________________________________________________

		tf_1 = new JTextField();
		tf_1.setBackground(Color.BLUE);
		tf_1.setBounds(10, 269, 430, 20);
		add(tf_1);
		tf_1.setColumns(10);

		tf_2 = new JTextField();
		tf_2.setHorizontalAlignment(SwingConstants.LEFT);
		tf_2.setForeground(Color.WHITE);
		tf_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		tf_2.setEditable(false);
		tf_2.setColumns(10);
		tf_2.setBackground(Color.BLUE);
		tf_2.setBounds(8, 11, 432, 20);
		add(tf_2);

		// _______________________________________________________________________________________________________________________________________________________________________________

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnDatuBasePo.addActionListener(listenerLehenengoBotoia(this.controladorPanelHasiera));
		this.btnSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelHasiera));
		this.btnBigData.addActionListener(listenerBigDataBotoia(this.controladorPanelHasiera));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerLehenengoBotoia(ControladorPanelHasiera controladorPanelHasiera) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelHasiera.sakatuPanelLogin();
			}
		};
	} 

	private ActionListener listenerSarratuBotoia(ControladorPanelHasiera controladorPanelHasiera) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelHasiera.sakatuItxiBotoia();
			}
		};
	} 

	private ActionListener listenerBigDataBotoia(ControladorPanelHasiera controladorPanelHasiera) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorPanelHasiera.probabilitatea(3); 
				} catch (ClassNotFoundException | IOException | SQLException e) {
					e.printStackTrace();
				}
			}
		};
	}
}
