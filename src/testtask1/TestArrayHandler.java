package testtask1;

import java.util.Arrays;
import java.util.Random;

//1 Task
public class TestArrayHandler {
    private final Integer[] innerArray;

    public TestArrayHandler(int size) {
        this.innerArray = new Integer[size];
        this.randomArrayElms();
    }

    public void randomArrayElms() {
        Random random = new Random();
        for (int i = 0; i < this.innerArray.length; ++i) {
            this.innerArray[i] = random.nextInt(1, 50);
        }
        // специально добавляю нули
        this.innerArray[0] = 0;
        this.innerArray[1] = 0;
    }

    public void printArray() {
        System.out.println("Начало вывода массива");
        for (int num : this.innerArray) {
            System.out.print(num);
            System.out.print(" ");
        }

        System.out.println("\nКонец вывода массива");
    }

    public void reOrderElms() {
        Arrays.sort(this.innerArray, new TestIntegerComparator());
    }
}
