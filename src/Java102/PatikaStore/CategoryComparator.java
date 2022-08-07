package Java102.PatikaStore;

import Java102.PatikaStore.entities.Category;

import java.util.Comparator;

public class CategoryComparator implements Comparator<Category> {
    @Override
    public int compare(Category o1, Category o2) {
        return o1.getId() - o2.getId();
    }
}