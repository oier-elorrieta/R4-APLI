package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Modelo {

	private ArrayList<Karritoa> karroa = new ArrayList<Karritoa>();

	private Erabiltzaile usuarioa = new Erabiltzaile(null, null);													

	// *****************************************************************************************************************************************************************

	public boolean konprobatuErabiltzaileAtributuenLuzeera(String nan, String izena, String abizena, String pasahitza, String nif) {
		return metodoakKonprobaketak.konprobatuErabiltzaileAtributuenLuzeera(nan, izena, abizena, pasahitza, nif);
	}

	public String[] produktuakJaso() {
		return metodoak.sartuSalgaiak();
	}

	public ArrayList<Karritoa> sartu(String elikagaia, int kopuru) {
		return metodoak.sartuProduktuaArrayan(elikagaia, kopuru, karroa);
	}

	public String pantailaratuIzena() {
		return metodoak.pantailatuProduktuaIzena(karroa);
	}
	
	public String pantailaratuKopurua() {
		return metodoak.pantailatuProduktuaKopurua(karroa);
	}
	
	public String pantailaratuPrezioa() {
		return metodoak.pantailatuProduktuaPrezioa(karroa);
	}

	public double diruTotala() {
		return metodoak.diruTotala(karroa);
	}

	public ArrayList<Karritoa> ezabatuProduktuenArraya() {
		return metodoak.ezabatuArraya(karroa);
	}

	public ImageIcon argazkiaAukeratu(String aukera) {
		return metodoak.argazkiaAukeratu(aukera);
	}

	// *****************************************************************************************************************************************************************

	public String konprobatuErabiltzailea(String erabiltzailea, String pasahitza) {
		return metodoakKonprobaketak.konprobatuErabiltzailea(erabiltzailea, pasahitza);
	}

	public String konprobatuNIF () {
		return metodoakKonprobaketak.konprobatuNIF(usuarioa.getErabiltzailea());
	}

	public String konprobatuLokala() {
		return metodoakKonprobaketak.konprobatuLokala(usuarioa.getErabiltzailea());
	}

	public String konprobatuLokalarenIzena() {
		return metodoakKonprobaketak.konprobatuLokalarenIzena(konprobatuNIF());
	}

	public boolean begiratuNAN(String nan) {
		return metodoakKonprobaketak.begiratuNAN(nan);
	}

	public boolean begiratuNIF(String nif) {
		return metodoakKonprobaketak.begiratuNIF(nif);
	}

	public int begiratuStock(String produktua,String nif) {
		return metodoakKonprobaketak.begiratuStock(produktua, nif);
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public String[] platerrakJaso() {
		return metodoak.sartuPlaterrak();
	}

	public String[] platerMotak(){
		return metodoakPlaterZerrendak.platerMotak();
	}

	public String[] platerMota(String platerMota, String tipoa){
		return metodoakPlaterZerrendak.platerMota(platerMota, tipoa);
	}

	public int platerKodea(String platerra){
		return metodoakPlaterZerrendak.jasoPlaterKodea(platerra);
	}

	public String[] platerMotaArabera(String platerMota) {
		return metodoakPlaterZerrendak.platerMotaArabera(platerMota);
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public int jasoTransakzioZbk() throws ClassNotFoundException, SQLException {
		return metodoak.jasoTransakzioZbk();
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public void sartuDatuak(String izena, String abizena, String pasahitza, String NAN, String nif) {
		metodoakErabiltzaile.sartuDatuak(izena, abizena, pasahitza, NAN, nif);
	}

	public Erabiltzaile sartuErabiltzailea(String erabiltzailea, String pasahitza) {
		return metodoakErabiltzaile.sartuErabiltzailea(erabiltzailea, pasahitza,usuarioa);
	}

	public void sartuTicket(int anyo, int mes, int dia) throws ClassNotFoundException, SQLException {
		metodoakTicket.sartuTicket(konprobatuNIF(), diruTotala(), metodoak.jasoTransakzioZbk(), anyo, mes , dia);
	}

	public void sartuEskaera(String helbidea, int anyo, int mes, int dia) throws ClassNotFoundException, SQLException {
		metodoakEskaera.sartuEskaera(konprobatuNIF(), diruTotala(), helbidea, metodoak.jasoTransakzioZbk(), anyo, mes , dia);
	}

	public void sartuFaktura(String izena, String abizena, int anyo, int mes, int dia) throws ClassNotFoundException, SQLException {
		metodoakFaktura.sartuFaktura(konprobatuNIF(), izena, abizena, diruTotala(), metodoak.jasoTransakzioZbk(), anyo, mes , dia);
	} 

	public void sartuHornikuntza(String produktua,int anyo, int mes, int dia, String nif, int kantitatea) throws ClassNotFoundException, SQLException {
		metodoakHornikuntza.sartuHornikuntza(produktua, anyo, mes, dia, nif, kantitatea);
	}

	public void sartuTiene(int anyo, int mes, int dia)  {
		try {
			metodoakTiene.sartuTiene(karroa, jasoTransakzioZbk(), usuarioa.getErabiltzailea(), anyo, mes, dia); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void sartuKomanda(int anyo, int mes, int dia) throws ClassNotFoundException, SQLException  {
		metodoakKomanda.sartuKomanda(diruTotala(),konprobatuNIF(), anyo, mes, dia);
	} 

	public void incluye(int platerKodea, int kantitatea) throws ClassNotFoundException, SQLException{
		metodoakIncluye.incluye(platerKodea, kantitatea, diruTotala(), konprobatuNIF());
	}

	public void hasieratuOperaciones() throws ClassNotFoundException, SQLException   {
		metodoakKomanda.hasieratuOperaciones();
	}

	public void ofrece() {
		metodoakOfrece.localOfrece(konprobatuNIF());
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public void ezabatuKomanda() throws ClassNotFoundException, SQLException {
		metodoakKomanda.ezabatuKomanda();
	}

	public String[] top5produktuak(){
		return metodoakMenuBar.top5produktuak(usuarioa.getErabiltzailea());
	}

	public double egunerokoIrabazia() {
		return metodoakMenuBar.egunerokoIrabazia(usuarioa.getErabiltzailea());
	}

	public double asterokoIrabazia() {
		return metodoakMenuBar.asterokoIrabazia(usuarioa.getErabiltzailea());
	}
}