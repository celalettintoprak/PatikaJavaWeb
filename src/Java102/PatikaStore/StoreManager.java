package Java102.PatikaStore;

import Java102.PatikaStore.entities.Brand;
import Java102.PatikaStore.entities.Category;
import Java102.PatikaStore.entities.PatikaStore;
import Java102.PatikaStore.entities.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StoreManager {
    PatikaStore patikaStore = new PatikaStore();
    TableGenerator tableGenerator = new TableGenerator();
    private final Scanner scanner = new Scanner(System.in);

    public void listMenu() {
        System.out.println("PatikaStore Ürün Yönetim Paneli !" + "\n" +
                "1 - Ürün İşlemleri" + "\n" +
                "2 - Ürünleri Listele" + "\n" +
                "3 - Marka Listele" + "\n" +
                "0 - Çıkış Yap" + "\n" +
                "==============================");
    }

    public void listIslemler() {
        System.out.println("Ürün İşlemleri !" + "\n" +
                "1 - Ürün Ekleme" + "\n" +
                "2 - Ürün Silme" + "\n" +
                "3 - Ürün Filtrele" + "\n" +
                "0 - Ana Menü" + "\n" +
                "==============================");
    }

    public boolean selectMenu() {
        boolean isExit = false;
        this.listMenu();
        System.out.print("Seçiminiz: ");
        char selected1 = scanner.next().charAt(0);
        switch (selected1) {
            case '1':
                boolean isMain = false;
                while (!isMain) {
                    this.listIslemler();
                    System.out.print("Seçiminiz: ");
                    char selected2 = scanner.next().charAt(0);
                    switch (selected2) {
                        case '1':
                            patikaStore.addProduct(urunEkle());
                            break;
                        case '2':
                            try {
                                listProducts();
                                System.out.print("Seçiminiz: ");
                                int id = scanner.nextInt();
                                if (patikaStore.removeProduct(id)) {
                                    System.out.println(id + " id nolu ürün başarılı bir şekilde kaldırıldı.");
                                } else {
                                    System.out.println("Geçersiz id !");
                                }
                            } catch (InputMismatchException ex) {
                                System.out.println("Geçerli bir sayı girmediniz.");
                                scanner.nextLine();
                            }
                            break;
                        case '3':
                            System.out.print("Marka Giriniz: ");
                            scanner.nextLine();
                            String selected3 = scanner.next().trim();
                            filterProducts(selected3);
                            break;
                        case '0':
                            isMain = true;
                            break;
                        default:
                            System.out.println("Geçersiz İşlem !");
                    }
                }
                break;
            case '2':
                listProducts();
                break;
            case '3':
                listBrands();
                break;
            case '0':
                isExit = true;
                break;
        }
        return isExit;
    }

    public void listCategories() {
        if (patikaStore.getCategoryList().size() == 0) {
            System.out.println("Listelenecek kategori bulunmamaktadır.");
        } else {
            List<List<String>> rowsList = new ArrayList<>();
            for (Category category : patikaStore.getCategoryList()) {
                List<String> row = new ArrayList<>();
                row.add(String.valueOf(category.getId()));
                row.add(category.getName());
                rowsList.add(row);
            }
            System.out.println(tableGenerator.generateTable(patikaStore.getHeaderCategories(), rowsList));

            /*
            System.out.println("Kategoriler:" + "\n" + "---------------");
            for (Category category : patikaStore.getCategoryList()) {
                System.out.println("- ID: " + category.getId() +
                        " | NAME: " + category.getName());
            }
            System.out.println("---------------");
             */
        }
    }

    public void listBrands() {
        if (patikaStore.getBrandList().size() == 0) {
            System.out.println("Listelenecek marka bulunmamaktadır.");
        } else {
            List<List<String>> rowsList = new ArrayList<>();
            for (Brand brand : patikaStore.getBrandList()) {
                List<String> row = new ArrayList<>();
                row.add(String.valueOf(brand.getId()));
                row.add(brand.getName());
                rowsList.add(row);
            }
            System.out.println(tableGenerator.generateTable(patikaStore.getHeaderBrands(), rowsList));

            /*
            System.out.println("Markalar:" + "\n" + "---------------");
            for (Brand brand : patikaStore.getBrandList()) {
                System.out.println("- ID: " + brand.getId() +
                        " | NAME: " + brand.getName());
            }
            System.out.println("---------------");
             */
        }
    }

    public void listProducts() {
        if (patikaStore.getProductList().size() == 0) {
            System.out.println("Listelenecek ürün bulunmamaktadır.");
        } else {
            List<List<String>> rowsList = new ArrayList<>();
            for (Product product : patikaStore.getProductList()) {
                List<String> row = new ArrayList<>();
                row.add(String.valueOf(product.getId()));
                row.add(product.getName());
                row.add(product.getCategory().getName());
                row.add(product.getBrand().getName());
                row.add(String.valueOf(product.getMemory()));
                row.add(String.valueOf(product.getStorage()));
                row.add(String.valueOf(product.getBattery()));
                row.add(product.getColor());
                row.add(String.valueOf(product.getPrice()));
                row.add(String.valueOf(product.getScreen()));
                rowsList.add(row);
            }
            System.out.println(tableGenerator.generateTable(patikaStore.getHeaderProducts(), rowsList));

            /*
            System.out.println("Ürünler:" + "\n" + "---------------");
            for (Product product : patikaStore.getProductList()) {
                System.out.println("- " + "Id: " + product.getId() + " | " +
                        "Name: " + product.getName() + " | " +
                        "Category: " + product.getCategory().getName() + " | " +
                        "Brand: " + product.getBrand().getName() + " | " +
                        "Memory: " + product.getMemory() + " GB" + " | " +
                        "Storage: " + product.getStorage() + " GB" + " | " +
                        "Battery: " + product.getBattery() + " mAh" + " | " +
                        "Color: " + product.getColor() + " | " +
                        "Price: " + product.getPrice() + " TL" + " | " +
                        "Screen: " + product.getScreen() + " inch");
            }
            System.out.println("---------------");
             */
        }
    }

    public void filterProducts(String value) {
        List<Product> searchList = new ArrayList<>();
        for (Product product : patikaStore.getProductList()) {
            if (product.getBrand().getName().equals(value)) {
                searchList.add(product);
            }
        }
        if (searchList.size() == 0) {
            System.out.println("Listelenecek ürün bulunmamaktadır.");
        } else {
            List<List<String>> rowsList = new ArrayList<>();
            for (Product product : searchList) {
                List<String> row = new ArrayList<>();
                row.add(String.valueOf(product.getId()));
                row.add(product.getName());
                row.add(product.getCategory().getName());
                row.add(product.getBrand().getName());
                row.add(String.valueOf(product.getMemory()));
                row.add(String.valueOf(product.getStorage()));
                row.add(String.valueOf(product.getBattery()));
                row.add(product.getColor());
                row.add(String.valueOf(product.getPrice()));
                row.add(String.valueOf(product.getScreen()));
                rowsList.add(row);
            }
            System.out.println(tableGenerator.generateTable(patikaStore.getHeaderProducts(), rowsList));

            /*
            System.out.println(value + " Marka Ürünler:" + "\n" + "---------------");
            for (Product product : searchList) {
                System.out.println("- " + "Id: " + product.getId() + " | " +
                        "Name: " + product.getName() + " | " +
                        "Category: " + product.getCategory().getName() + " | " +
                        "Brand: " + product.getBrand().getName() + " | " +
                        "Memory: " + product.getMemory() + " GB" + " | " +
                        "Storage: " + product.getStorage() + " GB" + " | " +
                        "Battery: " + product.getBattery() + " mAh" + " | " +
                        "Color: " + product.getColor() + " | " +
                        "Price: " + product.getPrice() + " TL" + " | " +
                        "Screen: " + product.getScreen() + " inch");
            }
            System.out.println("---------------");
             */
        }
    }

    public Product urunEkle() {
        System.out.println("*** Ürün Parametrelerini Giriniz ***");
        System.out.print("Ürün Adı: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        Category category = null;
        boolean selectedCategory = false;
        while (!selectedCategory) {
            listCategories();
            System.out.print("Kategori id seçiniz: ");
            int categoryId = scanner.nextInt();
            for (Category tempCategory : patikaStore.getCategoryList()) {
                if (tempCategory.getId() == categoryId) {
                    category = tempCategory;
                    selectedCategory = true;
                    break;
                }
            }
            if (category == null) {
                System.out.println("Geçersiz değer");
            }
        }
        Brand brand = null;
        boolean selectedBrand = false;
        while (!selectedBrand) {
            listBrands();
            System.out.print("Marka id seçiniz: ");
            int brandId = scanner.nextInt();
            for (Brand tempBrand : patikaStore.getBrandList()) {
                if (tempBrand.getId() == brandId) {
                    brand = tempBrand;
                    selectedBrand = true;
                    break;
                }
            }
            if (brand == null) {
                System.out.println("Geçersiz değer");
            }
        }
        System.out.print("Stok Miktarı: ");
        int stock = scanner.nextInt();
        System.out.print("İndirim Oranı: ");
        int discount = scanner.nextInt();
        System.out.print("RAM: ");
        int memory = scanner.nextInt();
        System.out.print("Bellek: ");
        int storage = scanner.nextInt();
        System.out.print("Batarya: ");
        int battery = scanner.nextInt();
        System.out.print("Renk: ");
        scanner.nextLine();
        String color = scanner.nextLine();
        System.out.print("Fiyat: ");
        double price = scanner.nextDouble();
        System.out.print("Ekran Boyutu: ");
        double screen = scanner.nextDouble();
        return new Product(name, category, brand, stock, discount,
                memory, storage, battery, color, price, screen);
    }
}