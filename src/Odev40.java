//  Patika.dev Java 101 Ödev 40

/*
  Java'da "Employee" adında fabrika çalışanlarını temsil eden ve metotları ile çalışanların
  maaşlarını hesaplayan bir sınıf yazmalısınız. Bu sınıf 4 nitelik ve 5 metoda sahip olacaktır.

  Sınıfın Nitelikleri

  - name : Çalışanın adı ve soyadı
  - salary : Çalışanın maaşı
  - workHours : Haftalık çalışma saati
  - hireYear : İşe başlangıç yılı
*/
/*
  Sınıfın Metotları

  - Employee(name,salary,workHours,hireYear) : Kurucu metot olup 4 parametre alacaktır.
  - tax() : Maaşa uygulanan vergiyi hesaplayacaktır.
  - Çalışanın maaşı 1000 TL'den az ise vergi uygulanmayacaktır.
  - Çalışanın maaşı 1000 TL'den fazla ise maaşının %3'ü kadar vergi uygulanacaktır.
  - bonus() : Eğer çalışan haftada 40 saatten fazla çalışmış ise fazladan çalıştığı
    her saat başına 30 TL olacak şekilde bonus ücretleri hesaplayacaktır.
  - raiseSalary() : Çalışanın işe başlangıç yılına göre maaş artışını hesaplayacaktır.
    Şuan ki yılı 2021 olarak alın.
  - Eğer çalışan 10 yıldan az bir süredir çalışıyorsa maaşına %5 zam yapılacaktır.
  - Eğer çalışan 9 yıldan fazla ve 20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
  - Eğer çalışan 19 yıldan fazla çalışıyorsa %15 zam yapılacaktır.
  - toString() : Çalışana ait bilgileri ekrana bastıracaktır.
*/
/*
  Örnek :
  Adı : kemal
  Maaşı : 2000.0
  Çalışma Saati : 45
  Başlangıç Yılı : 1985
  Vergi : 60.0
  Bonus : 150.0
  Maaş Artışı : 300.0
  Vergi ve Bonuslar ile birlikte maaş : 2090.0
  Toplam Maaş : 2300.0
*/

public class Odev40 {
    public static void main(String[] args) {
        Employee employee = new Employee("Ahmet Avcı", 3200, 47, 2000);
        employee.listingParameters();
    }
}

class Employee {
    String name;
    double salary, bonus = 0, tax = 0, increase = 0;
    int workHours, hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
        tax();
        bonus();
        raiseSalary();
    }

    void tax() {
        if (this.salary > 1000) {
            this.tax = salary * 0.03;
        }
    }

    void bonus() {
        if (this.workHours > 40) {
            this.bonus = (this.workHours - 40) * 30 * 4;
        }
    }

    void raiseSalary() {
        if (this.hireYear > 1980) {
            int workingYear = 2021 - this.hireYear;
            if ((workingYear) < 10) {
                this.increase = this.salary * 0.05;
            } else if (workingYear < 20) {
                this.increase = this.salary * 0.1;
            } else {
                this.increase = this.salary * 0.15;
            }
        }
    }

    void listingParameters() {
        double total = this.salary + this.bonus + this.increase - this.tax;
        System.out.println("==============================" + "\n" +
                "Adı : " + this.name + "\n" +
                "Maaşı (aylık) : " + this.salary + " TL" + "\n" +
                "Aylık Çalışma Saati : " + (this.workHours * 4) + " saat" + "\n" +
                "İşe Başlama Yılı : " + this.hireYear + "\n" +
                "Vergi : " + this.tax + " TL" + "\n" +
                "Fazla Çalışma (aylık) : " + this.bonus + " TL" + "\n" +
                "Kıdem Artışı : " + this.increase + " TL" + "\n" +
                "Toplam Alacak (aylık) : " + total + " TL" + "\n" +
                "==============================");
    }
}