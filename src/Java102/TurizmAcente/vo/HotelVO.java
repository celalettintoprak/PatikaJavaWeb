package Java102.TurizmAcente.vo;

import java.util.Arrays;
import java.util.TreeSet;

public class HotelVO extends TurizmEntity {
    private String address, email, tel;
    private int stars;
    private TownVO townVO;
    private TreeSet<ServicesVO> servicesVOTreeSet;
    private TreeSet<HotelTypeVO> hotelTypeVOTreeSet;
    private double price;

    public HotelVO(int id, String name, String address, String email, String tel,
                   int stars, TownVO townVO, TreeSet<ServicesVO> servicesVOTreeSet,
                   TreeSet<HotelTypeVO> hotelTypeVOTreeSet, double price) {
        super(id, name);
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.stars = stars;
        this.townVO = townVO;
        this.servicesVOTreeSet = servicesVOTreeSet;
        this.hotelTypeVOTreeSet = hotelTypeVOTreeSet;
        this.price = price;
    }

    public void getInfo() {
        System.out.println("---------------------------------------------------------------------------" + "\n" +
                "ID: " + "\t\t\t" + this.getId() + "\n" +
                "NAME: " + "\t\t\t" + this.getName() + "\n" +
                "ADDRESS: " + "\t\t" + this.getAddress() + "\n" +
                "EMAIL: " + "\t\t\t" + this.getEmail() + "\n" +
                "TEL: " + "\t\t\t" + this.getTel() + "\n" +
                "STARS: " + "\t\t\t" + this.getStars() + "\n" +
                "TOWN_ID: " + "\t\t" + this.getTownVO().getId() + "\n" +
                "TOWN_NAME: " + "\t\t" + this.getTownVO().getName() + "\n" +
                "CITY_ID: " + "\t\t" + this.getTownVO().getCityVO().getId() + "\n" +
                "CITY_NAME: " + "\t\t" + this.getTownVO().getCityVO().getName() + "\n" +
                "SERVICES: " + "\t\t" + Arrays.toString(Arrays.stream(getServicesNames()).toArray()) + "\n" +
                "HOTEL_TYPE: " + "\t" + Arrays.toString(Arrays.stream(getHotelTypeNames()).toArray()) + "\n" +
                "PRICE: " + "\t\t\t" + this.getPrice() + "\n" +
                "---------------------------------------------------------------------------");
    }

    public String[] getServicesNames() {
        String[] result = new String[servicesVOTreeSet.size()];
        int counter = 0;
        for (ServicesVO servicesVO : servicesVOTreeSet) {
            result[counter] = servicesVO.getName();
            counter++;
        }
        return result;
    }

    public String[] getHotelTypeNames() {
        String[] result = new String[hotelTypeVOTreeSet.size()];
        int counter = 0;
        for (HotelTypeVO hotelTypeVO : hotelTypeVOTreeSet) {
            result[counter] = hotelTypeVO.getName();
            counter++;
        }
        return result;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public TownVO getTownVO() {
        return townVO;
    }

    public void setTownVO(TownVO townVO) {
        this.townVO = townVO;
    }

    public TreeSet<ServicesVO> getServicesVOTreeSet() {
        return servicesVOTreeSet;
    }

    public void setServicesVOTreeSet(TreeSet<ServicesVO> servicesVOTreeSet) {
        this.servicesVOTreeSet = servicesVOTreeSet;
    }

    public TreeSet<HotelTypeVO> getHotelTypeVOTreeSet() {
        return hotelTypeVOTreeSet;
    }

    public void setHotelTypeVOTreeSet(TreeSet<HotelTypeVO> hotelTypeVOTreeSet) {
        this.hotelTypeVOTreeSet = hotelTypeVOTreeSet;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

