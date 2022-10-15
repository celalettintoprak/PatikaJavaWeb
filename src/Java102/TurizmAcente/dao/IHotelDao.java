package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.vo.HotelVO;

import java.util.List;

public interface IHotelDao {
    boolean add(HotelVO hotelVO);
    boolean update(int id, String name, String address, String email, String tel,
                   int stars, int town, Object[] services, Object[] hotelType, double price);
    boolean delete(int id);
    HotelVO get(int id);
    List<HotelVO> getAll();
}