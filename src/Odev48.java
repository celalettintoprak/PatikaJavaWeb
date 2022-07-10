//  Patika.dev Java 101 Ödev 48

/*
  Programın 0-100 arasında rastgele seçtiği bir "Sayı Tahmin Oyunu".
*/

import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class Odev48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = new Random().nextInt(101);
        int input, counter = 5;
        StringJoiner predictions = new StringJoiner(", ");

        while (counter > 0) {
            System.out.print("Bir değer giriniz (0-100): ");
            input = scanner.nextInt();

            if (input < 0 || input > 100) {
                System.out.println("Geçersiz değer!");
            } else if (input == randomNumber) {
                System.out.println("Tebrikler, Kazandınız !");
                break;
            } else {
                predictions.add(String.valueOf(input));

                if (input < randomNumber) {
                    System.out.println(input + "; tutulan sayıdan küçüktür.");
                } else {
                    System.out.println(input + "; tutulan sayıdan büyüktür.");
                }
                counter--;
                if (counter == 1) {
                    System.out.println("Tahminleriniz: " + predictions + "  /  Son Hakkınız !");
                } else {
                    System.out.println("Tahminleriniz: " + predictions + "  /  Kalan Hakkınız: " + counter);
                }
            }
            if (counter == 0) {
                System.out.println("Üzgünüm, Kaybettiniz !");
            }
        }
    }
}