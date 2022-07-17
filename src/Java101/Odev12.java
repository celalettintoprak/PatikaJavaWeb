package Java101;// Patika.dev Java 101 Ödev 12

/*
  Ödev - Girilen 3 sayıyı "küçükten büyüğe" sıralayan programı yazınız.
 */

import java.util.Scanner;

public class Odev12 {
    public static void main(String[] args) {
        int a,b,c;
        Scanner input = new Scanner(System.in);
        System.out.print("1. sayıyı giriniz: ");
        a = input.nextInt();
        System.out.print("2. sayıyı giriniz: ");
        b = input.nextInt();
        System.out.print("3. sayıyı giriniz: ");
        c = input.nextInt();

        System.out.print("Küçükten büyüğe doğru sıralama: ");
        if (a<b && b<c) {
            System.out.println("a < b < c");
        } else if (c<b && b<a) {
            System.out.println("c < b < a");
        } else if (a<c && c<b) {
            System.out.println("a < c < b");
        } else if (b<c && c<a) {
            System.out.println("b < c < a");
        } else if (b<a && a<c) {
            System.out.println("b < a < c");
        } else if (c<a && a<b) {
            System.out.println("c < a < b");
        } else {
            System.out.println("Geçersiz işlem...");
        }
    }
}