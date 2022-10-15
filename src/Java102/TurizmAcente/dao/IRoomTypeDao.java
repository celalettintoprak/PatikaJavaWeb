package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.vo.RoomTypeVO;

import java.util.List;

public interface IRoomTypeDao {
    boolean add(RoomTypeVO roomTypeVO);
    boolean update(int id, String name, double multiplier);
    boolean delete(int id);
    RoomTypeVO get(int id);
    List<RoomTypeVO> getAll();
}

