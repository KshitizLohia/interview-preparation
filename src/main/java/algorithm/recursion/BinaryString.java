package algorithm.recursion;

import java.util.Arrays;


public class BinaryString {

    public static void main(String[] args) {
        binary(new int[4],4);
    }

    /**
     * BACKTRACKING: Generate all string of n bits
     */
    static void binary(int[] A,int n) {
        if (n == 0) {
            System.out.println(Arrays.toString(A));
        } else {
            A[n-1] = 0;
            binary(A,n-1);
            A[n-1] = 1;
            binary(A,n-1);
        }
    }
}
