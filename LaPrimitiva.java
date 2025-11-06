package GOAT;

	import java.util.Random;
	import java.util.Scanner;
	
		public class LaPrimitiva {

		    public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        Random rand = new Random();

		        int[] zenbakiSortuak = new int[6];
		        int zenbakiOsagarria;
		        int reintegroa;
		        int[] erabiltzaileZenbakiak = new int[6];
		        int erabiltzaileReintegroa;
		        int zenbakia;
		        boolean errepikatua;

		        // --- Zenbaki nagusiak sortu ---
		        for (int i = 0; i < 6; i++) {
		            do {
		                errepikatua = false;
		                zenbakia = rand.nextInt(49) + 1; // 1-49

		                for (int j = 0; j < i; j++) {
		                    if (zenbakiSortuak[j] == zenbakia) {
		                        errepikatua = true;
		                    }
		                }
		            } while (errepikatua);
		            zenbakiSortuak[i] = zenbakia;
		        }

		        // --- Osagarri eta reintegro zenbakiak sortu ---
		        do {
		            zenbakiOsagarria = rand.nextInt(49) + 1;
		            errepikatua = false;
		            for (int j = 0; j < 6; j++) {
		                if (zenbakiSortuak[j] == zenbakiOsagarria) {
		                    errepikatua = true;
		                }
		            }
		        } while (errepikatua);

		        reintegroa = rand.nextInt(10); // 0-9

		        // --- Erabiltzailearen zenbakiak ---
		        System.out.println("-------LA PRIMITIVA-------");
		        System.out.println("Sartu zure 6 zenbakiak (1etik 49ra):");

		        for (int i = 0; i < 6; i++) {
		            boolean baliozkoa;
		            do {
		                baliozkoa = true;
		                System.out.print((i + 1) + ". zenbakia: ");
		                zenbakia = sc.nextInt();

		                if (zenbakia < 1 || zenbakia > 49) {
		                    System.out.println(" 1 eta 49 arteko zenbaki bat sartu!");
		                    baliozkoa = false;
		                }

		                for (int j = 0; j < i; j++) {
		                    if (erabiltzaileZenbakiak[j] == zenbakia) {
		                        System.out.println(" Zenbaki hori jada sartu duzu!");
		                        baliozkoa = false;
		                    }
		                }

		            } while (!baliozkoa);
		            erabiltzaileZenbakiak[i] = zenbakia;
		        }

		        // --- Reintegro zenbakia sartu (0-9 artekoa soilik) ---
		        do {
		            System.out.print("Sartu zure reintegro zenbakia (0-9): ");
		            erabiltzaileReintegroa = sc.nextInt();

		            if (erabiltzaileReintegroa < 0 || erabiltzaileReintegroa > 9) {
		                System.out.println(" Reintegro zenbakia 0 eta 9 artean egon behar da!");
		            }
		        } while (erabiltzaileReintegroa < 0 || erabiltzaileReintegroa > 9);

		        // --- Emaitzak erakutsi ---
		        System.out.print(" Zenbaki irabazleak: ");
		        for (int i = 0; i < 6; i++) {
		            System.out.print(zenbakiSortuak[i] + " ");
		        }
		        System.out.println(" Osagarria: " + zenbakiOsagarria);
		        System.out.println(" Reintegroa: " + reintegroa);

		        System.out.print(" Zure zenbakiak:      ");
		        for (int i = 0; i < 6; i++) {
		            System.out.print(erabiltzaileZenbakiak[i] + " ");
		        }
		        System.out.println(" Zure reintegroa: " + erabiltzaileReintegroa);

		        // --- Konparatu ---
		        int asmatuta = 0;
		        boolean osagarriaAsmatua = false;
		        for (int i = 0; i < 6; i++) {
		            for (int j = 0; j < 6; j++) {
		                if (zenbakiSortuak[i] == erabiltzaileZenbakiak[j]) {
		                    asmatuta++;
		                }
		            }
		            if (zenbakiOsagarria == erabiltzaileZenbakiak[i]) {
		                osagarriaAsmatua = true;
		            }
		        }

		        boolean reintegroAsmatua = (reintegroa == erabiltzaileReintegroa);

		        // --- Emaitza erakutsi ---
		        System.out.println(" Asmatutako zenbakiak: " + asmatuta);
		        if (osagarriaAsmatua) System.out.println(" Osagarria ere asmatu duzu!");
		        if (reintegroAsmatua) System.out.println(" Reintegroa asmatu duzu!");

		        if (asmatuta == 6) {
		            System.out.println(" Zorionak! Saria handiena irabazi duzu!");
		        } else if (asmatuta == 5 && osagarriaAsmatua) {
		            System.out.println(" Bigarren mailako saria irabazi duzu!");
		        } else if (asmatuta == 5) {
		            System.out.println(" Hirugarren mailako saria irabazi duzu!");
		        } else if (asmatuta == 4) {
		            System.out.println(" Laugarren mailako saria irabazi duzu!");
		        } else if (asmatuta == 3) {
		            System.out.println(" Bosgarren mailako saria irabazi duzu!");
		        } else if (reintegroAsmatua) {
		            System.out.println(" Reintegroa asmatu duzu, zure dirua berreskuratu duzu!");
		        } else {
		            System.out.println(" Ez duzu ezer irabazi oraingoan. Saiatu berriro!");
		        }

		        sc.close();
		    }
		}