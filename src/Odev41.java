//  Patika.dev Java 101 Ödev 41

/*
  Dizideki Elemanların Ortalamasını Hesaplayan Program
*/

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Odev41 {
    public static void main(String[] args) {
        int[] sayilar = {1, 2, 3, 7, 12, 15, 28};
        System.out.println("Dizi Ortalaması : " + ortHesapla(sayilar));
        System.out.println("Harmonik Seri : " + harmonikSeri(sayilar));
        System.out.println("Harmonik Ortalama : " + harmonikOrt(sayilar));

        // IntStream intStream = IntStream.of(sayilar);
        // OptionalDouble optionalDouble = intStream.average();
        // System.out.println(optionalDouble.getAsDouble());
    }

    public static double ortHesapla(int[] dizi) {
        int toplam = 0;
        for (int i : dizi) {
            toplam += i;
        }
        return (double) toplam / dizi.length;
    }

    public static float harmonikSeri(int[] dizi) {
        float sonuc = 0;
        for (int i : dizi) {
            sonuc += 1f / i;
        }
        return sonuc;
    }

    public static double harmonikOrt(int[] dizi) {
        return dizi.length / harmonikSeri(dizi);
    }
}
