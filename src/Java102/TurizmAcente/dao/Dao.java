package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.DBConnection;
import Java102.TurizmAcente.vo.CityVO;
import Java102.TurizmAcente.vo.TownVO;

import java.sql.*;
import java.util.List;
import java.util.TreeMap;

public class Dao implements IDao {

    @Override
    public boolean delete(int id, String table, DBConnection dbConnection, Connection connection) {
        String DELETE = "DELETE FROM " + table + " WHERE ID = ?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            // Display the records deleted
            System.out.println(result + " records deleted.");
            connection.commit();
            preparedStatement.close();
            connection.close(); // Close the connection
            return true;
        } catch (SQLException se) {
            return dbConnection.finallyBlock(preparedStatement, dbConnection, se); // call finally block
        }
    }

    public static TreeMap<Integer, String> getCities(List<CityVO> list) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        if (list.size() <= 0) {
            System.out.println("List is not valid or empty !");
            return null;
        } else {
            for (CityVO obj : list) {
                treeMap.put(obj.getId(), obj.getName());
            }
            return treeMap;
        }
    }

    public static TreeMap<Integer, String> getTowns(List<TownVO> list) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        if (list.size() <= 0) {
            System.out.println("List is not valid or empty !");
            return null;
        } else {
            for (TownVO obj : list) {
                treeMap.put(obj.getId(), obj.getName() + " | " + obj.getCityVO().getName());
            }
            return treeMap;
        }
    }
}
