package Apustuak;

import java.util.Random;
import java.util.Scanner;

public class Nagusia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		int zenb;
		do {
			System.out.println();
			System.out.println("-------------------MENU NAGUSIA-------------------");
			System.out.println();
			System.out.println("Aukeratu zenbakia");
			System.out.println("--------------------------------------------------");
			System.out.println("Primitiba --> 1");
			System.out.println("Euromillones --> 2");
			System.out.println("La Quiniela --> 3");
			System.out.println("Irten programatik --> 0");
			System.out.println("--------------------------------------------------");

			System.out.println("Sartu zenbakia");
			zenb = sc.nextInt();
			System.out.println("Irakurri ondoren");

			while(true) {
				if (zenb >= 0 && zenb <= 3) {
					break; // zenbaki zuzena --> bukletik ateratzen gara
				} else {
					System.out.println("Zure zenbakia ez da zuzena, sartu berriro");
					zenb = sc.nextInt();
				}
			}


			if(zenb == 1) {
				LaPrimitiva(sc);
			} else if (zenb == 2){
				Euromilloia(sc);
			} else if (zenb == 3) {
				Quiniela(sc);
			} else if (zenb == 0) {
				System.out.println("----ESKERRIK ASKO ETORTZEAGATIK ----");
				//sc.close();
			}
		}while (zenb != 0);
		System.out.println("Programa nagusira bueltatu zara");
		sc.close();
	}
	public static void LaPrimitiva(Scanner sc) {
		//Scanner sc = new Scanner(System.in);
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

		//sc.close();
	}

	public static void Euromilloia(Scanner sc) {
		// TODO Auto-generated method stub
		//Scanner scan = new Scanner(System.in);
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
				n = sc.nextInt();
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
				e = sc.nextInt();
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

		//scan.close();
	}

	// Array bat pantailaratzeko metodo txiki bat
	public static void erakutsiArraya(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i < a.length - 1) System.out.print(", ");
		}
		System.out.println();
		//Hurrengo lerrora pasatzeko
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

	
public static void Quiniela(Scanner sc) {

    //Scanner sc = new Scanner(System.in);
    Random random = new Random();

    System.out.println("=== 15 PARTIDOKO QUINIELA ===");
    System.out.println("Aukerak: 1 (Etxekoak irabazi), X (Berdinketa), 2 (Bisitariak irabazi)\n");

    int asmatuta = 0; // asmatutakoaren kontadorea

    // Bucle for:  1-tik  15-erako buclea
    for (int partido = 1; partido <= 15; partido++) {

        // Pedimos el pronóstico
        System.out.print("Partidua " + partido + " zure pronostikoa (1, X o 2): ");
        String texto = sc.next();
        char pronostikoa = texto.charAt(0); // lehengo karakterea hartzen du bakarrik

        // komprobatu 1, X o 2 direla
        while (pronostikoa != '1' && pronostikoa != 'x' && pronostikoa != '2') {
            System.out.print("Aukera ez da egokia, sartu: 1, X o 2: ");
            texto = sc.next();
            pronostikoa = texto.charAt(0);
        }

        // Emaitza sortzen du 
        int num = random.nextInt(3); //  0, 1 o 2 zenbakiak sortzen ditu
        char emaitza;

        if (num == 0) {
            emaitza = '1';
        } else if (num == 1) {
            emaitza = 'x';
        } else {
            emaitza = '2';
        }

        // partiduaren benetako emaitza erakutzi
        System.out.println("Resultado real del partido " + partido + ": " + emaitza);

        //  == erabiliz komprobatzen dugu
        if (pronostikoa == emaitza) {
            System.out.println("✅ ¡Asmatuta!\n");
            asmatuta++;
        } else {
            System.out.println("❌ Ez duzu asmatu\n");
        }
    }

    // Asmakizun totalak biztaratu
    System.out.println("____________________________________");
    System.out.println("Asmatu duzu " + asmatuta + " / 15 partidotik.");
    System.out.println("____________________________________");

    //sc.close();
}
}


