package Modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 
import java.sql.SQLException;
import java.util.ArrayList; 

public class metodoakFitxategiak {

	public static void sartuDatuakFitxategian(ArrayList<String> azkenEmaitza, String nif, int zenbaki) throws IOException, ClassNotFoundException, SQLException {
		String izena = "";
		if(nif != null)
			izena = ModeloBBDD.metodoakKonprobaketak.konprobatuLokalarenIzena(nif);
		FileWriter fitxategia = null;
		PrintWriter pw = null; 
		String fitxeroEmaitzak = "1--> " +azkenEmaitza.get(0);
		String top = "TOP " + zenbaki +"\n";
		for(int i = 1; i < azkenEmaitza.size();i++) { 
			fitxeroEmaitzak = fitxeroEmaitzak +"\n"+ (i+1)+"--> " +azkenEmaitza.get(i);
		}
		try { 
			fitxategia = new FileWriter ("fitxategiak/probabilitatea"+izena+"");
			pw = new PrintWriter (fitxategia);
			pw.println(top + fitxeroEmaitzak);
			fitxategia.close();
		} catch (IOException e) { 
			e.printStackTrace();

		}
	}
}