package Java102.TurizmAcente.vo;

import java.util.Comparator;

public class HotelTypeComparator implements Comparator<HotelTypeVO> {
    @Override
    public int compare(HotelTypeVO h1, HotelTypeVO h2) {
        return h1.getId() - h2.getId();
    }
}
