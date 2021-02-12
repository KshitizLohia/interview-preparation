package datastructures.array.twopointers;

/**
 * Given an array of sorted numbers, remove all duplicates from it.
 * You should not use any extra space; after removing the duplicates in-place return the new length of the array.
 *
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 */
public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] a) {
        int nextNonDuplicate = 1;
        for (int i=1;i<a.length; i++) {
            if (a[nextNonDuplicate-1] != a[i]) {
                a[nextNonDuplicate] = a[i];
                nextNonDuplicate ++;
            }
        }
        return a;
    }

    public static void print(int[] a) {
        for (int i=0; i< a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 3, 3, 6, 9, 9};
        print(removeDuplicates(a));
    }
}
