//  Patika.dev Java 101 Ödev 47

/*
  Çok boyutlu diziler ile oluşturulmuş matrisin transpozunu bulan programı yazınız.
  Matrisin transpozunu (devriğini) almak, matrisin aynı numaralı satırları ile
  sütunlarının yer değiştirmesi demektir. Bu işlem sonucu elde edilen matris,
  başlangıçtaki matrisin transpozudur (devriğidir). Bu aşamada kxn’lik bir matrisin
  transpozu (devriği) nxk’lik bir matris olur. Örneğin bir A matrisimiz olsun.
  Bu A matrisinin transpozu (devriği), A^T (A üzeri T) ile gösterilir.

  Örneğin aşağıdaki 2x3’lik A matrisinin transpozu (devriği), 2x3’lük bir A^T matrisidir.

  Senaryo
  Matris :
  2    3    4
  5    6    4

  Transpoze :
  2    5
  3    6
  4    4

*/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Odev47 {
    public static void main(String[] args) {
        int[][] matris = {{2, 3, 4}, {5, 6, 4}};

        System.out.println("Matris :");
        matrisYazdir(matris);
        System.out.println("\n" + "Transpoze :");
        matrisYazdir(transpoze(matris));
    }

    public static int[][] transpoze(int[][] matris) {
        int[][] transpoz = new int[matris[0].length][matris.length];
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[0].length; j++) {
                transpoz[j][i] = matris[i][j];
            }
        }
        return transpoz;
    }

    public static void matrisYazdir(int[][] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                System.out.print(" " + dizi[i][j] + " ");
            }
            System.out.println();
        }
    }
}