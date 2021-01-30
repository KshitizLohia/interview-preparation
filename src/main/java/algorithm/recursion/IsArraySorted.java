package algorithm.recursion;

public class IsArraySorted {
    public static void main(String[] args) {
        System.out.println(isArraySorted(new int[]{1,3, 2}, 0));
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param A datastructures.array
     * @param index starting index
     * @return true or false on basis whether datastructures.array is sorted or not sorted
     */
    static boolean isArraySorted(int[] A, int index) {
        if (A.length == 1 || index == A.length - 1) {
            return true;
        }
        if (A[index] < A[index+1]) {
            return isArraySorted(A, index+1);
        } else {
            return false;
        }
    }
}
