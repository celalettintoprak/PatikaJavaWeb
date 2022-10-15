package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.vo.TownVO;

import java.util.List;

public interface ITownDao {
    boolean add(TownVO townVO);
    boolean update(TownVO townVO);
    boolean delete(int id);
    TownVO get(int id);
    List<TownVO> getAll();
}

