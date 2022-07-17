package Java101;//  Patika.dev Java 101 Ödev 38

/*
  Öğrenci Not Sistemi
  Course Sınıfı Özellikleri :

  Nitelikler : name,code,prefix,note,Teacher
  Metotlar : Course() , addTeacher() , printTeacher()
  Teacher Sınıfı Özellikleri :

  Nitelikler : name,mpno,branch
  Metotlar : Teacher()
  Student Sınıfı Özellikleri :

  Nitelikler : name,stuNo,classes,course1,course2,course3,avarage,isPass
  Metotlar : Student(), addBulkExamNote(), isPass(), calcAvarage(), printNote()

  Ödev
  Course sınıfına derse ait sözlü notu kısmını girin ve
  ortalamaya etkisini her ders için ayrı ayrı belirtin.
  Sözlü notlarını da ortalamaya etkileme yüzdesi ile dahil edin.

  Örnek : Fizik dersine ait sözlü notunun ortalamaya etkisi
  % 20 ise sınav notunun etkisi %80'dir.

  Öğrenci sözlüden 90, sınavdan 60 almış ise,
  o dersin genel ortalamaya etkisi şu şekilde hesaplanır :

  Fizik Ortalaması : (90 * 0.20) + (60* 0.80);
*/

public class Odev38 {
    public static void main(String[] args) {
        Business business = new Business();

        Ogrenci o1 = new Ogrenci("1", "Arda");
        Ogrenci o2 = new Ogrenci("2", "Alex");
        Ogrenci o3 = new Ogrenci("3", "Lionel");

        o1.notEkle(50, 20, 40, 80, 60, 100);
        o2.notEkle(100, 50, 40, 70, 95, 40);
        o3.notEkle(80, 70, 55, 95, 55, 85);

        business.ort(o1);
        business.ort(o2);
        business.ort(o3);
        o1.listNotes();
        o2.listNotes();
        o3.listNotes();
        business.gectiMi(o1);
        business.gectiMi(o2);
        business.gectiMi(o3);
    }
}

class Entity {
    String id, name;

    public Entity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    Entity() {
    }
}

class Business {

    public void ort(Ogrenci ogrenci) {
        ortHesapla(ogrenci);
        anoHesapla(ogrenci);
    }
    private void ortHesapla(Ogrenci o) {
        Ders ders = new Ders();
        o.matOrt = (o.matNot * ders.matKatSayi) + (o.matSoz * (1.0 - ders.matKatSayi));
        o.fizOrt = (o.fizNot * ders.fizKatSayi) + (o.fizSoz * (1.0 - ders.fizKatSayi));
        o.kimOrt = (o.kimNot * ders.kimKatSayi) + (o.kimSoz * (1.0 - ders.kimKatSayi));
    }

    private void anoHesapla(Ogrenci o) {
        o.ano = (o.matOrt + o.fizOrt + o.kimOrt) / 3.0;
        o.gectiMi = !(o.ano < 55);
    }

    public void gectiMi(Ogrenci o) {
        if (o.gectiMi) {
            System.out.println(o.name + "; " + o.ano + " ortalama ile sınıfı geçti.");
        } else {
            System.out.println(o.name + "; " + o.ano + " ortalama ile sınıfta kaldı.");
        }
    }
}

class Ders extends Entity {
    double matKatSayi = 0.8, fizKatSayi = 0.7, kimKatSayi = 0.9;

    Ders() {
    }
}

class Ogrenci extends Entity {
    int matNot, fizNot, kimNot, matSoz, fizSoz, kimSoz;
    double ano, matOrt, fizOrt, kimOrt;
    boolean gectiMi;

    public Ogrenci(String id, String name) {
        super(id, name);
    }

    public void notEkle(int matNot, int fizNot, int kimNot, int matSoz, int fizSoz, int kimSoz) {
        if (matNot >= 0 && matNot <= 100 && matSoz >= 0 && matSoz <= 100 &&
                fizNot >= 0 && fizNot <= 100 && fizSoz >= 0 && fizSoz <= 100 &&
                kimNot >= 0 && kimNot <= 100 && kimSoz >= 0 && kimSoz <= 100) {
            this.matNot = matNot; this.fizNot = fizNot; this.kimNot = kimNot;
            this.matSoz = matSoz; this.fizSoz = fizSoz; this.kimSoz = kimSoz;
            System.out.println("Tüm notlar başarılı bir şekilde eklendi.");
        } else {
            System.out.println("Geçersiz not. Lütfen tekrar deneyiniz.");
        }
    }

    public void listNotes() {
        System.out.println("------------------------------" + "\n" +
                "Öğrenci : " + this.name + "\n" +
                "Matematik Notu : " + this.matOrt + "\n" +
                "Fizik Notu : " + this.fizOrt + "\n" +
                "Kimya Notu : " + this.kimOrt + "\n" +
                "ANO : " + this.ano + "\n" +
                "------------------------------");
    }
}