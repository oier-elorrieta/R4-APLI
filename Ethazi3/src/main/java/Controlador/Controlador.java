package Controlador;

import Modelo.Modelo;
import Vista.Vista;

public class Controlador {

	private Modelo modelo;

	private Vista vista;

	private ControladorPanelHasiera controladorPanelHasiera;
	private ControladorPanelLogin controladorPanelLogin;
	private ControladorPanelErregistratu controladorPanelErregistratu; 
	private ControladorPanelMenuJatetxea controladorPanelJatetxea;	
	private ControladorPanelMenuTaberna controladorPanelTaberna;	
	private ControladorPanelMenuKafetegia controladorPanelKafetegia;
	private ControladorPanelHornikuntza controladorPanelHornikuntza;
	private ControladorPanelFaktura controladorPanelFaktura;
	private ControladorPanelTicket controladorPanelTicket;
	private ControladorPanelEskaera controladorPanelPedidos; 
	private ControladorPanelKomanda controladorPanelKomanda;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.controladorPanelHasiera = new ControladorPanelHasiera(this.vista, this);
		this.controladorPanelLogin = new ControladorPanelLogin(this.vista, this, this.modelo);
		this.controladorPanelErregistratu = new ControladorPanelErregistratu(this.vista, this, this.modelo);
		this.controladorPanelJatetxea = new ControladorPanelMenuJatetxea(this.vista, this);
		this.controladorPanelTaberna = new ControladorPanelMenuTaberna(this.vista, this);
		this.controladorPanelKafetegia = new ControladorPanelMenuKafetegia(this.vista, this);
		this.controladorPanelFaktura = new ControladorPanelFaktura(this.modelo, this.vista, this);
		this.controladorPanelHornikuntza = new ControladorPanelHornikuntza(this.vista, this, this.modelo);
		this.controladorPanelTicket = new ControladorPanelTicket(this.modelo, this.vista, this);
		this.controladorPanelPedidos = new ControladorPanelEskaera(this.modelo, this.vista, this); 
		this.controladorPanelKomanda = new ControladorPanelKomanda(this.modelo, this.vista, this);
		this.nabegatzenPanelHasiera();
	}

	public void nabegatzenPanelHasiera() {
		this.controladorPanelHasiera.ikusiPanelHasiera();
	}

	public void nabegatzenPanelLogin() {
		this.controladorPanelLogin.ikusiPanelLogin();
	}

	public void nabegatzenPanelErregistratu() {
		this.controladorPanelErregistratu.ikusiPanelErregistratu();
	}

	public void nabegatzenPanelJatetxea() {
		this.controladorPanelJatetxea.ikusipanelMenuJatetxea();
	}

	public void nabegatzenPanelTaberna() {
		this.controladorPanelTaberna.ikusipanelMenuTaberna();
	}

	public void nabegatzenPanelKafetegia() {
		this.controladorPanelKafetegia.ikusipanelMenuKafetegia();
	}

	public void nabegatzenPanelFaktura() { 
		this.controladorPanelFaktura.ikusiPanelFaktura();
	}

	public void nabegatzenPanelHornikuntza() { 
		this.controladorPanelHornikuntza.ikusiPanelHornikuntza();
	}

	public void nabegatzenPanelTicket() { 
		this.controladorPanelTicket.ikusiPanelTicket();
	}

	public void nabegatzenPanelPedidos() {
		this.controladorPanelPedidos.ikusiPanelPedidos();
	}

	public void nabegatzenPanelKomanda() {
		this.controladorPanelKomanda.ikusiPanelKomanda();
	}

	public void itxi() {
		System.exit(0);
	}
}