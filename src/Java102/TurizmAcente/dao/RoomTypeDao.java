package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.DBConnection;
import Java102.TurizmAcente.vo.RoomTypeVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDao implements IRoomTypeDao {
    protected DBConnection dbConnection = new DBConnection();
    protected Connection connection = dbConnection.getConnection();
    protected final String TABLE = "ROOM_TYPE";
    protected final String INSERT = "INSERT INTO " + TABLE + " (ID, NAME, MULTIPLIER) VALUES (?,?,?);";
    protected final String UPDATE = "UPDATE " + TABLE + " SET NAME = ?, MULTIPLIER = ? WHERE ID = ?;";
    protected final String SELECT = "SELECT * FROM " + TABLE + " WHERE ID = ?;";
    protected final String SELECT_ALL = "SELECT * FROM " + TABLE + " ORDER BY ID ASC;";

    @Override
    public boolean add(RoomTypeVO roomTypeVO) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, roomTypeVO.getId());
            preparedStatement.setString(2, roomTypeVO.getName());
            preparedStatement.setDouble(3, roomTypeVO.getMultiplier());
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
    public boolean update(int id, String name, double multiplier) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, multiplier);
            preparedStatement.setInt(3, id);
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
    public RoomTypeVO get(int id) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        RoomTypeVO roomTypeVO = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                double multiplier = rs.getDouble("multiplier");
                roomTypeVO = new RoomTypeVO(selectId, selectName, multiplier);
                System.out.println("ID: " + selectId + "  |  NAME: " + selectName + "  |  MULTIPLIER: " + multiplier);
            }
            // Display the records listed
            System.out.println("Successfully selected.");
            connection.commit();
            preparedStatement.close();
            connection.close(); // Close the connection
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return roomTypeVO;
    }

    @Override
    public List<RoomTypeVO> getAll() {
        Statement statement = null;
        connection = dbConnection.getConnection();
        List<RoomTypeVO> roomTypeVO = new ArrayList<>();
        int result = 0;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                double multiplier = rs.getDouble("multiplier");
                roomTypeVO.add(new RoomTypeVO(selectId, selectName, multiplier));
                System.out.println("ID: " + selectId + "  |  NAME: " + selectName + "  |  MULTIPLIER: " + multiplier);
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
        return roomTypeVO;
    }
}
