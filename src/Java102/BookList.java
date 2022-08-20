package Java102;

/*
  Ödev - Kitap Listesi

  Book sınıfı kitap ismi, sayfa sayısı, yazarın ismi, yayın tarihi değişkenlerinden oluşmaktadır.

  •Book sınıfından 10 tane nesne üretip bunu bir ArrayList yapısında saklayınız.
  stream yapısını ve lambda ifadelerini kullanarak kitap isminin karşısında yazar ismi
  olacak şekilde yeni bir Map<String, String> oluşturacak şekilde yazınız.

  •Bu 10 elemanlık Book listesinden sayfa sayısı 100'den fazla olan kitapları filtreleyen ve
  yeni bir liste olarak verecek geliştirmeyi yapınız. (Stream ve Lambda ifadeleri kullanabilirsiniz.)

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookList {
    public static void main(String[] args) {
        Book book1 = new Book("BookA", "AuthorA", "01.01.2000", 269);
        Book book2 = new Book("BookB", "AuthorB", "01.01.2001", 69);
        Book book3 = new Book("BookC", "AuthorC", "01.01.2002", 469);
        Book book4 = new Book("BookD", "AuthorD", "01.01.2003", 2169);
        Book book5 = new Book("BookE", "AuthorE", "01.01.2004", 769);
        Book book6 = new Book("BookF", "AuthorF", "01.01.2005", 99);
        Book book7 = new Book("BookG", "AuthorG", "01.01.2006", 26);
        Book book8 = new Book("BookH", "AuthorH", "01.01.2007", 124);
        Book book9 = new Book("BookI", "AuthorI", "01.01.2008", 88);
        Book book10 = new Book("BookJ", "AuthorJ", "01.01.2009", 82);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        Map<String, String> bookList = new HashMap<>();
        books.forEach(p -> bookList.put(p.getName(), p.getAuthor()));

        for (String book : bookList.keySet()) {
            System.out.println("Kitap: " + book + ", Yazar: " + bookList.get(book));
        }

        List<Book> newList = books.stream().filter(p -> p.getPage() > 100).toList();
        System.out.println("\n" + "Sayfa sayısı 100'den fazla olan kitaplar: ");
        for (Book book : newList) {
            System.out.println("Kitap Adı: " + book.getName() + " | " +
                    "Sayfa Sayısı: " + book.getPage() + " | " +
                    "Yazar: " + book.getAuthor() + " | " +
                    "Yayın Tarihi: " + book.getRelease());
        }
    }
}

class Book {
    private final String name, author, release;
    private final int page;

    public Book(String name, String author, String release, int page) {
        this.name = name;
        this.author = author;
        this.release = release;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getRelease() {
        return release;
    }

    public int getPage() {
        return page;
    }
}