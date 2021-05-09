package Controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import Modelo.Karritoa;
import Modelo.Modelo; 
import Vista.Vista; ; 

public abstract class ControladorNagusia { 	

	protected Controlador controlador;
	protected Modelo modelo;
	protected Vista vista;

	public ControladorNagusia(Controlador controlador, Modelo modelo, Vista vista) {
		this.controlador = controlador;
		this.modelo = modelo;
		this.vista = vista;
	}

	public void sakatuPanelLogin() {
		this.controlador.nabegatzenPanelLogin();
	}

	public void sakatuFakturaPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelFaktura();
	}

	public void sakatuTicketPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelTicket();
	}

	public void hasieraraBotoia() {
		this.controlador.nabegatzenPanelHasiera();
	}

	public void sakatuHasieraBotoia() {
		this.controlador.nabegatzenPanelLogin();
	}

	public void sakatuHornikuntzaBotoia() {
		this.controlador.nabegatzenPanelHornikuntza();
	}

	public void sakatuKomandaPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelKomanda();
	}

	public void sakatuEskaeraPanelaIkustekoBotoia() {
		this.controlador.nabegatzenPanelPedidos();
	}

	public void sakatuItxiBotoia() {
		this.controlador.itxi();
	}

	public void sakatuAtzeraBotoia() {
		this.controlador.nabegatzenPanelLogin();
		this.modelo.ezabatuProduktuenArraya();
	}

	public String[] ComboBoxaSakatu() {
		return this.modelo.produktuakJaso();
	}

	public ArrayList<Karritoa> sartu(String elikagaia,int kopuru) {
		return this.modelo.sartu(elikagaia, kopuru); 
	}  

	public ImageIcon argazkiaAukeratu(String aukera ) {
		return this.modelo.argazkiaAukeratu(aukera);
	}

	public int jasoTransakzioZbk() throws ClassNotFoundException, SQLException {
		return this.modelo.jasoTransakzioZbk();
	}

	public void sakatuPanelTabernaBotoia() {
		this.controlador.nabegatzenPanelTaberna();
		this.modelo.ezabatuProduktuenArraya();
	}

	public void sakatuPanelKafetegiaBotoia() {
		this.controlador.nabegatzenPanelKafetegia();
		this.modelo.ezabatuProduktuenArraya();
	}

	public void sakatuPanelJatetxeBotoia() {
		this.controlador.nabegatzenPanelJatetxea();
		this.modelo.ezabatuProduktuenArraya();
	}

	public String konprobatuLokala() {
		return this.modelo.konprobatuLokala();
	}

	public String konprobatuLokalarenIzena() {
		return this.modelo.konprobatuLokalarenIzena();
	}

	public String konprobatuNIF() {
		return this.modelo.konprobatuNIF();
	} 

	public int begiratuStock(String produktua, String nif) {
		return this.modelo.begiratuStock(produktua, nif);
	}

	public void sartuTiene() {
		this.modelo.sartuTiene();
	}

	public ArrayList<String> probabilitatealocala(int zenbaki) throws ClassNotFoundException, SQLException {
		return modelo.Probabilitatealocal(zenbaki);
	}

	public ArrayList<String> probabilitatea(int zenbaki) throws ClassNotFoundException, SQLException{
		return modelo.Probabilitatea(zenbaki);
	}

	public void sartuDatuakFitxategianLokalean(int zenbaki) throws ClassNotFoundException, IOException, SQLException { 
		this.modelo.sartuDatuakFitxategianLokalean(zenbaki);
	}
}