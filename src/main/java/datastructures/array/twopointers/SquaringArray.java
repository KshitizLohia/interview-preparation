package datastructures.array.twopointers;

import java.util.Map;

/**
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 */
public class SquaringArray {

    public static double[] squareArray(int[] a) {
        double[] squares = new double[a.length];
        int firstNonNegative = 0;
        while (a[firstNonNegative] < 0) {
            firstNonNegative ++;
        }
        int start = 0;
        int firstNegative = firstNonNegative - 1;
        int firstPostive = firstNonNegative;
        while (firstNegative >= 0 && firstPostive < a.length) {
            if (Math.abs(a[firstNegative]) < Math.abs(a[firstPostive])) {
                squares[start] = a[firstNegative] * a[firstNegative];
                start ++;
                firstNegative --;
            } else if (Math.abs(a[firstNegative]) >= Math.abs(a[firstPostive])) {
                squares[start] = a[firstPostive] * a[firstPostive];
                start ++;
                firstPostive ++;
            }
        }
        while (firstNegative >= 0) {
            squares[start] = a[firstNegative] * a[firstNegative];
            start ++;
            firstNegative --;
        }
        while (firstPostive < a.length) {
            squares[start] = a[firstPostive] * a[firstPostive];
            start ++;
            firstPostive ++;
        }
        return squares;
    }

    public static void print(double[] a) {
        for (int i=0; i< a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {-2, -1, 0, 2, 3};
        print(squareArray(a));
    }
}
