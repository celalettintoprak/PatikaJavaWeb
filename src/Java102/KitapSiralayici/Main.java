package Java102.KitapSiralayici;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book(1, "Book1", 190, "A1", "2001");
        Book b2 = new Book(2, "Book2", 110, "A2", "2005");
        Book b3 = new Book(3, "Book3", 100, "A3", "1998");
        Book b4 = new Book(4, "Book4", 160, "A4", "2018");
        Book b5 = new Book(5, "Book5", 90, "A5", "1980");

        TreeSet<Book> booksName = new TreeSet<>(new NameComparator());
        TreeSet<Book> booksPage = new TreeSet<>(new PageComparator());

        booksName.add(b5);
        booksName.add(b2);
        booksName.add(b1);
        booksName.add(b4);
        booksName.add(b3);

        booksPage.add(b1);
        booksPage.add(b2);
        booksPage.add(b3);
        booksPage.add(b4);
        booksPage.add(b5);

        System.out.println("Book List sorted by Name:");
        for (Book book : booksName) {
            System.out.print(book.getName() + ", ");
        }

        System.out.println("\n\n" + "Book List sorted by Page:");
        for (Book book : booksPage) {
            System.out.print(book.getName() + ", ");
        }
    }
}

class NameComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        return b1.getName().compareTo(b2.getName());
    }
}

class PageComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        return b1.getPage() - b2.getPage();
    }
}

class Book{
    private int id, page;
    private String name, author, publication;

    public Book(int id, String name, int page, String author, String publication) {
        this.id = id;
        this.name = name;
        this.page = page;
        this.author = author;
        this.publication = publication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }
}