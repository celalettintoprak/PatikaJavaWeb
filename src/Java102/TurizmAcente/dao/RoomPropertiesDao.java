package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.DBConnection;
import Java102.TurizmAcente.vo.RoomPropertiesVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomPropertiesDao implements IRoomPropertiesDao {
    protected DBConnection dbConnection = new DBConnection();
    protected Connection connection = dbConnection.getConnection();
    protected final String TABLE = "ROOM_PROPERTIES";
    protected final String INSERT = "INSERT INTO " + TABLE + " (ID, NAME, NAME2) VALUES (?,?,?);";
    protected final String UPDATE = "UPDATE " + TABLE + " SET NAME = ?, NAME2 = ? WHERE ID = ?;";
    protected final String SELECT = "SELECT * FROM " + TABLE + " WHERE ID = ?;";
    protected final String SELECT_ALL = "SELECT * FROM " + TABLE + " ORDER BY ID ASC;";

    @Override
    public boolean add(RoomPropertiesVO roomPropertiesVO) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, roomPropertiesVO.getId());
            preparedStatement.setString(2, roomPropertiesVO.getName());
            preparedStatement.setString(3, roomPropertiesVO.getName());
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
    public boolean update(int id, String name, String name2) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name2);
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
    public RoomPropertiesVO get(int id) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        RoomPropertiesVO roomPropertiesVO = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                String selectName2 = rs.getString("name2");
                roomPropertiesVO = new RoomPropertiesVO(selectId, selectName, selectName2);
                System.out.println("ID: " + selectId + "  |  NAME: " + selectName + "  |  NAME2: " + selectName2);
            }
            // Display the records listed
            System.out.println("Successfully selected.");
            connection.commit();
            preparedStatement.close();
            connection.close(); // Close the connection
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return roomPropertiesVO;
    }

    @Override
    public List<RoomPropertiesVO> getAll() {
        Statement statement = null;
        connection = dbConnection.getConnection();
        List<RoomPropertiesVO> roomPropertiesVO = new ArrayList<>();
        int result = 0;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                String selectName2 = rs.getString("name2");
                roomPropertiesVO.add(new RoomPropertiesVO(selectId, selectName, selectName2));
                System.out.println("ID: " + selectId + "  |  NAME: " + selectName + "  |  NAME2: " + selectName2);
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
        return roomPropertiesVO;
    }
}
