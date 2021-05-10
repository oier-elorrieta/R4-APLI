package Modelo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class metodoakProbabilitatea {

	public static ArrayList<String> Probabilitatea(int zenbaki, Produktua produktuak[]) throws ClassNotFoundException, SQLException, IOException {
		ModeloBBDD.metodoaProbabilitatea.Fechasartu();
		String fecha =  ModeloBBDD.metodoaProbabilitatea.stringfecha();
		float taula[][] = new float[metodoakPlaterrakEtaProduktuak.produktuKantitatea()][metodoakPlaterrakEtaProduktuak.produktuKantitatea()];
		float emaitza = 0;
		for (int i = 0; i < produktuak.length; i++) {
			for (int j = 0; j < produktuak.length; j++) {
				if (i != j) {
					emaitza = ModeloBBDD.metodoakFuntzioakDeitu.funtzioProbabilitateOrokorra(produktuak[i].getIzena(), produktuak[j].getIzena());

					taula[i][j] = emaitza;
					ModeloBBDD.metodoaProbabilitatea.ProbGuztiasartu(produktuak[i].getIzena(),produktuak[j].getIzena(),emaitza, fecha);
				}
			}
		}

		for (int i = 0; i < taula.length; i++) {
			for (int j = 0; j < taula.length; j++) {

				System.out.print(taula[i][j]);
				System.out.print("  ");

			}
			System.out.println(" ");
		}

		ArrayList<Float> emaitzak = probabilitategehiena(taula);

		ArrayList<Float> azkenEmaitzak = new ArrayList<Float>();

		ArrayList<String> produktuEmaitzak = new ArrayList<String>();

		int z = 0;
		for (int i = emaitzak.size() - 1; z < zenbaki; i--) {
			azkenEmaitzak.add(emaitzak.get(i));
			z++;
		}

		for (int x = 0; x < azkenEmaitzak.size(); x++) {

			boolean  conseguido = false;

			for (int i = 0; i < taula.length && !conseguido; i++) {
				for (int j = 0; j < taula.length && !conseguido; j++) {
					if (azkenEmaitzak.get(x) == (taula[i][j]) && taula[i][j] != 0) {
						if (produktuEmaitzak.contains(produktuak[i].getIzena() + "/" + produktuak[j].getIzena()) == false && produktuEmaitzak.contains(produktuak[j].getIzena() + "/" + produktuak[i].getIzena()) == false) {
							produktuEmaitzak.add(produktuak[i].getIzena() + "/" + produktuak[j].getIzena());
							conseguido = true;
						}
					}
				}
			}
		}

		for (int i = 0; i < azkenEmaitzak.size(); i++) {
			System.out.println(azkenEmaitzak.get(i)+"egr");
		}

		for (int i = 0; i < produktuEmaitzak.size(); i++) {
			System.out.println(produktuEmaitzak.get(i)+"eg1");
		} 
		
		metodoakFitxategiak.sartuDatuakFitxategian(produktuEmaitzak, null);

		return produktuEmaitzak;
	}

	public static ArrayList<String> ProbabilitateaLokala(int zenbaki, Produktua produktuak[],String nif) throws ClassNotFoundException, SQLException, IOException {
		ModeloBBDD.metodoaProbabilitatea.Fechasartu();
		String fecha =  ModeloBBDD.metodoaProbabilitatea.stringfecha();
		float taula[][] = new float[metodoakPlaterrakEtaProduktuak.produktuKantitatea()][metodoakPlaterrakEtaProduktuak.produktuKantitatea()];
		float emaitza = 0;
		for (int i = 0; i < produktuak.length; i++) {
			for (int j = 0; j < produktuak.length; j++) {
				if (i != j) {

					emaitza = ModeloBBDD.metodoakFuntzioakDeitu.funtzioProbabilitateLokala(produktuak[i].getIzena(), produktuak[j].getIzena(),nif);

					taula[i][j] = emaitza;
					ModeloBBDD.metodoaProbabilitatea.ProbLocalasartu(produktuak[i].getIzena(),produktuak[j].getIzena(),emaitza, nif, fecha);
				}
			}
		}
		for (int i = 0; i < taula.length; i++) {
			for (int j = 0; j < taula.length; j++) {

				System.out.print(taula[i][j]);
				System.out.print("  ");

			}
			System.out.println(" ");
		}

		ArrayList<Float> emaitzak = probabilitategehiena(taula);

		ArrayList<Float> azkenEmaitzak = new ArrayList<Float>();

		ArrayList<String> produktuEmaitzak = new ArrayList<String>();

		int z = 0;
		for (int i = emaitzak.size() - 1; z < zenbaki; i--) {
			azkenEmaitzak.add(emaitzak.get(i));
			z++;
		}

		for (int x = 0; x < azkenEmaitzak.size(); x++) {

			boolean  conseguido = false;

			for (int i = 0; i < taula.length && !conseguido; i++) {
				for (int j = 0; j < taula.length && !conseguido; j++) {
					if (azkenEmaitzak.get(x) == (taula[i][j]) && taula[i][j] != 0) {
						if (produktuEmaitzak.contains(produktuak[i].getIzena() + "/" + produktuak[j].getIzena()) == false && produktuEmaitzak.contains(produktuak[j].getIzena() + "/" + produktuak[i].getIzena()) == false) {
							produktuEmaitzak.add(produktuak[i].getIzena() + "/" + produktuak[j].getIzena());
							conseguido = true;
						}
					}
				}
			}
		}

		for (int i = 0; i < azkenEmaitzak.size(); i++) {
			System.out.println(azkenEmaitzak.get(i)+"egr");
		}

		for (int i = 0; i < produktuEmaitzak.size(); i++) {
			System.out.println(produktuEmaitzak.get(i)+"eg1");
		} 

		metodoakFitxategiak.sartuDatuakFitxategian(produktuEmaitzak, nif);
		
		return produktuEmaitzak;
	}

	public static ArrayList<Float> probabilitategehiena(float[][] taula) {
		ArrayList<Float> matrizeArrayra = new ArrayList<Float>();

		for (int i = 0; i < taula.length; i++) {
			for (int x = 0; x < taula[i].length; x++) {
				matrizeArrayra.add(taula[i][x]);
			}
		}
		matrizeArrayra.sort(null);
		return matrizeArrayra;
	}
}