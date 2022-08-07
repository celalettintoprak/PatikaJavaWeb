package Java102.PatikaStore.entities;

public class Category extends Entity {
    private static int count = 0;
    private final int id;

    public Category(String name) {
        super(name);
        this.id = ++count;
    }

    public int getId() {
        return id;
    }
}