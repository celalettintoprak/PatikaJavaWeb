package Java102.PatikaStore.entities;

import Java102.PatikaStore.BrandComparator;
import Java102.PatikaStore.CategoryComparator;
import Java102.PatikaStore.ProductComparator;
import Java102.PatikaStore.TableGenerator;

import java.util.ArrayList;
import java.util.List;

public class PatikaStore {
    private List<Category> categoryList = new ArrayList<>();
    private List<Brand> brandList = new ArrayList<>();
    private List<Product> productList = new ArrayList<>();
    private List<String> headerCategories = new ArrayList<>();
    private List<String> headerBrands = new ArrayList<>();
    private List<String> headerProducts = new ArrayList<>();

    Category cNotebook, cSmartphone;
    Brand bApple, bHuawei, bMonster, bSamsung, bXiaomi;

    public PatikaStore() {
        generateCategory();
        generateBrands();
        generateProducts();
        generateHeaders();
    }

    public void addCategory(Category category) {
        this.categoryList.add(category);
        categoryList.sort(new CategoryComparator());
    }

    public void addBrand(Brand brand) {
        this.brandList.add(brand);
        brandList.sort(new BrandComparator());
    }

    public void addProduct(Product product) {
        this.productList.add(product);
        productList.sort(new ProductComparator());
    }

    public boolean removeProduct(int id) {
        for (Product product : getProductList()) {
            if (product.getId() == id) {
                productList.remove(product);
                return true;
            }
        }
        return false;
    }

    public void generateCategory() {
        addCategory(new Category("Notebook"));
        addCategory(new Category("Smartphone"));

        cNotebook = getCategoryList().get(0);
        cSmartphone = getCategoryList().get(1);
    }

    public void generateBrands() {
        addBrand(new Brand("Samsung"));
        addBrand(new Brand("Lenovo"));
        addBrand(new Brand("Apple"));
        addBrand(new Brand("Huawei"));
        addBrand(new Brand("Casper"));
        addBrand(new Brand("Asus"));
        addBrand(new Brand("HP"));
        addBrand(new Brand("Xiaomi"));
        addBrand(new Brand("Monster"));

        bApple = getBrandList().get(2);
        bHuawei = getBrandList().get(3);
        bMonster = getBrandList().get(8);
        bSamsung = getBrandList().get(0);
        bXiaomi = getBrandList().get(7);
    }

    public void generateProducts() {
        // add Notebooks
        addProduct(new Product("Matebook 14", cNotebook, bHuawei, 2, 10,
                16, 512, 10000, "Gri", 7000, 14));
        addProduct(new Product("Macbook Pro 16", cNotebook, bApple, 4, 5,
                16, 512, 20000, "Beyaz", 12000, 16));
        addProduct(new Product("Abra A5", cNotebook, bMonster, 8, 15,
                32, 1024, 13000, "Siyah", 9000, 15.6));

        // add Smartphones
        addProduct(new Product("iPhone 8+", cSmartphone, bApple, 12, 8,
                16, 128, 5000, "Gold", 10000, 6.2));
        addProduct(new Product("Galaxy 10", cSmartphone, bSamsung, 21, 20,
                8, 64, 4000, "Mavi", 4500, 7.1));
        addProduct(new Product("Redmi Note 10 Pro", cSmartphone, bXiaomi, 21, 25,
                12, 128, 4000, "Beyaz", 3800, 6.5));
    }

    public void generateHeaders() {
        headerCategories.add("ID");
        headerCategories.add("CATEGORY NAME");

        headerBrands.add("ID");
        headerBrands.add("BRAND NAME");

        headerProducts.add("ID");
        headerProducts.add("PRODUCT NAME");
        headerProducts.add("CATEGORY");
        headerProducts.add("BRAND");
        headerProducts.add("MEMORY");
        headerProducts.add("STORAGE");
        headerProducts.add("BATTERY");
        headerProducts.add("COLOR");
        headerProducts.add("PRICE");
        headerProducts.add("SCREEN");
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<String> getHeaderCategories() {
        return headerCategories;
    }

    public List<String> getHeaderBrands() {
        return headerBrands;
    }

    public List<String> getHeaderProducts() {
        return headerProducts;
    }
}
