package datastructures.array.twopointers;

public class PairWithTargetSum {

    public static boolean targetSum(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (low <=  high) {
            int value = a[low] + a[high];
            if (value < target) low++;
            else if (value > target) high--;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 6};
        System.out.println(targetSum(a, 10));
    }
}
