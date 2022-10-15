package Java102.TurizmAcente.vo;

import java.util.Comparator;

public class ServicesComparator implements Comparator<ServicesVO> {
    @Override
    public int compare(ServicesVO s1, ServicesVO s2) {
        return s1.getId() - s2.getId();
    }
}
