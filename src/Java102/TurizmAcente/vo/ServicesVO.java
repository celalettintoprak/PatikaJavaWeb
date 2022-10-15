package Java102.TurizmAcente.vo;

public class ServicesVO extends TurizmEntity {
    private String name2;

    public ServicesVO(int id, String name, String name2) {
        super(id, name);
        this.name2 = name2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
