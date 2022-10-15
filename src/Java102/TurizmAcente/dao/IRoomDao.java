package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.vo.RoomVO;

import java.util.List;

public interface IRoomDao {
    boolean add(RoomVO roomV0);
    boolean update(int id, String name, int roomType, int bedAmount, Object[] roomProperties,
                   int hotel, double area);
    boolean delete(int id);
    RoomVO get(int id);
    List<RoomVO> getAll();
}