package Java101;// Patika.dev Java 101 Ödev 9

/*
  Eğer şifre yanlış ise kullanıcıya şifresini sıfırlayıp sıfırlamayacağını sorun,
  eğer kullanıcı sıfırlamak isterse yeni girdiği şifrenin hatalı girdiği
  ve unuttuğu şifre ile aynı olmaması gerektiğini kontrol edip, şifreler aynı ise
  ekrana "Şifre oluşturulamadı, lütfen başka şifre giriniz." sorun yoksa
  "Şifre oluşturuldu" yazan programı yazınız.
 */

import java.util.Scanner;

public class Odev09 {
    public static void main(String[] args) {
        String username = "patika", password = "1234";
        String usernameType, passwordType;
        Scanner input = new Scanner(System.in);
        System.out.print("Kullanıcı Adınız: ");
        usernameType = input.nextLine();
        System.out.print("Şifreniz: ");
        passwordType = input.nextLine();

        if (usernameType.equals(username) && passwordType.equals(password)) {
            System.out.println("Giriş yaptınız...");
        } else {
            System.out.println("Eksik ya da yanlış bilgi, giriş başarısız.");
            System.out.print("Şifrenizi sıfırlamak ister misiniz?" + "\n" + "1-Evet / 2-Hayır ");
            String answer = input.nextLine();
            switch (answer) {
                case "1":
                    while (true) {
                        System.out.print("Yeni şifrenizi giriniz: ");
                        String reset = input.nextLine();

                        if (reset.equals(password) || reset.equals(passwordType)) {
                            System.out.println("Şifre oluşturulamadı, lütfen başka şifre giriniz.");
                        } else {
                            System.out.println("Şifre oluşturuldu.");
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Şifre değiştirilmeyecek, program sonu...");
            }
        }
    }
}