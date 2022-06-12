import java.util.Scanner;

public class Odev01 {
    public static void main(String[] args) {

        int sum = 0;
        String[] dersler = {"Matematik", "Fizik", "Kimya", "Türkçe", "Müzik"};
        int[] notlar = new int[dersler.length];

        for(int i = 0; i < notlar.length; i++) {
            notlar[i] = notEkle(dersler[i]);
        }

        for (int ders : notlar) {
            sum += ders;
        }
        System.out.println(dersler.length + " dersin not ortalaması: " + sum / dersler.length);
    }

    public static int notEkle(String dersAdi) {
        Scanner input = new Scanner(System.in);
        int inputDers;

        while(true)
        {
            System.out.print(dersAdi + " ders notu: ");
            inputDers = input.nextInt();

            if (inputDers >= 0 && inputDers <=100) {
                System.out.println(dersAdi + " ders notu eklendi: " + inputDers);
                break;
            } else {
                System.out.println("Lütfen 0 ile 100 arasında değer giriniz.");
            }
        }
        return inputDers;
    }
}