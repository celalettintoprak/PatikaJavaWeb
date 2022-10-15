package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.DBConnection;
import Java102.TurizmAcente.vo.HotelTypeVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelTypeDao implements IHotelTypeDao {
    protected DBConnection dbConnection = new DBConnection();
    protected Connection connection = dbConnection.getConnection();
    protected final String TABLE = "HOTEL_TYPE";
    protected final String INSERT = "INSERT INTO " + TABLE + " (ID, NAME, NAME2, MULTIPLIER) VALUES (?,?,?,?);";
    protected final String UPDATE = "UPDATE " + TABLE + " SET NAME = ?, NAME2 = ?, MULTIPLIER = ? WHERE ID = ?;";
    protected final String SELECT = "SELECT * FROM " + TABLE + " WHERE ID = ?;";
    protected final String SELECT_ALL = "SELECT * FROM " + TABLE + " ORDER BY ID ASC;";

    @Override
    public boolean add(HotelTypeVO hotelTypeVO) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, hotelTypeVO.getId());
            preparedStatement.setString(2, hotelTypeVO.getName());
            preparedStatement.setString(3, hotelTypeVO.getName());
            preparedStatement.setDouble(4, hotelTypeVO.getMultiplier());
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
    public boolean update(HotelTypeVO hotelTypeVO) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, hotelTypeVO.getName());
            preparedStatement.setString(2, hotelTypeVO.getName2());
            preparedStatement.setDouble(3, hotelTypeVO.getMultiplier());
            preparedStatement.setInt(4, hotelTypeVO.getId());
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
    public HotelTypeVO get(int id) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        HotelTypeVO hotelTypeVO = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                String selectName2 = rs.getString("name2");
                double multiplier = rs.getDouble("multiplier");
                hotelTypeVO = new HotelTypeVO(selectId, selectName, selectName2, multiplier);
                System.out.println("ID: " + selectId + "  |  NAME: " + selectName + "  |  NAME2: " +
                        selectName2 + "  |  MULTIPLIER: " + multiplier);
            }
            // Display the records listed
            System.out.println("Successfully selected.");
            connection.commit();
            preparedStatement.close();
            connection.close(); // Close the connection
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return hotelTypeVO;
    }

    @Override
    public List<HotelTypeVO> getAll() {
        Statement statement = null;
        connection = dbConnection.getConnection();
        List<HotelTypeVO> hotelTypeVO = new ArrayList<>();
        int result = 0;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                String selectName2 = rs.getString("name2");
                double multiplier = rs.getDouble("multiplier");
                hotelTypeVO.add(new HotelTypeVO(selectId, selectName, selectName2, multiplier));
                System.out.println("ID: " + selectId + "  |  NAME: " + selectName +
                        "  |  NAME2: " + selectName2 + "  |  MULTIPLIER: " + multiplier);
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
        return hotelTypeVO;
    }
}
