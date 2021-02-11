package algorithm.dynamicprogramming.pattern1_0or1;

/**
 * Input: {1, 1, 2, 3}, S=4
 * Output: 3
 * The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
 * Note that we have two similar sets {1, 3}, because we have two '1' in our input.
 *
 *
 * s[a] =
 */
public class CountOfSubsetSumTopDown {

    public static int countSetsRecursive(int[] a, int sum, int index) {
        // base conditions
        if (sum == 0) return 1;
        if (index>=a.length) return 0;
        // recursive conditions
        // include ith Element
        int sum1 = 0;
        if (sum>=a[index]) {
            sum1 = countSetsRecursive(a, sum - a[index], index + 1);
        }
        int sum2 = countSetsRecursive(a, sum, index+1);
        return sum1 + sum2;
    }

    public static int countSets(int[] a, int sum) {
        return countSetsRecursive(a, sum, 0);
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3};
        System.out.println(countSets(a, 3));
    }
}
