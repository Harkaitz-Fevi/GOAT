package GOAT;
import java.util.Scanner;
import java.util.Random;
public class QUINIELA {

    public static void main(String[] args) {

        Scanner sarrera = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== QUINIELA DE 15 PARTIDOS ===");
        System.out.println("Opciones: 1 (Local gana), X (Empate), 2 (Visitante gana)\n");

        int asmatuta = 0; // contador de aciertos

        // Bucle for: recorre del partido 1 al 15
        for (int partido = 1; partido <= 15; partido++) {

            // Pedimos el pronóstico
            System.out.print("Partodua " + partido + " zure pronostikoa (1, X o 2): ");
            String texto = sarrera.next();
            char pronostikoa = texto.charAt(0); // tomamos solo el primer carácter

            // Validamos que sea 1, X o 2
            while (pronostikoa != '1' && pronostikoa != 'x' && pronostikoa != '2') {
                System.out.print("Aukera ez da egokia, sartu: 1, X o 2: ");
                texto = sarrera.next();
                pronostikoa = texto.charAt(0);
            }

            // Generamos resultado aleatorio
            int num = random.nextInt(3); // genera 0, 1 o 2
            char emaitza;

            if (num == 0) {
                emaitza = '1';
            } else if (num == 1) {
                emaitza = 'x';
            } else {
                emaitza = '2';
            }

            // Mostramos el resultado real
            System.out.println("Resultado real del partido " + partido + ": " + emaitza);

            // Comparamos usando ==
            if (pronostikoa == emaitza) {
                System.out.println("✅ ¡Asmatuta!\n");
                asmatuta++;
            } else {
                System.out.println("❌ Ez duzu asmatu\n");
            }
        }

        // Mostramos el total de aciertos 
        System.out.println("____________________________________");
        System.out.println("Asmatu duzu " + asmatuta + " 15 partidotik.");
        System.out.println("____________________________________");

        sarrera.close();
    }
}

