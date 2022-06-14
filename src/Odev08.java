// Patika.dev Java 101 Ödev 8

/*
  Videodaki hesap makinesini switch-case kullanarak yapınız.
 */

import java.util.Scanner;

public class Odev08 {
    public static void main(String[] args) {
        int n1, n2;
        String islem;
        Scanner input = new Scanner(System.in);
        System.out.print("1. Sayıyı Giriniz: ");
        n1 = input.nextInt();
        System.out.print("2. Sayıyı Giriniz: ");
        n2 = input.nextInt();

        System.out.println("********************");
        System.out.println("""
                1- Toplama İşlemi
                2- Çıkarma İşlemi
                3- Çarpma İşlemi
                4- Bölme İşlemi""");
        System.out.println("********************");
        System.out.print("Yapmak istediğiniz işlem: ");
        islem = input.next();

        switch (islem) {
            case "1":
                System.out.println("Toplama Sonucu: " + (n1 + n2));
                break;
            case "2":
                System.out.println("Çıkarma Sonucu: " + (n1 - n2));
                break;
            case "3":
                System.out.println("Çarpma Sonucu: " + (n1 * n2));
                break;
            case "4":
                switch (n2) {
                    case 0:
                        System.out.println("0'a bölme işlemi yapılamaz.");
                        break;
                    default:
                        System.out.println("Bölme Sonucu: " + (n1 / n2));
                }
                break;
            default:
                System.out.println("Geçersiz işlem");
        }
    }
}