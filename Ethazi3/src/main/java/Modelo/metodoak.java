package Modelo; 
import java.util.ArrayList;
import javax.swing.ImageIcon;  

public class metodoak {

	public static ArrayList<Karritoa> sartuProduktuaArrayan(String elikagaia, int kopuru, ArrayList<Karritoa> karroa) { 
		double dirua = sartuDirua(elikagaia, kopuru);
		Karritoa Prod = new Karritoa(elikagaia, kopuru, dirua);
		karroa.add(Prod); 
		return karroa;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String pantailatuProduktuaIzena(ArrayList<Karritoa> karroa) {
		String PantailatukoDena = "";
		for (int i = 0; i < karroa.size(); i++) {
			PantailatukoDena = PantailatukoDena + "<html>" + karroa.get(i).getElikagaia() + "<br><html>";
		}
		return PantailatukoDena;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String pantailatuProduktuaKopurua(ArrayList<Karritoa> karroa) {
		String PantailatukoDena = "";
		for (int i = 0; i < karroa.size(); i++) {
			PantailatukoDena = PantailatukoDena + "<html>" + "x"+karroa.get(i).getKopuru() + "<br><html>";
		}
		return PantailatukoDena;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String pantailatuProduktuaPrezioa(ArrayList<Karritoa> karroa) {
		String PantailatukoDena = "";
		for (int i = 0; i < karroa.size(); i++) {
			PantailatukoDena = PantailatukoDena + "<html>" + karroa.get(i).getBalioa()+"�" + "<br><html>";
		}
		return PantailatukoDena;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String[] sartuSalgaiak() {

		Produktua elikagaiak[] = metodoakPlaterrakEtaProduktuak.elikagaiak();

		String produktoIzena[] = new String[metodoakPlaterrakEtaProduktuak.produktuKantitatea()];
		for (int i = 0; i < produktoIzena.length; i++) {
			produktoIzena[i] = elikagaiak[i].getIzena();
		}
		return produktoIzena;
	}

	// *****************************************************************************************************************************************************************************************************

	public static String[] sartuPlaterrak() {

		Produktua platerrak[] = metodoakPlaterrakEtaProduktuak.platerrak();

		String platerIzena[] = new String[metodoakPlaterrakEtaProduktuak.platerKantitatea()];
		for (int i = 0; i < platerIzena.length; i++) {
			platerIzena[i] = platerrak[i].getIzena();
		}
		return platerIzena;
	}

	// *****************************************************************************************************************************************************************************************************

	public static double sartuDirua(String aukera, int kantitatea) {
		Produktua produktuak[] = metodoakPlaterrakEtaProduktuak.produktuGuztiak();
		double dirua = 0;
		for (int i = 0; i < produktuak.length; i++) {
			if (produktuak[i].getIzena().equalsIgnoreCase(aukera)) {
				dirua = kantitatea * produktuak[i].getSaltzekoPrezioa();
				break;
			}
		}
		return dirua;
	}

	// *****************************************************************************************************************************************************************************************************

	public static double jasoProduktuenPrezioa(String aukera, int kantitatea) {
		Produktua produktuak[] = metodoakPlaterrakEtaProduktuak.produktuGuztiak();
		double dirua = sartuDirua(aukera, kantitatea);
		for (int i = 0; i < produktuak.length; i++) {
			if (produktuak[i].getIzena().equalsIgnoreCase(aukera)) {
				dirua = kantitatea * produktuak[i].getErosPrezioa();
				break;
			}
		}
		return dirua;
	}

	// *****************************************************************************************************************************************************************************************************

	public static int gehituTransferentziaZenbakia(int zbk) {
		zbk++;
		return zbk;
	}

	// *****************************************************************************************************************************************************************************************************

	public static ArrayList<Karritoa> ezabatuArraya(ArrayList<Karritoa> karroa) {
		karroa.clear();
		return karroa;
	}

	// *****************************************************************************************************************************************************************************************************

	public static ImageIcon argazkiaAukeratu(String aukera) {
		return new ImageIcon("argazkiak/" + aukera + ".jpg");
	} 
}