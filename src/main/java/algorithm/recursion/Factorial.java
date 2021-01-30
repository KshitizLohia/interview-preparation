package algorithm.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(2));
        System.out.println(factorial(3));
    }

    /**
     * Each recursive calls ake a new copy of that method
     *
     * @param n number for which we have to find factorial: Recursion adds a overhead for each recursive call
     * @return factorial of the number
     */
    public static int factorial(int n) {
        // base case
        if (n <= 1) return 1;
        // recursive case
        else {
            return n * factorial(n-1);
        }
    }
}
