package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.DBConnection;
import Java102.TurizmAcente.vo.CityVO;
import Java102.TurizmAcente.vo.TownVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TownDao implements ITownDao {
    protected DBConnection dbConnection = new DBConnection();
    protected Connection connection = dbConnection.getConnection();
    protected final String TABLE = "TOWN";
    protected final String INSERT = "INSERT INTO " + TABLE + " (ID, NAME, CITY_ID) VALUES (?,?,?);";
    protected final String UPDATE = "UPDATE " + TABLE + " SET NAME = ?, CITY_ID = ? WHERE ID = ?;";
    protected final String SELECT = "SELECT TOWN.ID, TOWN.NAME, TOWN.CITY_ID, CITY.NAME AS CITY_NAME " +
            "FROM " + TABLE + " INNER JOIN CITY ON CITY.ID = TOWN.CITY_ID WHERE TOWN.ID = ?;";
    protected final String SELECT_ALL = "SELECT TOWN.ID, TOWN.NAME, TOWN.CITY_ID, CITY.NAME AS CITY_NAME " +
            "FROM " + TABLE + " INNER JOIN CITY ON CITY.ID = TOWN.CITY_ID ORDER BY TOWN.ID ASC;";

    @Override
    public boolean add(TownVO townVO) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, townVO.getId());
            preparedStatement.setString(2, townVO.getName());
            preparedStatement.setInt(3, townVO.getCityVO().getId());
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
    public boolean update(TownVO townVO) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, townVO.getName());
            preparedStatement.setInt(2, townVO.getCityVO().getId());
            preparedStatement.setInt(3, townVO.getId());
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
    public TownVO get(int id) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        TownVO townVO = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                int selectCityId = rs.getInt("city_id");
                String selectCityName = rs.getString("city_name");
                townVO = new TownVO(selectId, selectName, new CityVO(selectCityId, selectCityName));
                System.out.println("ID: " + selectId + "  |  NAME: " + selectName + "  |  CITY: " + selectCityName);
            }
            // Display the records listed
            System.out.println("Successfully selected.");
            connection.commit();
            preparedStatement.close();
            connection.close(); // Close the connection
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return townVO;
    }

    @Override
    public List<TownVO> getAll() {
        Statement statement = null;
        connection = dbConnection.getConnection();
        List<TownVO> townVO = new ArrayList<>();
        int result = 0;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                int selectCityId = rs.getInt("city_id");
                String selectCityName = rs.getString("city_name");
                townVO.add(new TownVO(selectId, selectName, new CityVO(selectCityId, selectCityName)));
                System.out.println("ID: " + selectId + "  |  NAME: " + selectName + "  |  CITY: " + selectCityName);
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
        return townVO;
    }
}
