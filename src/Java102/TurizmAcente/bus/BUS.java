package Java102.TurizmAcente.bus;

import Java102.TurizmAcente.Config;
import Java102.TurizmAcente.dao.*;
import Java102.TurizmAcente.vo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.Map;

public class BUS {
    public void initTable(DefaultTableModel model, Object[] objects) {
        if (model.getRowCount() > 0){
            model.setRowCount(0);
        }
        int length = objects.length;
        Object[] row = new Object[length];
        if (Arrays.equals(objects, Config.getColCity())) {
            CityDao cityDao = new CityDao();
            for (CityVO city : cityDao.getAll()) {
                int i = 0;
                row[i++] = city.getId();
                row[i++] = city.getName();
                model.addRow(row);
            }
        } else if (Arrays.equals(objects, Config.getColTown())) {
            TownDao townDao = new TownDao();
            for (TownVO town : townDao.getAll()) {
                int i = 0;
                row[i++] = town.getId();
                row[i++] = town.getName();
                row[i++] = town.getCityVO().getId();
                row[i++] = town.getCityVO().getName();
                model.addRow(row);
            }
        } else if (Arrays.equals(objects, Config.getColServices())) {
            ServicesDao servicesDao = new ServicesDao();
            for (ServicesVO services : servicesDao.getAll()) {
                int i = 0;
                row[i++] = services.getId();
                row[i++] = services.getName();
                row[i++] = services.getName2();
                model.addRow(row);
            }
        } else if (Arrays.equals(objects, Config.getColHotelType())) {
            HotelTypeDao hotelTypeDao = new HotelTypeDao();
            for (HotelTypeVO hotelType : hotelTypeDao.getAll()) {
                int i = 0;
                row[i++] = hotelType.getId();
                row[i++] = hotelType.getName();
                row[i++] = hotelType.getName2();
                row[i++] = hotelType.getMultiplier();
                model.addRow(row);
            }
        }
        for (int j = 0; j < length; j++) {
            if (j == length - 1) {
                System.out.print(row[j]);
            } else {
                System.out.print(row[j] + " ");
            }
        }
        System.out.println();
    }

    public Object newObj(Object[] obj) {
        if (Arrays.equals(obj, Config.getColCity())) {
            return newCity();
        } else if (Arrays.equals(obj, Config.getColTown())) {
            return newTown();
        } else if (Arrays.equals(obj, Config.getColServices())) {
            return newService();
        } else if (Arrays.equals(obj, Config.getColHotelType())) {
            return newHotelType();
        }
        return null;
    }



