package datastructures.array.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 */
public class SlidingWindowAverage {

    public static double[] computeSlidingAverageBruteforce(final int[] a, final int size) {
        double[] listOfAverage = new double[a.length - size + 1];
        for (int i = 0; i < a.length - size + 1; i++) {
            double sum = 0;
            for (int j = i; j < i + size; j++) {
                sum += a[j];
            }
            listOfAverage[i] = sum / size;
        }
        return listOfAverage;
    }

    public static double[] computeSlidingAverage(final int[] a, final int size) {
        double[] listOfAverage = new double[a.length - size + 1];
        int windowStart = 0;
        double windowSum = 0;
        for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
            windowSum += a[windowEnd];
            if (windowEnd >= size-1) {
                listOfAverage[windowStart] = windowSum/size;
                windowSum -= a[windowStart];
                windowStart++;
            }
        }
        return listOfAverage;

    }

    public static void printResults(double[] a) {
        for (int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }
        System.out.println("---");
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        printResults(computeSlidingAverageBruteforce(a, 5));
        printResults(computeSlidingAverage(a, 5));

    }

}
