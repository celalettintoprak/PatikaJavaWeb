package Java102.TurizmAcente.vo;

import java.util.Comparator;

public class RoomPropertiesComparator implements Comparator<RoomPropertiesVO> {
    @Override
    public int compare(RoomPropertiesVO r1, RoomPropertiesVO r2) {
        return r1.getId() - r2.getId();
    }
}