//  Patika.dev Java 101 Ödev 25

/*
  Java döngüler ile kullanıcının banka hesabını yönetebildiği bir ATM projesi yapıyoruz.

  Ödev
  Aynı projedeki ATM işlemlerini "Switch-Case" kullanarak yapınız.

  * Kullanıcı adı ve parola sorgusu ile sisteme giriş
  * Para yatırma, para çekme, bakiye sorgulama, çıkış yapma işlemleri
  * İşlemler yapılırken tutar miktarı sorgusu, bakiye yetersiz dönütü
  *
*/

import java.util.Scanner;

public class Odev25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "patika", password = "dev123", usernameInput, passwordInput;
        int balance = 2000, attempt = 0, choice;

        System.out.println("Patika Bank'a Hoşgeldiniz!");
        while (attempt < 3) {
            System.out.print("Kullanıcı Adınız : ");
            usernameInput = scanner.nextLine();
            System.out.print("Parolanız : ");
            passwordInput = scanner.nextLine();

            if (usernameInput.equals(username) && passwordInput.equals(password)) {
                System.out.println("Giriş başarılı.");
                do {
                    System.out.println("1- Para yatırma\n" +
                            "2- Para çekme\n" +
                            "3- Bakiye sorgula\n" +
                            "4- Çıkış yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");

                    choice = scanner.nextInt();
                    if (choice == 1) {
                        System.out.print(">> Tutar : ");
                        int amount = scanner.nextInt();
                        balance += amount;
                        System.out.println("## Bakiye : " + balance);
                    } else if (choice == 2) {
                        System.out.print(">> Tutar : ");
                        int amount = scanner.nextInt();
                        if (amount > balance) {
                            System.out.println("Yetersiz bakiye! Tekrar deneyiniz.");
                        } else {
                            balance -= amount;
                            System.out.println("## Bakiye : " + balance);
                        }
                    } else if (choice == 3) {
                        System.out.println("## Bakiye : " + balance);
                    }
                }
                while (choice != 4);
                System.out.println("** Tekrar görüşmek üzere. **");
                break;
            } else {
                attempt++;
                System.out.println("Giriş bilgileri hatalı. Tekrar deneyiniz.");
                if (attempt == 3) {
                    System.out.println("Hesabınız bloke olmuştur.");
                } else {
                    System.out.println((3 - attempt) + " deneme hakkınız kaldı.");
                }
            }
        }
    }
}