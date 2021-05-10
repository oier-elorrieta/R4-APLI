package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 
import java.sql.SQLException;
import java.util.ArrayList; 

public class metodoakFitxategiak {

	public static void sartuDatuakFitxategian(ArrayList<String> azkenEmaitza) throws IOException, ClassNotFoundException, SQLException {
		System.out.println(azkenEmaitza.toString());
		FileWriter fitxategia = null;
		PrintWriter pw = null;
		String prodA = null, prodB = null;
		int luzeera, pos; 
		String produktuakProb;
		for(int i = 0; i < azkenEmaitza.size();i++) { 
			produktuakProb = azkenEmaitza.get(i);
			pos = produktuakProb.indexOf("/"); 
			luzeera = produktuakProb.length();
			prodA = produktuakProb.substring(0, pos); 
			prodB = produktuakProb.substring(pos+1, luzeera); 
			try {  
				if (begiratuHutsikDagoen(azkenEmaitza) == false) { 
					System.out.println("mod");
					fitxategia = new FileWriter ("fitxategiak/probabilitatea",true);
					System.out.println(prodA);
				}else { 
					System.out.println("no");
					fitxategia = new FileWriter ("fitxategiak/probabilitatea");
				}
				pw= new PrintWriter (fitxategia);
				pw.println(prodA+" "+prodB);
				fitxategia.close();
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}
	}

	public static boolean begiratuHutsikDagoen(ArrayList<String> azkenEmaitza) throws ClassNotFoundException, SQLException { 
		boolean hutsik = true; 
		File fitxategia = new File("fitxategiak/probabilitatea");
		FileReader fr= null;
		BufferedReader br = null; 
		int kont = 0;
		try {
			fr = new FileReader (fitxategia);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		 
		try {
			while ((br.readLine())!=null){
				kont++;
			} 
		} catch (IOException e) { 
			e.printStackTrace();
		} 
		if (kont != azkenEmaitza.size()) {
			hutsik = false;
		}  
		return hutsik;
	}

	public static void sartuDatuakFitxategianLokala(ArrayList<String> azkenEmaitza, String nif) throws ClassNotFoundException, SQLException {
		String izena = ModeloBBDD.metodoakKonprobaketak.konprobatuLokalarenIzena(nif);
		FileWriter fitxategia = null;
		PrintWriter pw = null;
		String prodA = null, prodB = null;
		int luzeera, pos; 
		String produktuakProb = null;
		for(int i = 0; i < azkenEmaitza.size();i++) {
			produktuakProb = azkenEmaitza.get(i);
			pos = produktuakProb.indexOf("/"); 
			luzeera = produktuakProb.length();
			prodA = produktuakProb.substring(0, pos);
			prodB = produktuakProb.substring(pos+1, luzeera); 
			try { 
				if (begiratuHutsikDagoen(azkenEmaitza) == false) {
					System.err.println("jtryj");
					fitxategia = new FileWriter ("fitxategiak/probabilitatea"+izena+"",true);
				}else {
					System.err.println("asfeas");
					fitxategia = new FileWriter ("fitxategiak/probabilitatea"+izena+"");
				}
				pw= new PrintWriter (fitxategia);
				pw.println(prodA+" "+prodB);
				fitxategia.close();
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}

	} 
}