package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants; 

import Controlador.ControladorPanelMenuTaberna;

@SuppressWarnings("serial")
public class PanelMenuTaberna extends JPanel {

	private ControladorPanelMenuTaberna controladorPanelMenuTaberna;

	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnHornikuntza;
	private JMenuBar menuBar;
	private JMenuItem menuItemSarratu;
	private JMenuItem menuItemDeslogeatu;
	private JMenuItem mntmXprobababilitatea;

	// *****************************************************************************************************************************************************************************************************

	public PanelMenuTaberna(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {

		this.controladorPanelMenuTaberna = controladorPanelMenuTaberna;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		btnTicket = new JButton("TICKET");
		btnTicket.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTicket.setBounds(10, 52, 210, 113);
		add(btnTicket);

		btnFaktura = new JButton("FAKTURA");
		btnFaktura.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnFaktura.setBounds(230, 52, 210, 113);
		add(btnFaktura);

		btnHornikuntza = new JButton("+");
		btnHornikuntza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHornikuntza.setBounds(125, 176, 210, 113);
		add(btnHornikuntza);

		menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 475, 25);
		add(menuBar);

		menuItemDeslogeatu = new JMenuItem("DESLOGEATU");
		menuItemDeslogeatu.setHorizontalAlignment(SwingConstants.CENTER);
		menuItemDeslogeatu.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		menuBar.add(menuItemDeslogeatu);

		menuItemSarratu = new JMenuItem("X       ");
		menuItemSarratu.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItemSarratu.setForeground(Color.RED);
		menuBar.add(menuItemSarratu);

		mntmXprobababilitatea = new JMenuItem("Probababilitatea");
		mntmXprobababilitatea.setHorizontalAlignment(SwingConstants.RIGHT);
		mntmXprobababilitatea.setForeground(Color.RED);
		menuBar.add(mntmXprobababilitatea);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnFaktura.addActionListener(listenerFakturaBotoia(this.controladorPanelMenuTaberna));
		this.btnTicket.addActionListener(listenerTicketBotoia(this.controladorPanelMenuTaberna));
		this.menuItemSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelMenuTaberna));
		this.menuItemDeslogeatu.addActionListener(listenerHasieraBotoia(this.controladorPanelMenuTaberna));
		this.btnHornikuntza.addActionListener(listenerHornikuntzaBotoia(this.controladorPanelMenuTaberna));
		this.mntmXprobababilitatea.addActionListener(listenerProbabilitateBotoia(this.controladorPanelMenuTaberna));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerFakturaBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuFakturaPanelaIkustekoBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerTicketBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuTicketPanelaIkustekoBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuItxiBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerHornikuntzaBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuHornikuntzaBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerHasieraBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuTaberna.sakatuHasieraBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerProbabilitateBotoia(ControladorPanelMenuTaberna controladorPanelMenuTaberna) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					controladorPanelMenuTaberna.sartuDatuakFitxategianLokalean(4);
				} catch (ClassNotFoundException | IOException | SQLException e) {
					e.printStackTrace();
				}

			}
		};
	}
}
