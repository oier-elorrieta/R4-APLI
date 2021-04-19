package Controlador;
 
import Modelo.Modelo;
import Vista.PanelMenuKafetegia;
import Vista.Vista;

public class ControladorPanelMenuKafetegia {

	private Vista vista;
	private Controlador controlador;
	private PanelMenuKafetegia panelMenuKafetegia;
	private Modelo modelo;

	public ControladorPanelMenuKafetegia(Vista vista, Controlador controlador, Modelo modelo) {
		this.vista = vista;
		this.controlador = controlador;	
		this.modelo = modelo;
	}

	public void ikusipanelMenuKafetegia() {
		this.panelMenuKafetegia = new PanelMenuKafetegia(this);
		this.vista.ikusiPanela(this.panelMenuKafetegia);
	}

	public void sakatuFakturaPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelFaktura();
	}
	
	public void sakatuTicketPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelTicket();
	}
	
	public void sakatuEskaeraPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelPedidos();
	}
	
	public void sakatuHasieraBotoia() {
		this.controlador.nabegatzenPanelLogin();
	}
	
	public void sakatuHornikuntzaBotoia() {
		this.controlador.nabegatzenPanelHornikuntza();
	}
	
	public void sakatuAtzeraBotoia() {
		this.controlador.itxi();
	}

	public String[] top5produktuak() {
		return this.modelo.top5produktuak();
	}

	public double egunerokoIrabazia() {
		return this.modelo.egunerokoIrabazia();
	}

	public double asterokoIrabazia() {
		return this.modelo.asterokoIrabazia();
	}
}