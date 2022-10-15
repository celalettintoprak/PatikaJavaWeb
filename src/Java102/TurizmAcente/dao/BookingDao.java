package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.DBConnection;
import Java102.TurizmAcente.vo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class BookingDao implements IBookingDao {
    protected DBConnection dbConnection = new DBConnection();
    protected Connection connection = dbConnection.getConnection();
    protected final String TABLE = "BOOKING";
    protected final String INSERT = "INSERT INTO " + TABLE + " (ID, ROOM_ID, START_DATE, END_DATE, A_NUMBER, C_NUMBER, " +
            "HOTEL_TYPE, HOTEL, COST, NAME, EMAIL, TEL, NOTES, VISITORS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    protected final String UPDATE = "UPDATE " + TABLE + " SET ROOM_ID = ?, START_DATE = ?, END_DATE = ?, A_NUMBER = ?, C_NUMBER = ?, " +
            "HOTEL_TYPE = ?, HOTEL = ?, COST = ?, NAME = ?, EMAIL = ?, TEL = ?, NOTES = ?, VISITORS = ? WHERE ID = ?;";
    protected final String SELECT = "SELECT * FROM " + TABLE + " WHERE ID = ?;";
    protected final String SELECT_ALL = "SELECT * FROM " + TABLE + " ORDER BY ID ASC;";

    private TreeSet<String[]> toTreeSetVisitors(String[] array) {
        TreeSet<String[]> result = new TreeSet<>(new VisitorsComparator());
        if (array.length != 0) {
            for (String visitor : array) {
                String[] temp = visitor.split(">");
                result.add(temp);
            }
        }
        return result;
    }

    private Object[] toVisitorsArray(TreeSet<String[]> list) {
        List<String> result = new ArrayList<>();
        for (String[] visitor : list) {
            result.add(visitor[0] + ">" + visitor[1] + ">" + visitor[2]);
        }
        return result.toArray();
    }

    @Override
    public boolean add(BookingVO bookingVO) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        Object[] visitorsArray = toVisitorsArray(bookingVO.getVisitors());
        try {
            Array visitors = connection.createArrayOf("varchar", visitorsArray);
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, bookingVO.getId());
            preparedStatement.setInt(2, bookingVO.getRoomId());
            preparedStatement.setDate(3, bookingVO.getStartDate());
            preparedStatement.setDate(4, bookingVO.getEndDate());
            preparedStatement.setInt(5, bookingVO.getaNumber());
            preparedStatement.setInt(6, bookingVO.getcNumber());
            preparedStatement.setInt(7, bookingVO.getHotelTypeId());
            preparedStatement.setInt(8, bookingVO.getHotelId());
            preparedStatement.setDouble(9, bookingVO.getCost());
            preparedStatement.setString(10, bookingVO.getName());
            preparedStatement.setString(11, bookingVO.getEmail());
            preparedStatement.setString(12, bookingVO.getTel());
            preparedStatement.setString(13, bookingVO.getNotes());
            preparedStatement.setArray(14, visitors);
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
    public boolean update(int id, int roomId, Date startDate, Date endDate, int aNumber, int cNumber, int hotelTypeId,
                          int hotelId, double cost, String name, String email, String tel, String notes, Object[] visitorsArray) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            Array visitors = connection.createArrayOf("varchar", visitorsArray);
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, roomId);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, endDate);
            preparedStatement.setInt(4, aNumber);
            preparedStatement.setInt(5, cNumber);
            preparedStatement.setInt(6, hotelTypeId);
            preparedStatement.setInt(7, hotelId);
            preparedStatement.setDouble(8, cost);
            preparedStatement.setString(9, name);
            preparedStatement.setString(10, email);
            preparedStatement.setString(11, tel);
            preparedStatement.setString(12, notes);
            preparedStatement.setArray(13, visitors);
            preparedStatement.setInt(14, id);
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
    public BookingVO get(int id) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        BookingVO bookingVO = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int selectId = rs.getInt("id");
                int selectRoomId = rs.getInt("room_id");
                Date selectStartDate = rs.getDate("start_date");
                Date selectEndDate = rs.getDate("end_date");
                int selectaNumber = rs.getInt("a_number");
                int selectcNumber = rs.getInt("c_number");
                int selectHotelTypeId = rs.getInt("hotel_type");
                int selectHotelId = rs.getInt("hotel");
                double selectCost = rs.getDouble("cost");
                String selectName = rs.getString("name");
                String selectEmail = rs.getString("email");
                String selectTel = rs.getString("tel");
                String selectNotes = rs.getString("notes");
                Array selectVisitors = rs.getArray("visitors");

                String[] selectVisitorsArray = (String[]) selectVisitors.getArray();
                TreeSet<String[]> visitors = toTreeSetVisitors(selectVisitorsArray);
                bookingVO = new BookingVO(selectId, selectRoomId, selectStartDate, selectEndDate,
                        selectaNumber, selectcNumber, selectHotelTypeId, selectHotelId,
                        selectName, selectEmail, selectTel, selectNotes, visitors);
                bookingVO.getInfo();
            }
            // Display the records listed
            System.out.println("Successfully selected.");
            connection.commit();
            preparedStatement.close();
            connection.close(); // Close the connection
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return bookingVO;
    }

    @Override
    public List<BookingVO> getAll() {
        Statement statement = null;
        connection = dbConnection.getConnection();
        List<BookingVO> bookingVOList = new ArrayList<>();
        BookingVO bookingVO = null;
        int result = 0;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()) {
                int selectId = rs.getInt("id");
                int selectRoomId = rs.getInt("room_id");
                Date selectStartDate = rs.getDate("start_date");
                Date selectEndDate = rs.getDate("end_date");
                int selectaNumber = rs.getInt("a_number");
                int selectcNumber = rs.getInt("c_number");
                int selectHotelTypeId = rs.getInt("hotel_type");
                int selectHotelId = rs.getInt("hotel");
                double selectCost = rs.getDouble("cost");
                String selectName = rs.getString("name");
                String selectEmail = rs.getString("email");
                String selectTel = rs.getString("tel");
                String selectNotes = rs.getString("notes");
                Array selectVisitors = rs.getArray("visitors");

                String[] selectVisitorsArray = (String[]) selectVisitors.getArray();
                TreeSet<String[]> visitors = toTreeSetVisitors(selectVisitorsArray);
                bookingVO = new BookingVO(selectId, selectRoomId, selectStartDate, selectEndDate,
                        selectaNumber, selectcNumber, selectHotelTypeId, selectHotelId,
                        selectName, selectEmail, selectTel, selectNotes, visitors);
                bookingVOList.add(bookingVO);
                bookingVO.getInfo();
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
        return bookingVOList;
    }
}
