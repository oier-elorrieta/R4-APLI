package Modelo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import ModeloBBDD.metodoakPlaterrakEtaProduktuak;

public class metodoakProbabilitatea {

	// *****************************************************************************************************************************************************************************************************

	public static ArrayList<String> Probabilitatea(int zenbaki, Produktua produktuak[])
			throws ClassNotFoundException, SQLException, IOException {
		ModeloBBDD.metodoaProbabilitatea.Fechasartu();
		String fecha = ModeloBBDD.metodoaProbabilitatea.stringfecha();
		float taula[][] = new float[metodoakPlaterrakEtaProduktuak.produktuKantitatea()][metodoakPlaterrakEtaProduktuak
				.produktuKantitatea()];
		float emaitza = 0;

		// Produktuen probabilitea array bidimentsional batean sartzen dira
		for (int i = 0; i < produktuak.length; i++) {
			for (int j = 0; j < produktuak.length; j++) {
				if (i != j) {
					emaitza = ModeloBBDD.metodoakFuntzioakDeitu.funtzioProbabilitateOrokorra(produktuak[i].getIzena(),
							produktuak[j].getIzena());

					taula[i][j] = emaitza;
					ModeloBBDD.metodoaProbabilitatea.ProbGuztiasartu(produktuak[i].getIzena(), produktuak[j].getIzena(),
							emaitza, fecha);
				}
			}
		}

		// Array bidimentsionala arraylist batera bihurtzen du
		ArrayList<Float> emaitzak = probabilitategehiena(taula);

		ArrayList<Float> azkenEmaitzak = new ArrayList<Float>();

		ArrayList<String> produktuEmaitzak = new ArrayList<String>();

		// Arraylistan dauden probabilitateak zenbat nahi ditugun aukeratzen du
		int z = 0;
		for (int i = emaitzak.size() - 1; z < zenbaki; i--) {
			azkenEmaitzak.add(emaitzak.get(i));
			z++;
		}

		zenbakitikIzenak(azkenEmaitzak, taula, produktuEmaitzak, produktuak);

		// Probabilitate gehiena dutenak fitxerora eramaten du
		if (produktuEmaitzak.size() != 0) {
			metodoakFitxategiak.sartuDatuakFitxategian(produktuEmaitzak, null, zenbaki);
		}

		return produktuEmaitzak;
	}

	// *****************************************************************************************************************************************************************************************************

	public static ArrayList<String> ProbabilitateaLokala(int zenbaki, Produktua produktuak[], String nif)
			throws ClassNotFoundException, SQLException, IOException {
		ModeloBBDD.metodoaProbabilitatea.Fechasartu();
		String fecha = ModeloBBDD.metodoaProbabilitatea.stringfecha();
		float taula[][] = new float[metodoakPlaterrakEtaProduktuak.produktuKantitatea()][metodoakPlaterrakEtaProduktuak
				.produktuKantitatea()];
		float emaitza = 0;

		// Produktuen probabilitea array bidimentsional batean sartzen dira
		for (int i = 0; i < produktuak.length; i++) {
			for (int j = 0; j < produktuak.length; j++) {
				if (i != j) {

					emaitza = ModeloBBDD.metodoakFuntzioakDeitu.funtzioProbabilitateLokala(produktuak[i].getIzena(),
							produktuak[j].getIzena(), nif);

					taula[i][j] = emaitza;
					ModeloBBDD.metodoaProbabilitatea.ProbLocalasartu(produktuak[i].getIzena(), produktuak[j].getIzena(),
							emaitza, nif, fecha);
				}
			}
		}

		// Array bidimentsionala arraylist batera bihurtzen du
		ArrayList<Float> emaitzak = probabilitategehiena(taula);

		ArrayList<Float> azkenEmaitzak = new ArrayList<Float>();

		ArrayList<String> produktuEmaitzak = new ArrayList<String>();

		// Arraylistan dauden probabilitateak zenbat nahi ditugun aukeratzen du
		int z = 0;
		for (int i = emaitzak.size() - 1; z < zenbaki; i--) {
			azkenEmaitzak.add(emaitzak.get(i));
			z++;
		}

		zenbakitikIzenak(azkenEmaitzak, taula, produktuEmaitzak, produktuak);

		// Probabilitate gehiena dutenak fitxerora eramaten du
		if (produktuEmaitzak.size() != 0) {
			metodoakFitxategiak.sartuDatuakFitxategian(produktuEmaitzak, nif, zenbaki);
		}

		return produktuEmaitzak;
	}

	// *****************************************************************************************************************************************************************************************************

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

	// *****************************************************************************************************************************************************************************************************

	public static void zenbakitikIzenak(ArrayList<Float> azkenEmaitzak, float taula[][],
			ArrayList<String> produktuEmaitzak, Produktua produktuak[]) {

		// Arraylisten emaitzak arraybidimentsionalarekin konparatu egiten ditu.
		for (int x = 0; x < azkenEmaitzak.size(); x++) {

			boolean conseguido = false;

			for (int i = 0; i < taula.length && !conseguido; i++) {
				for (int j = 0; j < taula.length && !conseguido; j++) {
					
					//Konparaketan berdina ematen badu sartzen ditu produktuen izena beste arraylist batean.
					if (azkenEmaitzak.get(x) == (taula[i][j]) && taula[i][j] != 0) {
						if (produktuEmaitzak
								.contains(produktuak[i].getIzena() + "/" + produktuak[j].getIzena()) == false
								&& produktuEmaitzak
										.contains(produktuak[j].getIzena() + "/" + produktuak[i].getIzena()) == false) {
							produktuEmaitzak.add(produktuak[i].getIzena() + "/" + produktuak[j].getIzena());
							conseguido = true;
						}
					}
				}
			}
		}
	}
}