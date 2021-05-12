package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controlador.ControladorPanelMenuJatetxea;
import Controlador.ControladorPanelMenuKafetegia;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelMenuKafetegia extends JPanel {

	private ControladorPanelMenuKafetegia controladorPanelMenuKafetegia;

	private JButton btnFaktura;
	private JButton btnTicket;
	private JButton btnEskaera;
	private JButton btnHornikuntza;
	private JMenuBar menuBar;
	private JMenuItem menuItemSarratu;
	private JMenuItem menuItemDeslogeatu;
	private JMenuItem mntmXprobababilitatea;

	// *****************************************************************************************************************************************************************************************************

	public PanelMenuKafetegia(ControladorPanelMenuKafetegia controladorPanelMenuKafetegia) {

		this.controladorPanelMenuKafetegia = controladorPanelMenuKafetegia;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(0, 0, 450, 300);

		btnTicket = new JButton("TICKET");
		btnTicket.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnTicket.setBounds(10, 40, 210, 120);
		add(btnTicket);

		btnFaktura = new JButton("FAKTURA");
		btnFaktura.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnFaktura.setBounds(230, 40, 210, 120);
		add(btnFaktura);

		btnEskaera = new JButton("ESKAERA");
		btnEskaera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnEskaera.setBounds(10, 171, 210, 118);
		add(btnEskaera);

		btnHornikuntza = new JButton("+");
		btnHornikuntza.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHornikuntza.setBounds(230, 169, 210, 120);
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
		this.btnFaktura.addActionListener(listenerFakturaBotoia(this.controladorPanelMenuKafetegia));
		this.btnTicket.addActionListener(listenerTicketBotoia(this.controladorPanelMenuKafetegia));
		this.btnEskaera.addActionListener(listenerEskaeraBotoia(this.controladorPanelMenuKafetegia));
		this.menuItemSarratu.addActionListener(listenerSarratuBotoia(this.controladorPanelMenuKafetegia));
		this.menuItemDeslogeatu.addActionListener(listenerHasieraBotoia(this.controladorPanelMenuKafetegia));
		this.btnHornikuntza.addActionListener(listenerHornikuntzaBotoia(this.controladorPanelMenuKafetegia));
		this.mntmXprobababilitatea.addActionListener(listenerProbabilitateBotoia(this.controladorPanelMenuKafetegia));
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerFakturaBotoia(ControladorPanelMenuKafetegia controladorPanelMenuKafetegia) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuKafetegia.sakatuFakturaPanelaIkustekoBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerTicketBotoia(ControladorPanelMenuKafetegia controladorPanelMenuKafetegia) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorPanelMenuKafetegia.sakatuTicketPanelaIkustekoBotoia();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerEskaeraBotoia(ControladorPanelMenuKafetegia controladorPanelMenuKafetegia) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuKafetegia.sakatuEskaeraPanelaIkustekoBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerSarratuBotoia(ControladorPanelMenuKafetegia controladorPanelMenuKafetegia) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuKafetegia.sakatuItxiBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerHornikuntzaBotoia(ControladorPanelMenuKafetegia controladorPanelMenuKafetegia) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuKafetegia.sakatuHornikuntzaBotoia();
			}
		};
	}

	// *****************************************************************************************************************************************************************************************************

	private ActionListener listenerHasieraBotoia(ControladorPanelMenuKafetegia controladorPanelMenuKafetegia) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelMenuKafetegia.sakatuHasieraBotoia();
			}
		};
	}
	
	// *****************************************************************************************************************************************************************************************************

			private ActionListener listenerProbabilitateBotoia(ControladorPanelMenuKafetegia controladorPanelMenuKafetegia) {
				return new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						/*try {
							controladorPanelMenuKafetegia.probabilitatea(3);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
					}
				};
			}
}
