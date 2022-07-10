//  Patika.dev Java 101 Ödev 50

/*
  Java dilinde Mayın Tarlası oyunu yapmanızı bekliyoruz.

  Oyun Kuralları :
  - Oyun metin tabanlıdır.
  - Çift boyutlu diziler üzerinden oynanmalı ve MineSweeper sınıfı içerisinde tasarlanmalı.
  - Matris boyutunu yani satır ve sütun sayısını kullanıcı belirlemeli.
  - Diziye ait eleman sayısının çeyreği (elemanSayisi / 4) kadar rastgele mayın yerleştirilmeli.
    Örneğin dizi 4x3 boyutunda ise eleman sayısı (satırSayısı * sütunSayısı) formülü ile
    hesaplanmalı ve boyutu 12 olmalı. Bu durumda mayın sayısı 12 / 4 = 3 adet olmalıdır.
    (ipucu : bu mayınların konumlarını tutacak ikinci bir dizi oluşturabilirsiniz.)
  - Kullanıcı matris üzerinden bir nokta seçmeli. Bunun için satır ve sütun değerleri girmeli.
  - Seçilen noktanın dizinin sınırları içerisinde olup olmadığını kontrol edilmeli ve
    koşul sağlanmazsa tekrar nokta istenmeli.
  - Kullanıcının girdiği noktada mayın var ise oyunu kaybetmeli.
  - Mayın yok ise, ilgili noktaya değen tüm konumlarına bakılmalı
    (sağı, solu, üstü, altı, sol üst çapraz, sağ üst çapraz, sağ alt çapraz, sol alt çapraz)
    ve etrafındaki mayınların sayısının toplamı ilgili noktaya yazılmalı.
    Noktaya değen herhangi bir mayın yok ise "0" değeri atanmalı.
  - Kullanıcı hiç bir mayına basmadan tüm noktaları seçebilirse oyunu kazanmalı.
*/

import java.util.*;

public class Odev50 {
    public static void main(String[] args) {
        System.out.println("*** MAYIN TARLASI OYUNUNA HOŞGELDİNİZ. ***");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Satır sayısı: ");
        int row = scanner.nextInt();
        System.out.print("Sütun sayısı: ");
        int column = scanner.nextInt();

        MineSweeper mineSweeper = new MineSweeper(row, column);
        // System.out.println(mineSweeper.mineLocations); // test code
        mineSweeper.controlMine();
    }
}

class MineSweeper {
    int row, column, length, mines, placedMine = 0;
    String[][] table, tempTable;
    List<String> mineLocations = new ArrayList<>();

    public MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.table = new String[row][column];
        this.tempTable = new String[row][column];
        this.length = this.row * this.column;
        this.mines = this.length / 4;
        minePlacer();
    }

    void tableFiller(String[][] table) {
        for (String[] i : table) {
            Arrays.fill(i, "-");
        }
    }

    void minePlacer() {
        Random random = new Random();
        tableFiller(this.table);
        tableFiller(this.tempTable);

        while (this.placedMine != this.mines) {
            int i = random.nextInt(this.row);
            int j = random.nextInt(this.column);
            // System.out.print("[" + i + "][" + j + "]"); // test code

            if (this.table[i][j].equals("-")) {
                this.table[i][j] = "*";
                this.mineLocations.add(i + "-" + j);
                this.placedMine++;
                // System.out.print(" koordinatına mayın yerleştirildi!"); // test code
            } else {
                // System.out.print(" tekrar eden koordinat!"); // test code
            }
            // System.out.println(); // test code
        }
        Collections.sort(mineLocations);
        // System.out.println(mineLocations); // test code
    }

    void openAll(String[][] table) {
        for (int i = 0; i < this.row; i++){
            for (int j = 0; j < this.column; j++) {
                System.out.print(" " + table[i][j] + " ");
            }
            System.out.println();
        }
    }

    void controlMine() {
        Scanner scanner = new Scanner(System.in);
        boolean mineFound = false;
        int openedArea = 0;
        System.out.println("====================");

        while (!mineFound) {
            if (openedArea == this.length - this.mines) {
                System.out.println("TEBRİKLER KAZANDINIZ !!!");
                openAll(this.table);
                break;
            }
            openAll(tempTable);
            System.out.print("x değeri: ");
            int x = scanner.nextInt();
            System.out.print("y değeri: ");
            int y = scanner.nextInt();

            System.out.println("====================");
            if (x >= 0 && y >= 0 && x < row && y < column) {
                String value = x + "-" + y;
                for (String s : this.mineLocations) {
                    if (s.equals(value)) {
                        System.out.println("MAYINA BASTINIZ, KAYBETTİNİZ !!!");
                        this.table[x][y] = "X";
                        this.tempTable[x][y] = "X";
                        mineFound = true;
                        openAll(this.table);
                    }
                }
                if (!mineFound && this.table[x][y].equals("-")) {
                    countMines(x, y);
                    openedArea++;
                }
            } else {
                System.out.println("Geçersiz koordinat !");
            }
        }
    }

    void countMines(int x, int y) {
        int countMine = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    if (i == 1 && j == 1) {
                        continue;
                    } else if (this.table[i + x -1][j + y - 1].equals("*")) {
                        countMine += 1;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        this.table[x][y] = String.valueOf(countMine);
        this.tempTable[x][y] = String.valueOf(countMine);
    }
}