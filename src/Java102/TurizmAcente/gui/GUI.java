package Java102.TurizmAcente.gui;

import Java102.TurizmAcente.Config;
import Java102.TurizmAcente.bus.BUS;
import Java102.TurizmAcente.vo.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GUI extends JFrame {
    private JPanel wrapper;
    private JTable table;
    private JButton newButton, modifyButton, deleteButton, refreshButton, closeButton;
    private JLabel labelResults;
    protected final DefaultTableModel model;
    private CityVO selectedCity;
    private TownVO selectedTown;
    private ServicesVO selectedService;
    private HotelTypeVO selectedHotelType;
    private final Object[] objects;

    public GUI(Object[] objects) {
        this.objects = objects;
        BUS bus = new BUS();
        add(wrapper);
        setSize(Config.getWidth(), Config.getHeight());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;
        setTitle(Config.getTitle());
        setLocation(x + 200, y + 200);
        setVisible(true);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(getObjects());
        bus.initTable(model, getObjects());

        table.setModel(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        setMaxWidth(table);
        table.getTableHeader().setReorderingAllowed(false);
        labelResults.setText("Row Count: " + table.getRowCount());

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (table.getSelectedRow() > -1) {
                    if (Arrays.equals(getObjects(), Config.getColCity())) {
                        selectCity();
                    } else if (Arrays.equals(getObjects(), Config.getColTown())) {
                        selectTown();
                    } else if (Arrays.equals(getObjects(), Config.getColServices())) {
                        selectService();
                    } else if (Arrays.equals(getObjects(), Config.getColHotelType())) {
                        selectHotelType();
                    }
                }
            }
        });

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == newButton) {
                    try {
                        TurizmEntity entity = (TurizmEntity) bus.newObj(getObjects());
                        labelResults.setText("Added: " + entity.getId() + " " + entity.getName());
                        bus.initTable(model, getObjects());
                    } catch (NullPointerException exception) {
                        System.out.println("NullPointer Exception: please fill all fields");
                    }
                }
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == modifyButton) {
                    if (selectedCity == null && selectedTown == null && selectedService == null && selectedHotelType == null) {
                        labelResults.setText("Please select any row !");
                    } else {
                        try {
                            TurizmEntity entity = null;
                            if (Arrays.equals(getObjects(), Config.getColCity())) {
                                entity = bus.modifyCity(selectedCity);
                            } else if (Arrays.equals(getObjects(), Config.getColTown())) {
                                entity = bus.modifyTown(selectedTown);
                            } else if (Arrays.equals(getObjects(), Config.getColServices())) {
                                entity = bus.modifyService(selectedService);
                            } else if (Arrays.equals(getObjects(), Config.getColHotelType())) {
                                entity = bus.modifyHotelType(selectedHotelType);
                            }
                            assert entity != null;
                            labelResults.setText("Updated: " + entity.getId() + " " + entity.getName());
                            bus.initTable(model, getObjects());
                        } catch (NullPointerException exception) {
                            System.out.println("NullPointer Exception: please fill all fields");
                        }
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == deleteButton) {
                    if (selectedCity == null && selectedTown == null && selectedService == null && selectedHotelType == null) {
                        labelResults.setText("Please select any row !");
                    } else {
                        TurizmEntity entity = null;
                        if (Arrays.equals(getObjects(), Config.getColCity())) {
                            entity = bus.delete(selectedCity);
                        } else if (Arrays.equals(getObjects(), Config.getColTown())) {
                            entity = bus.delete(selectedTown);
                        } else if (Arrays.equals(getObjects(), Config.getColServices())) {
                            entity = bus.delete(selectedService);
                        } else if (Arrays.equals(getObjects(), Config.getColHotelType())) {
                            entity = bus.delete(selectedHotelType);
                        }
                        assert entity != null;
                        labelResults.setText("Deleted: " + entity.getId() + " " + entity.getName());
                        bus.initTable(model, getObjects());
                    }
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == refreshButton) {
                    bus.initTable(model, getObjects());
                    labelResults.setText("Refreshed. Row Count: " + table.getRowCount());
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == closeButton) {
                    GUI.this.setVisible(false);
                }
            }
        });
    }

    private void selectCity() {
        int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
        String name = table.getValueAt(table.getSelectedRow(), 1).toString();
        if (selectedCity == null) {
            selectedCity = new CityVO(id, name);
        } else {
            selectedCity.setId(id);
            selectedCity.setName(name);
        }
        // print values from selected row
        System.out.println(id + " " + name);
    }

    private void selectTown() {
        CityVO cityVO;
        int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
        String name = table.getValueAt(table.getSelectedRow(), 1).toString();
        int cityId = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString());
        String cityName = table.getValueAt(table.getSelectedRow(), 3).toString();
        cityVO = new CityVO(cityId, cityName);

        if (selectedTown == null) {
            selectedTown = new TownVO(id, name, cityVO);
        } else {
            selectedTown.setId(id);
            selectedTown.setName(name);
            selectedTown.setCityVO(cityVO);
        }
        // print values from selected row
        System.out.println(id + " " + name + " | " + cityVO.getId() + " " + cityVO.getName());
    }

    private void selectService() {
        int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
        String name = table.getValueAt(table.getSelectedRow(), 1).toString();
        String name2 = table.getValueAt(table.getSelectedRow(), 2).toString();
        if (selectedService == null) {
            selectedService = new ServicesVO(id, name, name2);
        } else {
            selectedService.setId(id);
            selectedService.setName(name);
            selectedService.setName2(name2);
        }
        // print values from selected row
        System.out.println(id + " " + name + " " + name2);
    }

    private void selectHotelType() {
        double multiplier;
        int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
        String name = table.getValueAt(table.getSelectedRow(), 1).toString();
        String name2 = table.getValueAt(table.getSelectedRow(), 2).toString();
        multiplier = Double.parseDouble(table.getValueAt(table.getSelectedRow(), 3).toString());
        if (selectedHotelType == null) {
            selectedHotelType = new HotelTypeVO(id, name, name2, multiplier);
        } else {
            selectedHotelType.setId(id);
            selectedHotelType.setName(name);
            selectedHotelType.setName2(name2);
            selectedHotelType.setMultiplier(multiplier);
        }
        // print values from selected row
        System.out.println(id + " " + name + " " + name2 + " " + multiplier);
    }

    public Object[] getObjects() {
        return objects;
    }

    private void setMaxWidth(JTable table) {
        if (Arrays.equals(getObjects(), Config.getColTown())) {
            table.getColumnModel().getColumn(2).setMaxWidth(50);
        } else if (Arrays.equals(getObjects(), Config.getColHotelType())) {
            table.getColumnModel().getColumn(3).setMaxWidth(100);
        }
    }
}
