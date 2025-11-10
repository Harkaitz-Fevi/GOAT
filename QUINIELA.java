package GOAT;
import java.util.Scanner;
import java.util.Random;
public class QUINIELA {

    public static void main(String[] args) {

        Scanner sarrera = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== 15 PARTIDOKO QUINIELA" ===");
        System.out.println("Aukerak: 1 (Etxekoak irabazi), X (Berdinketa), 2 (Bisitariak irabazi)\n");

        int asmatuta = 0; // asmatutakoaren kontadorea

        // Bucle for:  1-tik  15-erako buclea
        for (int partido = 1; partido <= 15; partido++) {

            // Pedimos el pronóstico
            System.out.print("Partidua " + partido + " zure pronostikoa (1, X o 2): ");
            String texto = sarrera.next();
            char pronostikoa = texto.charAt(0); // lehengo karakterea hartzen du bakarrik

            // komprobatu 1, X o 2 direla
            while (pronostikoa != '1' && pronostikoa != 'x' && pronostikoa != '2') {
                System.out.print("Aukera ez da egokia, sartu: 1, X o 2: ");
                texto = sarrera.next();
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
        System.out.println("Asmatu duzu " + asmatuta + " 15 partidotik.");
        System.out.println("____________________________________");

        sarrera.close();
    }
}

