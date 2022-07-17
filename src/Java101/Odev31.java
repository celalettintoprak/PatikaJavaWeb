package Java101;//  Patika.dev Java 101 Ödev 31

/*
  Java döngüler ile fibonacci serisi bulan program yazıyoruz.
  Fibonacci serisinin eleman sayısını kullanıcıdan alın.

  Fibonacci Serisi Nedir ?
  Fibonacci serisi her sayının kendinden öncekiyle toplanması sonucu oluşan sayı dizisidir.
  Böyle devam eden bu dizide sayılar birbirleriyle oranlandığında altın oran ortaya çıkar,
  Bir sayı kendinden önceki sayıya bölündüğünde gittikçe altın orana yaklaşan dizi elde edilir.

  Fibonacci dizisi 0'dan başlar ve sonsuza kadardır. Her sayı, bir önceki sayıyla toplanır.
  Elde edilen sonuç sayının sağına yazılır. Fibonacci dizisinin ilk on sayısı şöyledir:
  9 Elemanlı Fibonacci Serisi : 1 1 2 3 5 8 13 21 34

  1 + 1 = 2
  1 + 2 = 3
  2 + 3 = 5
  3 + 5 = 8
  5 + 8 = 13
  8 + 13 = 21
  13 + 21 = 34
*/

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Odev31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Fibonacci Serinizin Eleman Sayısını Giriniz : ");
        int sayi = scanner.nextInt();
        int[] fibonacciDizisi = new int[sayi];
        fibonacci(sayi, fibonacciDizisi);

        for (int i : fibonacciDizisi) {
            System.out.print(i + ",");
        }
    }

    public static void fibonacci (int sayi, int[] dizi) {
        dizi[0] = 1;
        dizi[1] = 1;
        for (int i = 2; i < sayi; i++) {
            dizi[i] = dizi[i - 1] + dizi[i - 2];
        }
    }
}