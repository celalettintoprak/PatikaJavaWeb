package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.DBConnection;
import Java102.TurizmAcente.vo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class HotelDao implements IHotelDao {
    protected DBConnection dbConnection = new DBConnection();
    protected Connection connection = dbConnection.getConnection();
    protected final String TABLE = "HOTEL";
    protected final String INSERT = "INSERT INTO " + TABLE + " (ID, NAME, ADDRESS, EMAIL, TEL," +
            "STARS, TOWN, SERVICES, HOTEL_TYPE, PRICE) VALUES (?,?,?,?,?,?,?,?,?,?);";
    protected final String UPDATE = "UPDATE " + TABLE + " SET NAME = ?, ADDRESS = ?, EMAIL = ?, TEL = ?, " +
            "STARS = ?, TOWN = ?, SERVICES = ?, HOTEL_TYPE = ?, PRICE = ? WHERE ID = ?;";
    protected final String SELECT = "SELECT HOTEL.ID, HOTEL.NAME, HOTEL.ADDRESS, HOTEL.EMAIL, HOTEL.TEL, " +
            "HOTEL.STARS, HOTEL.TOWN, TOWN.NAME AS TOWN_NAME, TOWN.CITY_ID, CITY.NAME AS CITY_NAME, HOTEL.SERVICES, " +
            "HOTEL.HOTEL_TYPE, HOTEL.PRICE FROM " + TABLE + " INNER JOIN TOWN ON TOWN.ID = HOTEL.TOWN" +
            "INNER JOIN CITY ON CITY.ID = TOWN.CITY_ID WHERE HOTEL.ID = ?;";
    protected final String SELECT_ALL = "SELECT HOTEL.ID, HOTEL.NAME, HOTEL.ADDRESS, HOTEL.EMAIL, HOTEL.TEL, " +
            "HOTEL.STARS, HOTEL.TOWN, TOWN.NAME AS TOWN_NAME, TOWN.CITY_ID, CITY.NAME AS CITY_NAME, HOTEL.SERVICES, " +
            "HOTEL.HOTEL_TYPE, HOTEL.PRICE FROM " + TABLE + " INNER JOIN TOWN ON TOWN.ID = HOTEL.TOWN" +
            "INNER JOIN CITY ON CITY.ID = TOWN.CITY_ID ORDER BY HOTEL.ID ASC;";

    private Object[] toIntServicesArray(TreeSet<ServicesVO> list) {
        List<Integer> result = new ArrayList<>();
        for (ServicesVO servicesVO : list) {
            result.add(servicesVO.getId());
        }
        return result.toArray();
    }

    private Object[] toIntHotelTypeArray(TreeSet<HotelTypeVO> list) {
        List<Integer> result = new ArrayList<>();
        for (HotelTypeVO hotelTypeVO : list) {
            result.add(hotelTypeVO.getId());
        }
        return result.toArray();
    }

    private TreeSet<ServicesVO> toTreeSetServicesVO(Short[] array) {
        TreeSet<ServicesVO> result = new TreeSet<>(new ServicesComparator());
        if (array.length != 0) {
            for (int i : array) {
                ServicesVO servicesVO = new ServicesDao().get(i);
                result.add(servicesVO);
            }
        }
        return result;
    }

    private TreeSet<HotelTypeVO> toTreeSetHotelTypeVO(Short[] array) {
        TreeSet<HotelTypeVO> result = new TreeSet<>(new HotelTypeComparator());
        if (array.length != 0) {
            for (int i : array) {
                HotelTypeVO hotelTypeVO = new HotelTypeDao().get(i);
                result.add(hotelTypeVO);
            }
        }
        return result;
    }

    @Override
    public boolean add(HotelVO hotelVO) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        Object[] servicesArray = toIntServicesArray(hotelVO.getServicesVOTreeSet());
        Object[] hotelTypeArray = toIntHotelTypeArray(hotelVO.getHotelTypeVOTreeSet());
        try {
            Array services = connection.createArrayOf("int", servicesArray);
            Array hotelType = connection.createArrayOf("int", hotelTypeArray);
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, hotelVO.getId());
            preparedStatement.setString(2, hotelVO.getName());
            preparedStatement.setString(3, hotelVO.getAddress());
            preparedStatement.setString(4, hotelVO.getEmail());
            preparedStatement.setString(5, hotelVO.getTel());
            preparedStatement.setInt(6, hotelVO.getStars());
            preparedStatement.setInt(7, hotelVO.getTownVO().getId());
            preparedStatement.setArray(8, services);
            preparedStatement.setArray(9, hotelType);
            preparedStatement.setDouble(10, hotelVO.getPrice());
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
    public boolean update(int id, String name, String address, String email, String tel, int stars,
                          int town, Object[] servicesArray, Object[] hotelTypeArray, double price) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        try {
            Array services = connection.createArrayOf("int", servicesArray);
            Array hotelType = connection.createArrayOf("int", hotelTypeArray);
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, tel);
            preparedStatement.setInt(5, stars);
            preparedStatement.setInt(6, town);
            preparedStatement.setArray(7, services);
            preparedStatement.setArray(8, hotelType);
            preparedStatement.setInt(9, id);
            preparedStatement.setDouble(10, price);
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
    public HotelVO get(int id) {
        PreparedStatement preparedStatement = null;
        connection = dbConnection.getConnection();
        HotelVO hotelVO = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                String selectAddress = rs.getString("address");
                String selectEmail = rs.getString("email");
                String selectTel = rs.getString("tel");
                int selectStars = rs.getInt("stars");
                int selectTownId = rs.getInt("town");
                String selectTownName = rs.getString("town_name");
                int selectCityId = rs.getInt("city_id");
                String selectCityName = rs.getString("city_name");
                Array services = rs.getArray("services");
                Array hotelType = rs.getArray("hotel_type");
                double selectPrice = rs.getDouble("price");

                Short[] servicesArray = (Short[]) services.getArray();
                Short[] hotelTypeArray = (Short[]) hotelType.getArray();
                TreeSet<ServicesVO> servicesVOTreeSet = toTreeSetServicesVO(servicesArray);
                TreeSet<HotelTypeVO> hotelTypeVOTreeSet = toTreeSetHotelTypeVO(hotelTypeArray);
                TownVO townVO = new TownVO(selectTownId, selectTownName, new CityVO(selectCityId, selectCityName));
                hotelVO = new HotelVO(selectId, selectName, selectAddress, selectEmail, selectTel,
                        selectStars, townVO, servicesVOTreeSet, hotelTypeVOTreeSet, selectPrice);
                hotelVO.getInfo();
            }
            // Display the records listed
            System.out.println("Successfully selected.");
            connection.commit();
            preparedStatement.close();
            connection.close(); // Close the connection
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return hotelVO;
    }

    @Override
    public List<HotelVO> getAll() {
        Statement statement = null;
        connection = dbConnection.getConnection();
        List<HotelVO> hotelVOList = new ArrayList<>();
        HotelVO hotelVO = null;
        int result = 0;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            while (rs.next()) {
                int selectId = rs.getInt("id");
                String selectName = rs.getString("name");
                String selectAddress = rs.getString("address");
                String selectEmail = rs.getString("email");
                String selectTel = rs.getString("tel");
                int selectStars = rs.getInt("stars");
                int selectTownId = rs.getInt("town");
                String selectTownName = rs.getString("town_name");
                int selectCityId = rs.getInt("city_id");
                String selectCityName = rs.getString("city_name");
                Array services = rs.getArray("services");
                Array hotelType = rs.getArray("hotel_type");
                double selectPrice = rs.getDouble("price");

                Short[] servicesArray = (Short[]) services.getArray();
                Short[] hotelTypeArray = (Short[]) hotelType.getArray();
                TreeSet<ServicesVO> servicesVOTreeSet = toTreeSetServicesVO(servicesArray);
                TreeSet<HotelTypeVO> hotelTypeVOTreeSet = toTreeSetHotelTypeVO(hotelTypeArray);
                TownVO townVO = new TownVO(selectTownId, selectTownName, new CityVO(selectCityId, selectCityName));
                hotelVO = new HotelVO(selectId, selectName, selectAddress, selectEmail, selectTel,
                        selectStars, townVO, servicesVOTreeSet, hotelTypeVOTreeSet, selectPrice);
                hotelVOList.add(hotelVO);

                hotelVO.getInfo();
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
        return hotelVOList;
    }
}
