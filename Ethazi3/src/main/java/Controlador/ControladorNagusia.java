package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import Modelo.Karritoa;
import Modelo.Modelo; 

public interface ControladorNagusia { 	
	
	public static void sakatuFakturaPanelaIkustekoBotoia(Controlador controlador) {
		controlador.nabegatzenPanelFaktura();
	}

	public static void sakatuTicketPanelaIkustekoBotoia(Controlador controlador) {
		controlador.nabegatzenPanelTicket();
	}

	public static void sakatuHasieraBotoia(Controlador controlador) {
		controlador.nabegatzenPanelLogin();
	}

	public static void sakatuHornikuntzaBotoia(Controlador controlador) {
		controlador.nabegatzenPanelHornikuntza();
	}
	
	public static void sakatuKomandaPanelaIkustekoBotoia(Controlador controlador) {
		controlador.nabegatzenPanelKomanda();
	}
	
	public static void sakatuEskaeraPanelaIkustekoBotoia(Controlador controlador) {
		controlador.nabegatzenPanelPedidos();
	}

	public static void sakatuAtzeraBotoia(Controlador controlador) {
		controlador.itxi();
	}
	
	
	public static void sakatuAtzeraBotoia(Controlador controlador, Modelo modelo) {
		controlador.nabegatzenPanelLogin();
		modelo.ezabatuProduktuenArraya();
	}

	public static String[] ComboBoxaSakatu(Modelo modelo) {
		return modelo.produktuakJaso();
	}

	public static ArrayList<Karritoa> sartu(String elikagaia,int kopuru, Modelo modelo) {
		return modelo.sartu(elikagaia, kopuru); 
	}  

	public static ImageIcon argazkiaAukeratu(String aukera, Modelo modelo) {
		return modelo.argazkiaAukeratu(aukera);
	}
	
	public static int jasoTransakzioZbk(Modelo modelo) throws ClassNotFoundException, SQLException {
		return modelo.jasoTransakzioZbk();
	}

	public static void sakatuPanelTabernaBotoia(Controlador controlador, Modelo modelo) {
		controlador.nabegatzenPanelTaberna();
		modelo.ezabatuProduktuenArraya();
	}

	public static void sakatuPanelKafetegiaBotoia(Controlador controlador, Modelo modelo) {
		controlador.nabegatzenPanelKafetegia();
		modelo.ezabatuProduktuenArraya();
	}

	public static void sakatuPanelJatetxeBotoia(Controlador controlador,Modelo modelo) {
		controlador.nabegatzenPanelJatetxea();
		modelo.ezabatuProduktuenArraya();
	}

	public static String konprobatuLokala(Modelo modelo) {
		return modelo.konprobatuLokala();
	}
	
	public static String konprobatuLokalarenIzena(Modelo modelo) {
		return modelo.konprobatuLokalarenIzena();
	}
	
	public static String konprobatuNIF(Modelo modelo) {
		return modelo.konprobatuNIF();
	} 

	public static int begiratuStock(String produktua, String nif,Modelo modelo) {
		return modelo.begiratuStock(produktua, nif);
	}
	
	public static void sartuTiene(Modelo modelo) {
		modelo.sartuTiene();
	}
}