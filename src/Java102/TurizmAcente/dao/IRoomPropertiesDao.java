package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.vo.RoomPropertiesVO;

import java.util.List;

public interface IRoomPropertiesDao {
    boolean add(RoomPropertiesVO roomPropertiesVO);
    boolean update(int id, String name, String name2);
    boolean delete(int id);
    RoomPropertiesVO get(int id);
    List<RoomPropertiesVO> getAll();
}

