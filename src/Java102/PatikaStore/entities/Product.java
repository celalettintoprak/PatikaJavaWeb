package Java102.PatikaStore.entities;

public class Product extends Entity {
    private static int count = 0;
    private final int id;
    private int stock, discount, memory, storage, battery;
    private String color;
    private double price, screen;
    private Category category;
    private Brand brand;

    public Product(String name, Category category, Brand brand, int stock,
                   int discount, int memory, int storage, int battery,
                   String color, double price, double screen) {
        super(name);
        this.id = ++count;
        this.category = category;
        this.brand = brand;
        this.stock = stock;
        this.discount = discount;
        this.memory = memory;
        this.storage = storage;
        this.battery = battery;
        this.color = color;
        this.price = price;
        this.screen = screen;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScreen() {
        return screen;
    }

    public void setScreen(double screen) {
        this.screen = screen;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}