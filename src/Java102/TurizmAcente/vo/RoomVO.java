package Java102.TurizmAcente.vo;

import java.util.Arrays;
import java.util.TreeSet;

public class RoomVO extends TurizmEntity {
    private RoomTypeVO roomTypeVO;
    private int bedAmount;
    private TreeSet<RoomPropertiesVO> roomPropertiesVOTreeSet;
    private HotelVO hotelVO;
    private double area;

    public RoomVO(int id, String name, RoomTypeVO roomTypeVO, int bedAmount,
                  TreeSet<RoomPropertiesVO> roomPropertiesVOTreeSet, HotelVO hotelVO, double area) {
        super(id ,name);
        this.roomTypeVO = roomTypeVO;
        this.bedAmount = bedAmount;
        this.roomPropertiesVOTreeSet = roomPropertiesVOTreeSet;
        this.hotelVO = hotelVO;
        this.area = area;
    }

    public void getInfo() {
        System.out.println("---------------------------------------------------------------------------" + "\n" +
                "ID: " + "\t\t\t" + this.getId() + "\n" +
                "NAME: " + "\t\t\t" + this.getName() + "\n" +
                "ROOM_TYPE: " + "\t\t" + this.getRoomTypeVO().getName() + "\n" +
                "BED_AMOUNT: " + "\t" + this.getBedAmount() + "\n" +
                "PROPERTIES: " + "\t" + Arrays.toString(Arrays.stream(getRoomPropertiesNames()).toArray()) + "\n" +
                "HOTEL_ID: " + "\t\t" + this.getHotelVO().getId() + "\n" +
                "HOTEL_NAME: " + "\t\t" + this.getHotelVO().getName() + "\n" +
                "AREA: " + "\t\t\t" + this.getArea() + "\n" +
                "---------------------------------------------------------------------------");
    }

    public String[] getRoomPropertiesNames() {
        String[] result = new String[roomPropertiesVOTreeSet.size()];
        int counter = 0;
        for (RoomPropertiesVO RoomPropertiesVO : roomPropertiesVOTreeSet) {
            result[counter] = RoomPropertiesVO.getName();
            counter++;
        }
        return result;
    }

    public RoomTypeVO getRoomTypeVO() {
        return roomTypeVO;
    }

    public void setRoomTypeVO(RoomTypeVO roomTypeVO) {
        this.roomTypeVO = roomTypeVO;
    }

    public int getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(int bedAmount) {
        this.bedAmount = bedAmount;
    }

    public TreeSet<RoomPropertiesVO> getRoomPropertiesVOTreeSet() {
        return roomPropertiesVOTreeSet;
    }

    public void setRoomPropertiesVOTreeSet(TreeSet<RoomPropertiesVO> roomPropertiesVOTreeSet) {
        this.roomPropertiesVOTreeSet = roomPropertiesVOTreeSet;
    }

    public HotelVO getHotelVO() {
        return hotelVO;
    }

    public void setHotelVO(HotelVO hotelVO) {
        this.hotelVO = hotelVO;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
