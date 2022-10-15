package Java102.TurizmAcente.vo;

public class HotelTypeVO extends TurizmEntity {
    private String name2;
    private double multiplier;

    public HotelTypeVO(int id, String name, String name2, double multiplier) {
        super(id, name);
        this.name2 = name2;
        this.multiplier = multiplier;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}
