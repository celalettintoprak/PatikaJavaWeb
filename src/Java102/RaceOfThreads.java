package Java102;

/*
  Ödev – Threadlerin Yarışı

  1'den 10000 (10 bin)'e kadar sayılardan oluşan bir ArrayList oluşturunuz.
  Ardından bu ArrayList'teki 10 bin elemanı 2500 eleman olacak şekilde
  4 eşit parçaya ayırınız. Bu 4 ayrı 2500 elemanlık ArrayList'ler içinde
  tek ve çift sayıları bulan 4 ayrı Thread tasarlayınız.

  •4 Thread bulduğu çift sayıları ortak bir ArrayList'e ekleyecektir.
  •4 Thread bulduğu tek sayıları ortak bir ArrayList'e ekleyecektir.
  •Tek ve çift sayıları tutan ArrayList'ler ilk oluşturulduklarında
  boş olacaklardır. Ve iki tane ArrayList olacaklardır.
  •4 Thread kendine ait 2500 elemanlık ArrayList'i işlemeye başlayınca
  tek ve çift sayı ArrayList'lerini dolduracaktır.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceOfThreads {
    public static void main(String[] args) {
        List<Integer> mainList = new ArrayList<>(); // 10.000 sayı içeren ilk liste
        List<Integer> oddNumber = new ArrayList<>(); // tek sayı
        List<Integer> evenNumber = new ArrayList<>(); // çift sayı

        addNumbers(mainList);
        System.out.println("Main list size: " + mainList.size());

        List<Integer> list1 = mainList.subList(0, (2500 + 1));
        List<Integer> list2 = mainList.subList(2501, (5000 + 1));
        List<Integer> list3 = mainList.subList(5001, (7500 + 1));
        List<Integer> list4 = mainList.subList(7051, mainList.size());

        Runnable r1 = () -> control(list1, oddNumber, evenNumber);
        Runnable r2 = () -> control(list2, oddNumber, evenNumber);
        Runnable r3 = () -> control(list3, oddNumber, evenNumber);
        Runnable r4 = () -> control(list4, oddNumber, evenNumber);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static void addNumbers(List<Integer> list) {
        for (int i = 1; i <= 10000; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
    }

    public static void control(List<Integer> list, List<Integer> odd, List<Integer> even) {
        for (int i : list) {
            if (i % 2 == 0) {
                even.add(i);
                System.out.println(Thread.currentThread().getName() + " " + i + " çift sayılara eklendi");
            } else {
                odd.add(i);
                System.out.println(Thread.currentThread().getName() + " " + i + " tek sayılara eklendi");
            }
        }
    }
}