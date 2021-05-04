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
		this.controladorPanelHasiera = new ControladorPanelHasiera(this, this.modelo, this.vista);
		this.controladorPanelLogin = new ControladorPanelLogin(this, this.modelo, this.vista);
		this.controladorPanelErregistratu = new ControladorPanelErregistratu(this, this.modelo, this.vista);
		this.controladorPanelJatetxea = new ControladorPanelMenuJatetxea(this, this.modelo, this.vista);
		this.controladorPanelTaberna = new ControladorPanelMenuTaberna(this, this.modelo, this.vista);
		this.controladorPanelKafetegia = new ControladorPanelMenuKafetegia(this, this.modelo, this.vista);
		this.controladorPanelFaktura = new ControladorPanelFaktura(this, this.modelo, this.vista);
		this.controladorPanelHornikuntza = new ControladorPanelHornikuntza(this, this.vista, this.modelo);
		this.controladorPanelTicket = new ControladorPanelTicket(this, this.modelo, this.vista);
		this.controladorPanelPedidos = new ControladorPanelEskaera(this, this.modelo, this.vista); 
		this.controladorPanelKomanda = new ControladorPanelKomanda(this, this.modelo, this.vista);
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