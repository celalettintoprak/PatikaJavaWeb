package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.DBConnection;

import java.sql.Connection;

public interface IDao {
    boolean delete(int id, String table, DBConnection dbConnection, Connection connection);
}