    public CityVO newCity() {
        String title = "New City";
        CityVO cityVO = null;
        JTextField jTextFieldId = new JTextField();
        JTextField jTextFieldName = new JTextField();
        Object[] inputFields = {"CITY ID", jTextFieldId, "CITY NAME", jTextFieldName};

        int option = JOptionPane.showConfirmDialog(null, inputFields, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(jTextFieldId.getText().trim());
                String name = jTextFieldName.getText().trim();
                cityVO = new CityVO(id, name);
                System.out.println(cityVO.getId() + " " + cityVO.getName());
                new CityDao().add(cityVO);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input");
            }
        }
        return cityVO;
    }

    public TownVO newTown() {
        String title = "New Town";
        TownVO townVO = null;
        JTextField jTextFieldId = new JTextField();
        JTextField jTextFieldName = new JTextField();
        JComboBox jComboBox = new JComboBox(Config.getCities().values().toArray());
        jComboBox.setBounds(50, 50, 90, 30);
        Object[] inputFields = {"TOWN ID", jTextFieldId, "TOWN NAME", jTextFieldName, "CITY", jComboBox};

        int option = JOptionPane.showConfirmDialog(null, inputFields, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            CityVO cityVO;
            try {
                int id = Integer.parseInt(jTextFieldId.getText().trim());
                String name = jTextFieldName.getText().trim();
                String cityName = jComboBox.getItemAt(jComboBox.getSelectedIndex()).toString();
                for (Map.Entry mapElement : Config.getCities().entrySet()) {
                    if (mapElement.getValue().equals(cityName)) {
                        int cityId = (int) mapElement.getKey();
                        cityVO = new CityDao().get(cityId);
                        townVO = new TownVO(id, name, cityVO);
                    }
                }
                if (townVO != null) {
                    System.out.println(townVO.getId() + " " + townVO.getName() + " " + townVO.getCityVO().getName());
                    new TownDao().add(townVO);
                }
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input");
            }
        }
        return townVO;
    }

    public ServicesVO newService() {
        String title = "New Service";
        ServicesVO servicesVO = null;
        JTextField jTextFieldId = new JTextField();
        JTextField jTextFieldName = new JTextField();
        JTextField jTextFieldName2 = new JTextField();
        Object[] inputFields = {"ID", jTextFieldId, "NAME", jTextFieldName,
                "NAME2", jTextFieldName2};

        int option = JOptionPane.showConfirmDialog(null, inputFields, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(jTextFieldId.getText().trim());
                String name = jTextFieldName.getText().trim();
                String name2 = jTextFieldName2.getText().trim();
                servicesVO = new ServicesVO(id, name, name2);
                System.out.println(servicesVO.getId() + " " +
                        servicesVO.getName() + " " + servicesVO.getName2());
                new ServicesDao().add(servicesVO);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input");
            }
        }
        return servicesVO;
    }

    public HotelTypeVO newHotelType() {
        String title = "New Hotel Type";
        HotelTypeVO hotelTypeVO = null;
        JTextField jTextFieldId = new JTextField();
        JTextField jTextFieldName = new JTextField();
        JTextField jTextFieldName2 = new JTextField();
        JTextField jTextFieldMultiplier = new JTextField();
        Object[] inputFields = {"ID", jTextFieldId, "NAME", jTextFieldName,
                "NAME2", jTextFieldName2, "MULTIPLIER", jTextFieldMultiplier};

        int option = JOptionPane.showConfirmDialog(null, inputFields, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(jTextFieldId.getText().trim());
                String name = jTextFieldName.getText().trim();
                String name2 = jTextFieldName2.getText().trim();
                double multiplier = Double.parseDouble(jTextFieldMultiplier.getText().trim());
                hotelTypeVO = new HotelTypeVO(id, name, name2, multiplier);
                System.out.println(hotelTypeVO.getId() + " " + hotelTypeVO.getName() + " " +
                        hotelTypeVO.getName2() + " " + hotelTypeVO.getMultiplier());
                new HotelTypeDao().add(hotelTypeVO);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input");
            }
        }
        return hotelTypeVO;
    }

    public CityVO modifyCity(CityVO cityVO) {
        if (cityVO == null) {
            System.out.println("Please select any row !");
            return null;
        }
        String title = "Modify City";
        CityVO city = null;
        JTextField jTextFieldId = new JTextField(String.valueOf(cityVO.getId()));
        jTextFieldId.setEnabled(false);
        JTextField jTextFieldName = new JTextField(cityVO.getName());
        Object[] inputFields = {"CITY ID", jTextFieldId, "CITY NAME", jTextFieldName};

        int option = JOptionPane.showConfirmDialog(null, inputFields, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            try {
                String name = jTextFieldName.getText().trim();
                city = new CityVO(cityVO.getId(), name);
                new CityDao().update(city);
                System.out.println(city.getId() + " " + city.getName());
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input");
            }
        }
        return city;
    }

    public TownVO modifyTown(TownVO townVO) {
        if (townVO == null) {
            System.out.println("Please select any row !");
            return null;
        }
        String title = "Modify Town";
        TownVO town = null;
        JTextField jTextFieldId = new JTextField(String.valueOf(townVO.getId()));
        jTextFieldId.setEnabled(false);
        JTextField jTextFieldName = new JTextField(String.valueOf(townVO.getName()));
        JComboBox jComboBox = new JComboBox(Config.getCities().values().toArray());
        jComboBox.setSelectedItem(townVO.getCityVO().getName());
        jComboBox.setBounds(50, 50, 90, 30);

        Object[] inputFields = {"TOWN ID", jTextFieldId, "TOWN NAME", jTextFieldName, "CITY", jComboBox};

        int option = JOptionPane.showConfirmDialog(null, inputFields, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            CityVO cityVO;
            try {
                String name = jTextFieldName.getText().trim();
                String cityName = jComboBox.getItemAt(jComboBox.getSelectedIndex()).toString();
                for (Map.Entry mapElement : Config.getCities().entrySet()) {
                    if (mapElement.getValue().equals(cityName)) {
                        int cityId = (int) mapElement.getKey();
                        cityVO = new CityDao().get(cityId);
                        town = new TownVO(townVO.getId(), name, cityVO);
                    }
                }
                if (town != null) {
                    System.out.println(town.getId() + " " + townVO.getName() + " " + townVO.getCityVO().getName());
                    new TownDao().update(town);
                }
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input");
            }
        }
        return town;
    }

    public ServicesVO modifyService(ServicesVO servicesVO) {
        if (servicesVO == null) {
            System.out.println("Please select any row !");
            return null;
        }
        String title = "Modify Service";
        ServicesVO service = null;
        JTextField jTextFieldId = new JTextField(String.valueOf(servicesVO.getId()));
        jTextFieldId.setEnabled(false);
        JTextField jTextFieldName = new JTextField(String.valueOf(servicesVO.getName()));
        JTextField jTextFieldName2 = new JTextField(String.valueOf(servicesVO.getName2()));

        Object[] inputFields = {"ID", jTextFieldId, "NAME", jTextFieldName,
                "NAME2", jTextFieldName2};

        int option = JOptionPane.showConfirmDialog(null, inputFields, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            try {
                String name = jTextFieldName.getText().trim();
                String name2 = jTextFieldName2.getText().trim();
                service = new ServicesVO(servicesVO.getId(), name, name2);
                new ServicesDao().update(service);
                System.out.println(service.getId() + " " + service.getName() + " " + service.getName2());
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input");
            }
        }
        return service;
    }

    public HotelTypeVO modifyHotelType(HotelTypeVO hotelTypeVO) {
        if (hotelTypeVO == null) {
            System.out.println("Please select any row !");
            return null;
        }
        String title = "Modify Hotel Type";
        HotelTypeVO hotelType = null;
        JTextField jTextFieldId = new JTextField(String.valueOf(hotelTypeVO.getId()));
        jTextFieldId.setEnabled(false);
        JTextField jTextFieldName = new JTextField(String.valueOf(hotelTypeVO.getName()));
        JTextField jTextFieldName2 = new JTextField(String.valueOf(hotelTypeVO.getName2()));
        JTextField jTextFieldMultiplier = new JTextField(String.valueOf(hotelTypeVO.getMultiplier()));

        Object[] inputFields = {"ID", jTextFieldId, "NAME", jTextFieldName,
                "NAME2", jTextFieldName2, "MULTIPLIER", jTextFieldMultiplier};

        int option = JOptionPane.showConfirmDialog(null, inputFields, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            try {
                String name = jTextFieldName.getText().trim();
                String name2 = jTextFieldName2.getText().trim();
                double multiplier = Double.parseDouble(jTextFieldMultiplier.getText().trim());
                hotelType = new HotelTypeVO(hotelTypeVO.getId(), name, name2, multiplier);
                new HotelTypeDao().update(hotelType);
                System.out.println(hotelType.getId() + " " + hotelType.getName() + " " +
                        hotelType.getName2() + " " + hotelType.getMultiplier());
            } catch (NumberFormatException e) {
                System.out.println("NumberFormat Exception: invalid input");
            }
        }
        return hotelType;
    }

    public TurizmEntity delete(TurizmEntity entity) {
        if (entity == null) {
            System.out.println("Please select any row !");
        } else {
            String title = "Delete";
            JLabel jLabelId = new JLabel("ID: " + entity.getId());
            JLabel jLabelName = new JLabel("NAME: " + entity.getName());
            Object[] inputFields = {jLabelId, jLabelName};

            int option = JOptionPane.showConfirmDialog(null, inputFields, title,
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

            if (option == JOptionPane.OK_OPTION) {
                System.out.println("Deleted: " + entity.getId() + " " + entity.getName());
                if (entity.getClass().equals(CityVO.class)) {
                    new CityDao().delete(entity.getId());
                } else if (entity.getClass().equals(TownVO.class)) {
                    new TownDao().delete(entity.getId());
                } else if (entity.getClass().equals(ServicesVO.class)) {
                    new ServicesDao().delete(entity.getId());
                } else if (entity.getClass().equals(HotelTypeVO.class)) {
                    new HotelTypeDao().delete(entity.getId());
                }
            }
        }
        return entity;
    }
}
