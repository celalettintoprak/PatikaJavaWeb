package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.DBConnection;
import Java102.TurizmAcente.vo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class RoomDao implements IRoomDao {
    protected DBConnection dbConnection = new DBConnection();
    protected Connection connection = dbConnection.getConnection();
    protected final String TABLE = "ROOM";
    protected final String INSERT = "INSERT INTO " + TABLE + " (ID, NAME, TYPE, " +
            "BED, PROPERTIES, HOTEL, AREA) VALUES (?,?,?,?,?,?,?);";
    protected final String UPDATE = "UPDATE " + TABLE + " SET NAME = ?, TYPE = ?, " +
            "BED = ?, PROPERTIES = ?, HOTEL = ?, AREA = ? WHERE ID = ?;";
    protected final String SELECT = "SELECT ROOM.ID, ROOM.NAME, ROOM.TYPE, ROOM_TYPE.NAME AS ROOM_TYPE, ROOM.BED, " +
            "ROOM.PROPERTIES, HOTEL.ID AS HOTEL_ID, HOTEL.NAME AS HOTEL_NAME, ROOM.AREA FROM " + TABLE + " INNER JOIN ROOM_TYPE " +
            "ON ROOM_TYPE.ID = ROOM.TYPE INNER JOIN HOTEL ON HOTEL.ID = ROOM.HOTEL WHERE ROOM.ID = ?;";
    protected final String SELECT_ALL = "SELECT ROOM.ID, ROOM.NAME, ROOM.TYPE, ROOM_TYPE.NAME AS ROOM_TYPE, ROOM.BED, " +
            "ROOM.PROPERTIES, HOTEL.ID AS HOTEL_ID, HOTEL.NAME AS HOTEL_NAME, ROOM.AREA FROM " + TABLE + " INNER JOIN ROOM_TYPE " +
            "ON ROOM_TYPE.ID = ROOM.TYPE INNER JOIN HOTEL ON HOTEL.ID = ROOM.HOTEL ORDER BY ROOM.ID ASC;";

    private Object[] toIntRoomPropertiesArray(TreeSet<RoomPropertiesVO> list) {
        List<Integer> result = new ArrayList<>();
        for (RoomPropertiesVO roomPropertiesVO : list) {
            result.add(roomPropertiesVO.getId());
        }
        return result.toArray();
    }

    private TreeSet<RoomPropertiesVO> toTreeSetRoomPropertiesVO(Short[] array) {
        TreeSet<RoomPropertiesVO> result = new TreeSet<>(new RoomPropertiesComparator());
        if (array.length != 0) {
            for (int i : array) {
                RoomPropertiesVO roomPropertiesVO = new RoomPropertiesDao().get(i);
                result.add(roomPropertiesVO);
            }
        }
        return result;
    }

    @Override
    public boolean add(RoomVO roomVO) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        Object[] roomPropertiesArray = toIntRoomPropertiesArray(roomVO.getRoomPropertiesVOTreeSet());
        try {
            Array roomProperties = connection.createArrayOf("int", roomPropertiesArray);
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, roomVO.getId());
            preparedStatement.setString(2, roomVO.getName());
            preparedStatement.setInt(3, roomVO.getRoomTypeVO().getId());
            preparedStatement.setInt(4, roomVO.getBedAmount());
            preparedStatement.setArray(5, roomProperties);
            preparedStatement.setInt(6, roomVO.getHotelVO().getId());
            preparedStatement.setDouble(7, roomVO.getArea());
            int result = preparedStatement.executeUpdate();
            // Display the records inserted
            System.out.println(result + " records inserted.");
            connection.commit();
            preparedStatement.close();
            connection.close(); // Close the connection
            return true;
        } catch (SQLException se) {
            return dbConnection.finallyBlock(preparedStatement, dbConnection, se); // call finally block
        }
    }

    @Override
    public boolean update(int id, String name, int roomType, int bedAmount,
                          Object[] roomPropertiesArray, int hotel, double area) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            Array roomProperties = connection.createArrayOf("int", roomPropertiesArray);
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, roomType);
            preparedStatement.setInt(3, bedAmount);
            preparedStatement.setArray(4, roomProperties);
            preparedStatement.setInt(5, hotel);
            preparedStatement.setDouble(6, area);
            preparedStatement.setInt(7, id);
            int result = preparedStatement.executeUpdate();
            // Display the records updated
            System.out.println(result + " records updated.");
            connection.commit();
            preparedStatement.close();
            connection.close(); // Close the connection
            return true;
        } catch (SQLException se) {
            return dbConnection.finallyBlock(preparedStatement, dbConnection, se); // call finally block
        }
    }

    @Override
    public boolean delete(int id) {
        return new Dao().delete(id, this.TABLE, this.dbConnection, this.connection);
    }

    @Override
    public RoomVO get(int id) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        RoomVO roomVO = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                int selectRoomTypeId = rs.getInt("type");
                String selectRoomTypeName = rs.getString("room_type");
                int selectBed = rs.getInt("bed");
                Array selectRoomProperties = rs.getArray("properties");
                int selectHotelId = rs.getInt("hotel_id");
                String selectHotelName = rs.getString("hotel_name");
                double selectArea = rs.getDouble("area");

                Short[] selectRoomPropertiesArray = (Short[]) selectRoomProperties.getArray();
                TreeSet<RoomPropertiesVO> roomPropertiesVOTreeSet = toTreeSetRoomPropertiesVO(selectRoomPropertiesArray);
                RoomTypeVO roomTypeVO = new RoomTypeDao().get(selectRoomTypeId);
                HotelVO hotelVO = new HotelDao().get(selectHotelId);
                roomVO = new RoomVO(selectId, selectName, roomTypeVO, selectBed,
                        roomPropertiesVOTreeSet, hotelVO, selectArea);
                roomVO.getInfo();
            }
            // Display the records listed
            System.out.println("Successfully selected.");
            connection.commit();
            preparedStatement.close();
            connection.close(); // Close the connection
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return roomVO;
    }

    @Override
    public List<RoomVO> getAll() {
        Statement statement = null;
        connection = dbConnection.getConnection();
        List<RoomVO> roomVOList = new ArrayList<>();
        RoomVO roomVO = null;
        int result = 0;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                int selectRoomTypeId = rs.getInt("type");
                String selectRoomTypeName = rs.getString("room_type");
                int selectBed = rs.getInt("bed");
                Array selectRoomProperties = rs.getArray("properties");
                int selectHotelId = rs.getInt("hotel_id");
                String selectHotelName = rs.getString("hotel_name");
                double selectArea = rs.getDouble("area");

                Short[] selectRoomPropertiesArray = (Short[]) selectRoomProperties.getArray();
                TreeSet<RoomPropertiesVO> roomPropertiesVOTreeSet = toTreeSetRoomPropertiesVO(selectRoomPropertiesArray);
                RoomTypeVO roomTypeVO = new RoomTypeDao().get(selectRoomTypeId);
                HotelVO hotelVO = new HotelDao().get(selectHotelId);
                roomVO = new RoomVO(selectId, selectName, roomTypeVO, selectBed,
                        roomPropertiesVOTreeSet, hotelVO, selectArea);
                roomVOList.add(roomVO);
                roomVO.getInfo();
                result += 1;
            }
            // Display the records listed
            System.out.println(result + " records listed.");
            connection.commit();
            statement.close();
            connection.close(); // Close the connection
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return roomVOList;
    }
}
