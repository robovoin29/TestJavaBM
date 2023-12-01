package testtask2;

import java.util.*;

// 2 task
public class TestMostCommonHandler {
    private final Integer[] innerArray;
    private ArrayList<Integer> resCommonValues;
    public TestMostCommonHandler (Integer[] nums) {
        this.innerArray = nums;
        this.resCommonValues = new ArrayList<>();
    }

    private HashMap<Integer, Integer> calcPairsCommonEntry() {
        HashMap<Integer, Integer> commonValues = new HashMap<>();
        for(Integer num: this.innerArray) {
            if (!commonValues.containsKey(num)) {
                commonValues.put(num, 1);
            }
            else {
                commonValues.put(num, commonValues.get(num) + 1);
            }
        }
        // output of intermediate results
        System.out.println(commonValues);
        return commonValues;
    }

    public void calcCommonValues() {
        HashMap<Integer, Integer> commonValues = calcPairsCommonEntry();
        Integer maxCommonEntry = Collections.max(commonValues.values());
        for (Map.Entry<Integer, Integer> pair_common: commonValues.entrySet()) {
            if (pair_common.getValue().equals(maxCommonEntry)) {
                Integer key = pair_common.getKey();
                this.resCommonValues.add(key);
            }
        }
    }

    public void printCommonValues() {
        System.out.println(this.resCommonValues);
    }
}
