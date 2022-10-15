package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.vo.HotelTypeVO;

import java.util.List;

public interface IHotelTypeDao {
    boolean add(HotelTypeVO hotelTypeVO);
    boolean update(HotelTypeVO hotelTypeVO);
    boolean delete(int id);
    HotelTypeVO get(int id);
    List<HotelTypeVO> getAll();
}

