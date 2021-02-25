package datastructures.array.cyclicsort;

/**
 * Write a function to sort the objects in-place on their creation sequence number in O(n)O(n)
 * and without any extra space. For simplicity, let’s assume we are passed an integer array
 * containing only the sequence numbers, though each number is actually an object.
 *
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 */
public class CyclicSort {

    public static int[] cyclicSort(int[] a) {
        int i = 0;
        while (i < a.length) {
            System.out.println(a[i]);
            System.out.println(i+1);
            System.out.println("---");
            while (a[i] != i+1) {
                swap(a, a[i]-1, i);
            }
            i++;
        }
        return a;
    }

    public static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }


    public static void main(String[] args) {
        int[] n = {3,1,5,4,2};
        int[] res = cyclicSort(n);
        for (int i=0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
}
