package Controlador;

import java.sql.SQLException;
import javax.swing.ImageIcon;
import Modelo.Modelo;
import Modelo.metodoak;
import Vista.PanelKomanda;
import Vista.Vista;

public class ControladorPanelKomanda extends ControladorNagusia{

	private Vista vista;
	private Modelo modelo;
	@SuppressWarnings("unused")
	private Controlador controlador;
	private PanelKomanda panelKomanda;

	public ControladorPanelKomanda(Controlador controlador, Modelo modelo, Vista vista) {
		super(controlador, modelo, vista);
		this.vista = vista; 
		this.modelo = modelo;
		this.controlador = controlador;
	}

	public void ikusiPanelKomanda() {
		this.panelKomanda = new PanelKomanda(this);
		this.vista.ikusiPanela(this.panelKomanda);
	}

	public ImageIcon argazkiaPlaterraAukeratu(String aukera) {
		return metodoak.argazkiaAukeratu(aukera);
	}

	public String[] platerrakJaso() {
		return this.modelo.platerrakJaso();
	}

	public String[] platerMotak() {
		return this.modelo.platerMotak();
	}

	public String[] platerMota(String platerMota, String tipoa) {
		return this.modelo.platerMota(platerMota, tipoa);
	}

	public int platerKodea(String platerra){
		return this.modelo.platerKodea(platerra);
	}

	public void sartuKomanda() throws ClassNotFoundException, SQLException{
		this.modelo.sartuKomanda();
	} 

	public void incluye(int platerKodea, int kantitatea) throws ClassNotFoundException, SQLException {
		this.modelo.incluye(platerKodea, kantitatea);
	}

	public void hasieratuOperaciones() throws ClassNotFoundException, SQLException {
		modelo.hasieratuOperaciones();
	}

	public String[] platerMotaArabera(String platerMota) {
		return this.modelo.platerMotaArabera(platerMota);
	}

	public void ezabatuKomanda() throws ClassNotFoundException, SQLException {
		this.modelo.ezabatuKomanda();
	}

	public void ofrece() {
		this.modelo.ofrece();
	}
}