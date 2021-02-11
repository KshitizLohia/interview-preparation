package datastructures.array.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 */
public class SmallestSubArrayWithGivenSum {

    public static int smallestSubArray(int[] a, int k) {
        int windowStart = 0;
        int windowSum = 0;
        int minimumLength = Integer.MAX_VALUE;
        for (int windowEnd=0;windowEnd<a.length; windowEnd++) {
            windowSum +=  a[windowEnd];
            if (windowSum >= k) {
                int windowSize = windowEnd - windowStart + 1;
                if (windowSize < minimumLength) {
                    minimumLength = windowSize;
                }
                windowSum -= a[windowStart];
                windowStart++;
            }
        }
        return minimumLength;
    }

    public static void main(String[] args) {
        final int[] a = {2, 1, 5, 2, 3, 2};
        System.out.println(smallestSubArray(a, 7));
    }

}
