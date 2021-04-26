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
		return metodoakFuntzioakDeitu.dirutotala();
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
		usuarioa.sartuDatuak(izena, abizena, pasahitza, NAN, nif);
	}

	public Erabiltzaile sartuErabiltzailea(String erabiltzailea, String pasahitza) {
		return usuarioa.sartuErabiltzailea(erabiltzailea, pasahitza,usuarioa);
	}

	public void sartuTicket() throws ClassNotFoundException, SQLException {
		Ticket t1 = new Ticket(metodoak.jasoTransakzioZbk(), diruTotala(),konprobatuNIF());
		t1.sartuOperaciones();
	}

	public void sartuEskaera(String helbidea) throws ClassNotFoundException, SQLException {
		Eskaera es1 = new Eskaera(metodoak.jasoTransakzioZbk(), diruTotala(), konprobatuNIF(), helbidea);
		es1.sartuOperaciones();
		es1.sartuEskaera();
	}

	public void sartuFaktura(String izena, String abizena) throws ClassNotFoundException, SQLException {
		Faktura f1 = new Faktura(metodoak.jasoTransakzioZbk(), diruTotala(), konprobatuNIF(), izena, abizena);
		f1.sartuOperaciones();
		f1.sartuFaktura();
	} 

	public void sartuHornikuntza(String produktua, String nif, int kantitatea) throws ClassNotFoundException, SQLException { 
		Hornikuntza h1 = new Hornikuntza(metodoak.jasoTransakzioZbk(), diruTotala(), produktua, nif, kantitatea);
		h1.sartuOperaciones();
		h1.sartuHornikuntza();
	}

	public void sartuTiene()  {
		try {
			metodoakTiene.sartuTiene(karroa, jasoTransakzioZbk(), usuarioa.getErabiltzailea()); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void sartuKomanda() throws ClassNotFoundException, SQLException  {
		Komanda k1 = new Komanda(0, 0, null); 
		k1.setNIF(konprobatuNIF());
		k1.setTotala(diruTotala());
		k1.sartuKomanda();
	} 

	public void incluye(int platerKodea, int kantitatea) throws ClassNotFoundException, SQLException{
		metodoakIncluye.incluye(platerKodea, kantitatea, diruTotala(), konprobatuNIF());
	}

	public Komanda hasieratuOperaciones() throws ClassNotFoundException, SQLException {
		Komanda k1 = new Komanda(metodoak.jasoTransakzioZbk(), 0, null);
		k1.hasieratuOperaciones();
		return k1;
	}

	public void ofrece() {
		metodoakOfrece.localOfrece(konprobatuNIF());
	}

	// ______________________________________________________________________________________________________________________________________________________________________________________________________	
	// ______________________________________________________________________________________________________________________________________________________________________________________________________

	public void ezabatuKomanda() throws ClassNotFoundException, SQLException {
		Komanda k1 = hasieratuOperaciones();
		k1.ezabatuKomanda();
	}
}