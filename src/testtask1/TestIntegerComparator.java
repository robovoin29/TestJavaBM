package testtask1;

import java.util.Comparator;

// 1 task
class TestIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer elm1, Integer elm2) {
        boolean isFirstEven = elm1%2 == 0;
        boolean isSecondEven = elm2%2 == 0;
        if (!isFirstEven && isSecondEven) {
            return -1;
        } else if  (isFirstEven && !isSecondEven) {
            return 1;
        } else if (!isFirstEven && !isSecondEven) {
            return elm1.compareTo(elm2);
        } else if (elm1 == 0 && elm2 != 0) {
            return -1;
        } else if (elm2 == 0 && elm1 != 0) {
            return 1;
        } else {
            return elm2.compareTo(elm1);
        }

    }
}
