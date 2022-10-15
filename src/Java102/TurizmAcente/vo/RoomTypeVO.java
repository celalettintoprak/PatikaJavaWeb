package Java102.TurizmAcente.vo;

public class RoomTypeVO extends TurizmEntity {
    private double multiplier;

    public RoomTypeVO(int id, String name, double multiplier) {
        super(id, name);
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}
