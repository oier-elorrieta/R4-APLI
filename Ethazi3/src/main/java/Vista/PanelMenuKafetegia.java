package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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
	private JMenu menuOperatibitatea;
	private JMenu menuTop5;
	private JMenuItem menuItemSarratu;
	private JMenuItem menuItemDeslogeatu;
	private String[] top5produktuak;
	private JMenuItem produktuak;
	private JMenu egunero;
	private JMenu astero;
	private JMenuItem eguneroDirua;
	private JMenuItem asteroDirua;

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

		menuOperatibitatea = new JMenu("Operatibitatea");
		menuBar.add(menuOperatibitatea);

		egunero = new JMenu("Egunean");
		menuOperatibitatea.add(egunero);

		astero = new JMenu("Astean");
		menuOperatibitatea.add(astero);

		asteroDirua = new JMenuItem(String.valueOf(controladorPanelMenuKafetegia.asterokoIrabazia()));
		astero.add(asteroDirua);

		eguneroDirua = new JMenuItem(String.valueOf(controladorPanelMenuKafetegia.egunerokoIrabazia()));
		egunero.add(eguneroDirua);

		menuTop5 = new JMenu("Top5 Salmentak");
		menuBar.add(menuTop5);

		top5produktuak = controladorPanelMenuKafetegia.top5produktuak();
		for (int i = 0; i < top5produktuak.length; i++) {
			if (top5produktuak[i] != null) {
				produktuak = new JMenuItem();
				produktuak.setText(top5produktuak[i]);
				menuTop5.add(produktuak);
			}
		}

		menuItemDeslogeatu = new JMenuItem("           DESLOGEATU");
		menuItemDeslogeatu.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		menuItemDeslogeatu.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(menuItemDeslogeatu);

		menuItemSarratu = new JMenuItem("X");
		menuItemSarratu.setHorizontalAlignment(SwingConstants.RIGHT);
		menuItemSarratu.setForeground(Color.RED);
		menuBar.add(menuItemSarratu);

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
				controladorPanelMenuKafetegia.sakatuTicketPanelaIkustekoBotoia();
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
				controladorPanelMenuKafetegia.sakatuAtzeraBotoia();
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
}
