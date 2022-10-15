package Java102.TurizmAcente;

import Java102.TurizmAcente.dao.CityDao;
import Java102.TurizmAcente.dao.Dao;
import Java102.TurizmAcente.dao.TownDao;
import Java102.TurizmAcente.gui.HomeGUI;

public class Main {
    public static void main(String[] args) {
        System.out.println("Turizm Acente Sistemi'ne Hoşgeldiniz !");

        // CityDao cityDao = new CityDao();
        // TownDao townDao = new TownDao();
        // ServicesDao servicesDao = new ServicesDao();
        // HotelTypeDao hotelTypeDao = new HotelTypeDao();
        // RoomTypeDao roomTypeDao = new RoomTypeDao();
        // RoomPropertiesDao roomPropertiesDao = new RoomPropertiesDao();
        // HotelDao hotelDao = new HotelDao();

        // cityDao.add(new CityVO(82, "TEST"));
        // cityDao.delete(82);
        // cityDao.update(82, "İstanbul");
        // cityDao.get(80);
        // cityDao.getAll();

        // townDao.get(1);
        // townDao.getAll();

        // servicesDao.get(4);
        // servicesDao.getAll();

        // hotelTypeDao.getAll();

        // roomTypeDao.getAll();

        // roomPropertiesDao.get(1);

        // hotelDao.get(35);
        // hotelDao.getAll();

        Config.setCities(Dao.getCities(new CityDao().getAll()));
        Config.setTowns(Dao.getTowns(new TownDao().getAll()));
        HomeGUI homeGUI = new HomeGUI();
    }
}
