package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.vo.CityVO;

import java.util.List;

public interface ICityDao {
    boolean add(CityVO cityVO);
    boolean update(CityVO cityVO);
    boolean delete(int id);
    CityVO get(int id);
    List<CityVO> getAll();
}

