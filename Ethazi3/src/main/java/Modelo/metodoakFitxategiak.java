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

	public static void sartuDatuakFitxategian(int zenbaki, Produktua produktuak[]) throws IOException, ClassNotFoundException, SQLException {
		ArrayList<String> produktuEmaitzak = metodoakProbabilitatea.Probabilitatea(zenbaki, produktuak);
		System.out.println(produktuEmaitzak.toString());
		FileWriter fitxategia = null;
		PrintWriter pw = null;
		String prodA = null, prodB = null;
		int luzeera, pos; 
		String produktuakProb;
		for(int i = 0; i < produktuEmaitzak.size();i++) { 
			produktuakProb = produktuEmaitzak.get(i);
			pos = produktuakProb.indexOf("/"); 
			luzeera = produktuakProb.length();
			
			prodA = produktuakProb.substring(0, pos); 
			prodB = produktuakProb.substring(pos+1, luzeera); 
			try {  
				if (begiratuHutsikDagoen(zenbaki, produktuak) == false) { 
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

	public static boolean begiratuHutsikDagoen(int zenbaki, Produktua produktuak[]) throws ClassNotFoundException, SQLException {
		ArrayList<String> produktuEmaitzak = metodoakProbabilitatea.Probabilitatea(zenbaki, produktuak);
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
		if (kont != produktuEmaitzak.size()) {
			hutsik = false;
		}  
		return hutsik;
	}

	public static void sartuDatuakFitxategianLokala(int zenbaki, Produktua produktuak[], String nif) throws ClassNotFoundException, SQLException {
		ArrayList<String> produktuEmaitzak = metodoakProbabilitatea.ProbabilitateaLokala(zenbaki, produktuak, nif);
		String izena = ModeloBBDD.metodoakKonprobaketak.konprobatuLokalarenIzena(nif);
		FileWriter fitxategia = null;
		PrintWriter pw = null;
		String prodA = null, prodB = null;
		int luzeera, pos; 
		String produktuakProb;
		for(int i = 0; i < produktuEmaitzak.size();i++) {
			produktuakProb = produktuEmaitzak.get(i).toString();
			pos = produktuakProb.indexOf("/"); 
			luzeera = produktuakProb.length();
			prodA = produktuakProb.substring(0, pos);
			prodB = produktuakProb.substring(pos+1, luzeera); 
			try { 
				if (begiratuHutsikDagoen(zenbaki, produktuak) == false) {
					fitxategia = new FileWriter ("fitxategiak/probabilitatea"+izena+"",true);
				}else {
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