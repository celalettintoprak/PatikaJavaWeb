package Java101;// Patika.dev Java 101 Ödev 5

/*
  Dairenin Alanını ve Çevresini Hesaplayan Program
  Java ile yarı çapını kullanıcıdan aldığınız dairenin
  alanını ve çevresini hesaplayan programı yazın.
  Alan Formülü : π * r * r;
  Çevre Formülü : 2 * π * r;

  Ödev
  Yarıçapı r, merkez açısının ölçüsü 𝛼 olan daire diliminin
  alanı bulan programı yazınız.
  𝜋 sayısını = 3.14 alınız.
  Formül : (𝜋 * (r*r) * 𝛼) / 360
 */

import java.util.Scanner;

public class Odev05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String decimalFormat = "%.2f";
        double pi = 3.14;
        System.out.print("Lütfen bir yarıçap giriniz: ");
        int yaricap = input.nextInt();

        System.out.println("Alan: " + pi * Math.pow(yaricap, 2));
        System.out.println("Çevre: " + String.format(decimalFormat, 2 * pi * yaricap));

        System.out.print("Lütfen bir açı giriniz: ");
        int aci = input.nextInt();

        System.out.println("Daire Diliminin Alanı: " +
                String.format(decimalFormat, pi * Math.pow(yaricap, 2) * aci / 360));

    }
}