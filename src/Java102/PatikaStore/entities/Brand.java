package Java102.PatikaStore.entities;

public class Brand extends Entity {
    private static int count = 0;
    private final int id;

    public Brand(String name) {
        super(name);
        this.id = ++count;
    }

    public int getId() {
        return id;
    }
}