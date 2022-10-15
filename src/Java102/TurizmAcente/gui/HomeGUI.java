package Java102.TurizmAcente.gui;

import Java102.TurizmAcente.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeGUI extends JFrame {
    private JButton buttonRoomSearch, buttonBooking, buttonHotels, buttonRooms, buttonCities;
    private JButton buttonSettings, buttonTowns, buttonServices, buttonHotelTypes;
    private JButton buttonRoomTypes, buttonRoomProperties;
    private JPanel wrapper;
    public HomeGUI() {
        add(wrapper);
        setSize(Config.getWidth(), Config.getHeight());
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Config.yesNo(this);
        setResizable(false);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2 - 100;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2 - 50;
        setTitle(Config.getTitle());
        setLocation(x, y);
        setVisible(true);

        buttonCities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {new GUI(Config.getColCity());}
        });

        buttonTowns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {new GUI(Config.getColTown());}
        });

        buttonServices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {new GUI(Config.getColServices());}
        });

        buttonHotelTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {new GUI(Config.getColHotelType());}
        });

        buttonRoomTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {new GUI(Config.getColRoomType());}
        });

        buttonRoomProperties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {new GUI(Config.getColRoomProperties());}
        });
    }
}
