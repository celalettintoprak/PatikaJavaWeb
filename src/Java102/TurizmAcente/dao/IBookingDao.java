package Java102.TurizmAcente.dao;

import Java102.TurizmAcente.vo.BookingVO;

import java.sql.Date;
import java.util.List;

public interface IBookingDao {
    boolean add(BookingVO bookingVO);
    boolean update(int id, int roomId, Date startDate, Date endDate, int aNumber, int cNumber, int hotelTypeId,
                   int hotelId, double cost, String name, String email, String tel, String notes, Object[] visitors);
    boolean delete(int id);
    BookingVO get(int id);
    List<BookingVO> getAll();
}

