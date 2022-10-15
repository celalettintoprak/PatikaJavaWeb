package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.vo.ServicesVO;

import java.util.List;

public interface IServicesDao {
    boolean add(ServicesVO servicesVO);
    boolean update(ServicesVO servicesVO);
    boolean delete(int id);
    ServicesVO get(int id);
    List<ServicesVO> getAll();
}

