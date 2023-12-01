package testtask4;

import java.util.ArrayList;

public class ArraySeparator {
    private int L;
    private final int K;
    private boolean isFound;
    private ArrayList<ArrayList<Integer>> resArrays;
    public ArraySeparator(int[] elements, int K) {
        this.resArrays = new ArrayList<>();
        this.isFound = false;
        this.K = K;
        int arraySum = 0;
        for(int elem: elements) {
            arraySum+=elem;
        }
        System.out.print("Сумма всех элементов ");
        System.out.println(arraySum);
        System.out.print("K = ");
        System.out.println(this.K);
        int tempKSum = 0;
        for(int i = 1; i < this.K; ++i) {
            tempKSum += i;
        }
        if ((arraySum-tempKSum)%this.K != 0) {
            System.out.println("Невозможно");
        } else {
            this.L = (arraySum-tempKSum)/this.K;
            System.out.print("L = ");
            System.out.println(this.L);
            permutationRec(elements.length, elements);
            if (!isFound) {
                System.out.println("Невозможно");
            }
        }
    }

    private void swap(int[] elements, int a, int b) {
        int tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

    private void divideParts(int[] elements) {
        int tempL = this.L;
        ArrayList<Integer> tempAr = new ArrayList<>();
        int tempSum = 0;
        for (int elem: elements) {
            tempSum+=elem;
            if (tempSum < tempL) {
                tempAr.add(elem);
            }
            if (tempSum == tempL) {
                tempAr.add(elem);
                this.resArrays.add(tempAr);
                tempAr = new ArrayList<>();
                tempL++;
                tempSum = 0;
            }
            if (tempSum > tempL) {
                this.resArrays.clear();
                return;
            }
        }
        System.out.println("Найдено");
        for (ArrayList<Integer> ar: this.resArrays) {
            System.out.print("[");
            int innerSum = 0;
            for (int i = 0; i < ar.size(); ++i) {
                System.out.print(ar.get(i));
                innerSum+=ar.get(i);
                if (i != ar.size()-1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.print(":");
            System.out.print(innerSum);
            System.out.print(" ");
        }
        isFound = true;
        System.out.println();
    }

    private void permutationRec(int n, int[] elements) {
        if (this.isFound) {
            return;
        }
        if (n == 1) {
            divideParts(elements);
        } else {
            for(int i = 0; i < n-1; i++) {
                permutationRec(n - 1, elements);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            permutationRec(n - 1, elements);
        }
    }
}
