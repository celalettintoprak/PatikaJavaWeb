package Java102.TurizmAcente.vo;

public class TownVO extends TurizmEntity {
    private CityVO cityVO;

    public TownVO(int id, String name, CityVO cityVO) {
        super(id, name);
        this.cityVO = cityVO;
    }

    public CityVO getCityVO() {
        return cityVO;
    }

    public void setCityVO(CityVO cityVO) {
        this.cityVO = cityVO;
    }
}
