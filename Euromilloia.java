package GOAT;

import java.util.Random;
import java.util.Scanner;

public class Euromilloia {

	    public static void main(String[] args) {
	    	// TODO Auto-generated method stub
	        Scanner scan = new Scanner(System.in);
	        //Programa honek ausaz sortuko ditu zenbaki irabazleak eta izarrak
	        Random random = new Random();

	        int[] zenbakiIrabazleak = new int[5];
	        int[] izarIrabazleak = new int[2];
	        int[] zureZenbakiak = new int[5];
	        int[] zureIzarrak = new int[2];

	        System.out.println("---- EUROMILLIOIAREN KONPROBATZAILEA ----");

	        // --- Zenbaki irabazleak sortu (1-50, ez errepikatu) ---
	        for (int i = 0; i < 5; i++) {
	            int zenb;
	            boolean errepikatua;
	            do {
	                errepikatua = false;
	                zenb = random.nextInt(50) + 1;
	                for (int j = 0; j < i; j++) {
	                    if (zenbakiIrabazleak[j] == zenb) {
	                        errepikatua = true;
	                        break;
	                    }
	                }
	            } while (errepikatua);
	            zenbakiIrabazleak[i] = zenb;
	        }

	        // --- Izar irabazleak sortu (1-12, ez errepikatu) ---
	        for (int i = 0; i < 2; i++) {
	            int izar;
	            boolean errepikatua;
	            do {
	                errepikatua = false;
	                izar = random.nextInt(12) + 1;
	                for (int j = 0; j < i; j++) {
	                    if (izarIrabazleak[j] == izar) {
	                        errepikatua = true;
	                        break;
	                    }
	                }
	            } while (errepikatua);
	            izarIrabazleak[i] = izar;
	        }

	        // --- Erabiltzailearen zenbakiak ---
	        System.out.println("Sartu zure 5 zenbakiak (1etik 50era, ez errepikatu):");
	        for (int i = 0; i < 5; i++) {
	            int n;
	            boolean baliogabea;
	            do {
	                baliogabea = false;
	                n = scan.nextInt();
	                if (n < 1 || n > 50) {
	                    System.out.println(" Zenbakia 1 eta 50 artean egon behar da.");
	                    baliogabea = true;
	                } else {
	                    for (int j = 0; j < i; j++) {
	                        if (zureZenbakiak[j] == n) {
	                            System.out.println(" Zenbaki hori jada sartu duzu.");
	                            baliogabea = true;
	                            break;
	                        }
	                    }
	                }
	            } while (baliogabea);
	            zureZenbakiak[i] = n;
	        }

	        // --- Erabiltzailearen izarrak ---
	        System.out.println("Orain sartu zure 2 izarrak (1etik 12ra, ez errepikatu):");
	        for (int i = 0; i < 2; i++) {
	            int e;
	            boolean baliogabea;
	            do {
	                baliogabea = false;
	                e = scan.nextInt();
	                if (e < 1 || e > 12) {
	                    System.out.println(" Izarra 1 eta 12 artean egon behar da.");
	                    baliogabea = true;
	                } else {
	                    for (int j = 0; j < i; j++) {
	                        if (zureIzarrak[j] == e) {
	                            System.out.println(" Izar hori jada sartu duzu.");
	                            baliogabea = true;
	                            break;
	                        }
	                    }
	                }
	            } while (baliogabea);
	            zureIzarrak[i] = e;
	        }

	        // --- Asmatutakoak zenbatu ---
	        int zenbakiAsmatuta = 0;
	        int izarAsmatuta = 0;

	        for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 5; j++) {
	                if (zureZenbakiak[i] == zenbakiIrabazleak[j]) {
	                    zenbakiAsmatuta++;
	                }
	            }
	        }

	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	                if (zureIzarrak[i] == izarIrabazleak[j]) {
	                    izarAsmatuta++;
	                }
	            }
	        }

	        // --- Emaitzak erakutsi ---
	        System.out.println(" EMAITZAK:");
	        System.out.print("Zenbaki irabazleak: ");
	        erakutsiArraya(zenbakiIrabazleak);
	        System.out.print("Izar irabazleak: ");
	        erakutsiArraya(izarIrabazleak);
	        System.out.println("Asmatu dituzun zenbakiak: " + zenbakiAsmatuta);
	        System.out.println("Asmatu dituzun izarrak: " + izarAsmatuta);

	        // --- Saria erakutsi ---
	        String saria = zehaztuSaria(zenbakiAsmatuta, izarAsmatuta);
	        System.out.println(" " + saria);

	        scan.close();
	    }

	    // Array bat pantailaratzeko metodo txiki bat
	    public static void erakutsiArraya(int[] a) {
	        for (int i = 0; i < a.length; i++) {
	            System.out.print(a[i]);
	            if (i < a.length - 1) System.out.print(", ");
	        }
	        System.out.println();
	    }

	    // Saria zehazteko metodoa
	    public static String zehaztuSaria(int zenbakiak, int izarrak) {
	        if (zenbakiak == 5 && izarrak == 2) return " Zorionak! EUROMILLIOIA irabazi duzu!";
	        if (zenbakiak == 5 && izarrak == 1) return " Bigarren mailako saria!";
	        if (zenbakiak == 5 && izarrak == 0) return " Hirugarren mailako saria!";
	        if (zenbakiak == 4 && izarrak == 2) return " Laugarren mailako saria.";
	        if (zenbakiak == 4 && izarrak == 1) return " Bosgarren mailako saria.";
	        if (zenbakiak == 3 && izarrak == 2) return " Seigarren mailako saria.";
	        if (zenbakiak == 2 && izarrak == 2) return " Zazpigarren mailako saria.";
	        if (zenbakiak == 3 && izarrak == 1) return " Zortzigarren mailako saria.";
	        if (zenbakiak == 3 && izarrak == 0) return " Bederatzigarren mailako saria.";
	        if (zenbakiak == 1 && izarrak == 2) return " Hamargarren mailako saria.";
	        if (zenbakiak == 2 && izarrak == 1) return " Hamaikagarren mailako saria.";
	        return " Barkatu, ez duzu sariarik irabazi oraingoan.";
	    }
	}

