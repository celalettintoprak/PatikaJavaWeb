package Java102.PatikaStore;

import Java102.PatikaStore.entities.Brand;

import java.util.Comparator;

public class BrandComparator implements Comparator<Brand> {
    @Override
    public int compare(Brand o1, Brand o2) {
        return o1.getId() - o2.getId();
    }
}
