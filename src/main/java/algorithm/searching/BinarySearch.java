package algorithm.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 7, 9};
        System.out.println(binarySearchIterative(a, 4));
        System.out.println(binarySearchRecursive(a, 4, 0, a.length));

    }

    public static int binarySearchIterative(int[] a, int search) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == search) return mid;
            if (a[mid] < search) {
                low = mid + 1;
            } else if (a[mid] > search) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] a, int search, int low, int high) {
        int mid = (low + high)/2;
        // base case
        if (low > high) return -1;

        // recursive cases
        if (a[mid] == search) return mid;
        else if (a[mid] < search) return binarySearchRecursive(a, search, mid+1, high);
        else return binarySearchRecursive(a, search, low, mid-1);
    }
}
