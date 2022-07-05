//  Patika.dev Java 101 Ödev 39

/*
  Boks Maçı
  Java Sınıflar ile boks maçını simüle eden programı yazıyoruz.

  Ödev
  %50 olasılık ile dövüşe ilk kimin başlayacağını hesaplayan sistem geliştiriniz.
*/

import java.util.Random;

public class Odev39 {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("Bora",60,100);
        Fighter f2 = new Fighter("Ahmet",58,100);
        Ring r1 = new Ring(f1,f2,"ABD");
        r1.baslat();
    }
}

class Fighter {
    String name;
    int strength, health;

    Fighter(String name,int strength,int health) {
        this.name = name;
        this.strength = strength;
        this.health = health;
    }
}

class Ring {
    Fighter f1, f2;
    String name;
    int baslayan;
    Random rand = new Random();
    Ring(Fighter f1,Fighter f2,String name) {
        this.f1 = f1;
        this.f2 = f2;
        this.name = name;
    }
    void baslat() {
        baslayan = rand.nextInt(2);
        if(baslayan == 0){
            System.out.println("Maça başlayan " + this.f1.name + "!");
        } else {
            System.out.println("Maça başlayan " + this.f2.name + "!");
        }
        fight();
    }
    void fight(){
        int round = 1;
        while(this.f1.health > 0 && this.f2.health > 0) {
            System.out.println("=== "+this.name + " Ringinde Round - " + round + " ===");

            int f1_dmg = rand.nextInt(20);
            int f2_dmg = rand.nextInt(20);
            if(baslayan == 0) {
                f2.health -= f1_dmg;
                f1.health -= f2_dmg;
            } else {
                f1.health -= f1_dmg;
                f2.health -= f2_dmg;
            }

            System.out.println(this.f1.name + " => "+this.f2.name+" : " + f1_dmg + " DMG!");
            System.out.println(this.f2.name + " => "+this.f1.name+" : " + f2_dmg + " DMG!");

            if(f1.health < 0) {
                f1.health = 0;
            }
            if(f2.health < 0) {
                f2.health = 0;
            }


            System.out.println(this.f1.name + " kalan canı : "+ this.f1.health);
            System.out.println(this.f2.name + " kalan canı : "+ this.f2.health);
            System.out.println("=======================================");
            round++;
        }
        kazanan();
    }
    void kazanan()
    {
        if (f1.health == 0 && f2.health == 0) {
            System.out.println("Berabere !");
        } else if (f1.health == 0) {
            System.out.println("Maçı kazanan : " + f2.name);
        } else if (f2.health == 0) {
            System.out.println("Maçı kazanan : " + f1.name);
        }
    }
}