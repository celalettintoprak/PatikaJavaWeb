package Java102.TurizmAcente;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.TreeMap;

public class Config {
    private static final String PROJECT_TITLE = "Turizm Acente Sistemi";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 500;
    private static final Object[] colCity = {"ID", "NAME"};
    private static final Object[] colTown = {"ID", "NAME", "CITY_ID", "CITY_NAME"};
    private static final Object[] colRoomType = {"ID", "NAME", "MULTIPLIER"};
    private static final Object[] colHotelType = {"ID", "NAME", "NAME2", "MULTIPLIER"};
    private static final Object[] colRoomProperties = {"ID", "NAME", "NAME2"};
    private static final Object[] colServices = {"ID", "NAME", "NAME2"};
    private static final Object[] colHotel = {"ID", "NAME", "ADDRESS", "EMAIL", "TEL", "STARS",
            "TOWN", "SERVICES", "HOTEL TYPE", "PRICE"};
    private static final Object[] colRoom = {"ID", "NAME", "ROOM TYPE", "BED AMOUNT", "ROOM PROPERTIES", "HOTEL", "AREA"};
    private static final Object[] colBooking = {"ID", "ROOM ID", "START DATE", "END DATE", "ADULT", "CHILD", "HOTEL TYPE",
            "HOTEL ID", "NAME", "EMAIL", "TEL", "NOTES", "VISITORS", "COST"};

    private static TreeMap<Integer, String> cities = new TreeMap<>();
    private static TreeMap<Integer, String> towns = new TreeMap<>();

    public static String getTitle() {
        return PROJECT_TITLE;
    }

    public static Object[] getColCity() {
        return colCity;
    }

    public static Object[] getColTown() {
        return colTown;
    }

    public static Object[] getColRoomType() {
        return colRoomType;
    }

    public static Object[] getColHotelType() {
        return colHotelType;
    }

    public static Object[] getColRoomProperties() {
        return colRoomProperties;
    }

    public static Object[] getColServices() {
        return colServices;
    }

    public static Object[] getColHotel() {
        return colHotel;
    }

    public static Object[] getColRoom() {
        return colRoom;
    }

    public static Object[] getColBooking() {
        return colBooking;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }

    public static TreeMap<Integer, String> getCities() {
        return cities;
    }

    public static void setCities(TreeMap<Integer, String> cities) {
        Config.cities = cities;
    }

    public static TreeMap<Integer, String> getTowns() {
        return towns;
    }

    public static void setTowns(TreeMap<Integer, String> towns) {
        Config.towns = towns;
    }

    public static void yesNo(JFrame jFrame) {
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JFrame frame = (JFrame) e.getSource();

                int result = JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to exit?",
                        "Exit", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });
    }
}
