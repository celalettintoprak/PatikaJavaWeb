package Java102.PatikaStore;

import Java102.PatikaStore.entities.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getId() - o2.getId();
    }
}