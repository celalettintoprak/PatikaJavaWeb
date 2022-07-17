package Java101;// Patika.dev Java 101 Ödev 13

/*
  Koç Burcu : 21 Mart - 20 Nisan
  Boğa Burcu : 21 Nisan - 21 Mayıs
  İkizler Burcu : 22 Mayıs - 22 Haziran
  Yengeç Burcu : 23 Haziran - 22 Temmuz
  Aslan Burcu : 23 Temmuz - 22 Ağustos
  Başak Burcu : 23 Ağustos - 22 Eylül
  Terazi Burcu : 23 Eylül - 22 Ekim
  Akrep Burcu : 23 Ekim - 21 Kasım
  Yay Burcu : 22 Kasım - 21 Aralık
  Oğlak Burcu : 22 Aralık - 21 Ocak
  Kova Burcu : 22 Ocak - 19 Şubat
  Balık Burcu : 20 Şubat - 20 Mart

  Ödev
  Aynı örneği switch-case kullanmadan yapınız.
 */

import java.time.LocalDate;
import java.util.Scanner;

public class Odev13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen doğum tarihinizi YYYY-AA-GG biçiminde giriniz: ");
        String inputDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(inputDate);

        burcBulma(date);
    }

    public static void burcBulma (LocalDate date) {

        LocalDate bKoc1 = LocalDate.of(date.getYear(), 3, 21);
        LocalDate bKoc2 = LocalDate.of(date.getYear(), 4, 20);
        LocalDate bBoga1 = LocalDate.of(date.getYear(), 4, 21);
        LocalDate bBoga2 = LocalDate.of(date.getYear(), 5, 21);
        LocalDate bIkizler1 = LocalDate.of(date.getYear(), 5, 22);
        LocalDate bIkizler2 = LocalDate.of(date.getYear(), 6, 22);
        LocalDate bYengec1 = LocalDate.of(date.getYear(), 6, 23);
        LocalDate bYengec2 = LocalDate.of(date.getYear(), 7, 22);
        LocalDate bAslan1 = LocalDate.of(date.getYear(), 7, 23);
        LocalDate bAslan2 = LocalDate.of(date.getYear(), 8, 22);
        LocalDate bBasak1 = LocalDate.of(date.getYear(), 8, 23);
        LocalDate bBasak2 = LocalDate.of(date.getYear(), 9, 22);
        LocalDate bTerazi1 = LocalDate.of(date.getYear(), 9, 23);
        LocalDate bTerazi2 = LocalDate.of(date.getYear(), 10, 22);
        LocalDate bAkrep1 = LocalDate.of(date.getYear(), 10, 23);
        LocalDate bAkrep2 = LocalDate.of(date.getYear(), 11, 21);
        LocalDate bYay1 = LocalDate.of(date.getYear(), 11, 22);
        LocalDate bYay2 = LocalDate.of(date.getYear(), 12, 21);
        LocalDate bOglak1 = LocalDate.of(date.getYear(), 12, 22);
        LocalDate bOglak2 = LocalDate.of(date.getYear(), 1, 21);
        LocalDate bKova1 = LocalDate.of(date.getYear(), 1, 22);
        LocalDate bKova2 = LocalDate.of(date.getYear(), 2, 19);
        LocalDate bBalik1 = LocalDate.of(date.getYear(), 2, 20);
        LocalDate bBalik2 = LocalDate.of(date.getYear(), 3, 20);

        if (date.isAfter(bKoc1) && date.isBefore(bKoc2) || date.isEqual(bKoc1) || date.isEqual(bKoc2)) {
            System.out.println("Burç: " + "Koç");
        } else if (date.isAfter(bBoga1) && date.isBefore(bBoga2) || date.isEqual(bBoga1) || date.isEqual(bBoga2)) {
            System.out.println("Burç: " + "Boğa");
        } else if (date.isAfter(bIkizler1) && date.isBefore(bIkizler2) || date.isEqual(bIkizler1) || date.isEqual(bIkizler2)) {
            System.out.println("Burç: " + "İkizler");
        } else if (date.isAfter(bYengec1) && date.isBefore(bYengec2) || date.isEqual(bYengec1) || date.isEqual(bYengec2)) {
            System.out.println("Burç: " + "Yengeç");
        } else if (date.isAfter(bAslan1) && date.isBefore(bAslan2) || date.isEqual(bAslan1) || date.isEqual(bAslan2)) {
            System.out.println("Burç: " + "Aslan");
        } else if (date.isAfter(bBasak1) && date.isBefore(bBasak2) || date.isEqual(bBasak1) || date.isEqual(bBasak2)) {
            System.out.println("Burç: " + "Başak");
        } else if (date.isAfter(bTerazi1) && date.isBefore(bTerazi2) || date.isEqual(bTerazi1) || date.isEqual(bTerazi2)) {
            System.out.println("Burç: " + "Terazi");
        } else if (date.isAfter(bAkrep1) && date.isBefore(bAkrep2) || date.isEqual(bAkrep1) || date.isEqual(bAkrep2)) {
            System.out.println("Burç: " + "Akrep");
        } else if (date.isAfter(bYay1) && date.isBefore(bYay2) || date.isEqual(bYay1) || date.isEqual(bYay2)) {
            System.out.println("Burç: " + "Yay");
        } else if (date.isAfter(bOglak1) && date.isBefore(bOglak2) || date.isEqual(bOglak1) || date.isEqual(bOglak2)) {
            System.out.println("Burç: " + "Oğlak");
        } else if (date.isAfter(bKova1) && date.isBefore(bKova2) || date.isEqual(bKova1) || date.isEqual(bKova2)) {
            System.out.println("Burç: " + "Kova");
        } else if (date.isAfter(bBalik1) && date.isBefore(bBalik2) || date.isEqual(bBalik1) || date.isEqual(bBalik2)) {
            System.out.println("Burç: " + "Balık");
        }
    }
}