package algorithm.recursion;

import java.util.Arrays;

public class StringOfLengthK {
    public static void main(String[] args) {
        karyString(new int[4], 4, 3);
    }

    /**
     * Generate all strings of length n drawn from 0 to k-1
     * @param n lenth
     * @param k bits that we can choose from 0 to k-1
     */
    static void karyString(int[] A, int n, int k) {
        if (n == 0 || n == 1) {
            System.out.println(Arrays.toString(A));
            return;
        }
        for (int i=0; i<k; i++) {
            A[n-1] = i;
            karyString(A, n-1, k);
        }
    }
}
