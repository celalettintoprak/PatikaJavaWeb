package Java102.TurizmAcente.vo;

import Java102.TurizmAcente.dao.HotelDao;
import Java102.TurizmAcente.dao.RoomDao;

import java.sql.Date;
import java.util.Arrays;
import java.util.TreeSet;

public class BookingVO{
    private int id, roomId, aNumber, cNumber, hotelTypeId, hotelId;
    private Date startDate, endDate;
    private double cost;
    private String name, email, tel, notes;
    private TreeSet<String[]> visitors;
    private RoomVO roomVO;
    private HotelVO hotelVO;

    public BookingVO(int id, int roomId, Date startDate, Date endDate, int aNumber, int cNumber, int hotelTypeId, int hotelId,
                     String name, String email, String tel, String notes, TreeSet<String[]> visitors) {
        this.id = id;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.aNumber = aNumber;
        this.cNumber = cNumber;
        this.hotelTypeId = hotelTypeId;
        this.hotelId = hotelId;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.notes = notes;
        this.visitors = visitors;
        this.roomVO = new RoomDao().get(roomId);
        this.hotelVO = new HotelDao().get(hotelId);
        calculateCost();
    }

    private double hotelTypeMultiplier(TreeSet<HotelTypeVO> list, int id) {
        for (HotelTypeVO hotelTypeVO : list) {
            if (id == hotelTypeVO.getId()) {
                return hotelTypeVO.getMultiplier();
            }
        }
        return 0;
    }

    private void calculateCost() {
        double hotelTypeMultiplier = hotelTypeMultiplier(this.hotelVO.getHotelTypeVOTreeSet(), this.hotelTypeId);
        double roomTypeMultiplier = this.roomVO.getRoomTypeVO().getMultiplier();
        this.cost = this.hotelVO.getPrice() * hotelTypeMultiplier * roomTypeMultiplier;
    }

    public void getInfo() {
        System.out.println("---------------------------------------------------------------------------" + "\n" +
                "ID: " + "\t\t\t" + this.getId() + "\n" +
                "ROOM_ID: " + "\t\t" + this.getRoomId() + "\n" +
                "START_DATE: " + "\t" + this.getStartDate().toString() + "\n" +
                "END_DATE: " + "\t\t" + this.getEndDate().toString() + "\n" +
                "ADULT NUMBER: " + "\t" + this.getaNumber() + "\n" +
                "CHILD NUMBER: " + "\t" + this.getcNumber() + "\n" +
                "HOTEL_TYPE_ID: " + "\t" + this.getHotelTypeId() + "\n" +
                "HOTEL_ID: " + "\t\t" + this.getHotelId() + "\n\n" +
                "NAME: " + "\t\t" + this.getName() + "\n" +
                "EMAIL: " + "\t\t" + this.getEmail() + "\n" +
                "TEL: " + "\t\t\t" + this.getTel() + "\n" +
                "NOTES: " + "\t\t" + this.getNotes() + "\n\n" +
                "VISITORS: " + "\t\t" + Arrays.toString(Arrays.stream(getVisitorNames()).toArray()) + "\n" +
                "---------------------------------------------------------------------------");
    }

    public String[] getVisitorNames() {
        String[] result = new String[visitors.size()];
        int counter = 0;
        for (String[] visitor : visitors) {
            result[counter] = visitor[0];
            counter++;
        }
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getaNumber() {
        return aNumber;
    }

    public void setaNumber(int aNumber) {
        this.aNumber = aNumber;
    }

    public int getcNumber() {
        return cNumber;
    }

    public void setcNumber(int cNumber) {
        this.cNumber = cNumber;
    }

    public int getHotelTypeId() {
        return hotelTypeId;
    }

    public void setHotelTypeId(int hotelTypeId) {
        this.hotelTypeId = hotelTypeId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public RoomVO getRoomVO() {
        return roomVO;
    }

    public void setRoomVO(RoomVO roomVO) {
        this.roomVO = roomVO;
    }

    public HotelVO getHotelVO() {
        return hotelVO;
    }

    public void setHotelVO(HotelVO hotelVO) {
        this.hotelVO = hotelVO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public TreeSet<String[]> getVisitors() {
        return visitors;
    }

    public void setVisitors(TreeSet<String[]> visitors) {
        this.visitors = visitors;
    }
}
