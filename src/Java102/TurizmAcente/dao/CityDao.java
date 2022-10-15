package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.DBConnection;
import Java102.TurizmAcente.vo.CityVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDao implements ICityDao {
    protected DBConnection dbConnection = new DBConnection();
    protected Connection connection = dbConnection.getConnection();
    protected final String TABLE = "CITY";
    protected final String INSERT = "INSERT INTO " + TABLE + " (ID, NAME) VALUES (?,?);";
    protected final String UPDATE = "UPDATE " + TABLE + " SET NAME = ? WHERE ID = ?;";
    protected final String SELECT = "SELECT * FROM " + TABLE + " WHERE ID = ?;";
    protected final String SELECT_ALL = "SELECT * FROM " + TABLE + " ORDER BY ID ASC;";

    @Override
    public boolean add(CityVO cityVO) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, cityVO.getId());
            preparedStatement.setString(2, cityVO.getName());
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
    public boolean update(CityVO cityVO) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, cityVO.getName());
            preparedStatement.setInt(2, cityVO.getId());
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
    public CityVO get(int id) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        CityVO cityVO = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                cityVO = new CityVO(selectId, selectName);
                System.out.println("ID: " + selectId + "  |  NAME: " + selectName);
            }
            // Display the records listed
            System.out.println("Successfully selected.");
            connection.commit();
            preparedStatement.close();
            connection.close(); // Close the connection
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return cityVO;
    }

    @Override
    public List<CityVO> getAll() {
        Statement statement = null;
        connection = dbConnection.getConnection();
        List<CityVO> cityVO = new ArrayList<>();
        int result = 0;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                cityVO.add(new CityVO(selectId, selectName));
                System.out.println("ID: " + selectId + "  |  NAME: " + selectName);
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
        return cityVO;
    }
}
