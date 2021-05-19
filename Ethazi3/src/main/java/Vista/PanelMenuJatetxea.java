package Vista;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ControladorPanelMenuJatetxea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class PanelMenuJatetxea extends JPanel {

	private ControladorPanelMenuJatetxea controladorPanelJatetxea;

	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnEskaera;
	private JButton btnKomanda;
	private JButton btnHornikuntza;
	private JMenuBar menuBar;
	private JMenuItem menuItemSarratu;
	private JMenuItem menuItemDeslogeatu;
	private JMenuItem mntmXprobababilitatea;


	// *****************************************************************************************************************************************************************************************************

	public PanelMenuJatetxea(ControladorPanelMenuJatetxea controladorPanelJatetxea) {

		this.controladorPanelJatetxea = controladorPanelJatetxea;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		btnTicket = new JButton("TICKET");
		btnTicket.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTicket.setBounds(10, 39, 185, 122);
		add(btnTicket);

		btnFaktura = new JButton("FAKTURA");
		btnFaktura.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnFaktura.setBounds(255, 39, 185, 122);
		add(btnFaktura);

		btnEskaera = new JButton("ESKAERA");
		btnEskaera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnEskaera.setBounds(10, 167, 185, 122);
		add(btnEskaera);

		btnKomanda = new JButton("KOMANDA");
		btnKomanda.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnKomanda.setBounds(255, 167, 185, 122);
		add(btnKomanda);

		btnHornikuntza = new JButton("+");
		btnHornikuntza.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHornikuntza.setBounds(205, 39, 41, 250);
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

		mntmXprobababilitatea = new JMenuItem("PROBABILITATEA");
		mntmXprobababilitatea.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		mntmXprobababilitatea.setHorizontalAlignment(SwingConstants.CENTER);
		mntmXprobababilitatea.setForeground(Color.BLACK);
		menuBar.add(mntmXprobababilitatea);

		initializeEvents();
	}

	// *****************************************************************************************************************************************************************************************************

	private void initializeEvents() {
		this.btnFaktura.addActionListener(listenerFakturaBotoia(this.controladorPanelJatetxea));
		this.btnTicket.addActionListener(listenerTicketBotoia(this.controladorPanelJatetxea));
		this.btnEskaera.addActionListener(listenerEskaeraBotoia(this.controladorPanelJatetxea));
		this.btnHornikuntza.addActionListener(listenerHornikuntzaBotoia(this.controladorPanelJatetxea));
		this.btnKomanda.addActionListener(listenerKomandaBotoia(this.controladorPanelJatetxea));
		this.menuItemSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelJatetxea));
		this.menuItemDeslogeatu.addActionListener(listenerHasieraBotoia(this.controladorPanelJatetxea));
		this.mntmXprobababilitatea.addActionListener(listenerProbabilitateBotoia(this.controladorPanelJatetxea));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerFakturaBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuFakturaPanelaIkustekoBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerTicketBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuTicketPanelaIkustekoBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerEskaeraBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuEskaeraPanelaIkustekoBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuItxiBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerHornikuntzaBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuHornikuntzaBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerHasieraBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuHasieraBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerKomandaBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelJatetxea.sakatuKomandaPanelaIkustekoBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerProbabilitateBotoia(ControladorPanelMenuJatetxea controladorPanelJatetxea) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorPanelJatetxea.probabilitatealocala(10);
				} catch (ClassNotFoundException | SQLException | IOException e) {
					e.printStackTrace();
				}
			}	
		};
	}
}