package algorithm.recursion;

public class TowersOfHanoi {

    /**
     * 3 disks
     * Smallest disk on the top
     * Move entire datastructures.stack to another disk
     * @param args
     * 1. Move n-1 disks from source to auxiliary
     * 2. Move nth disk from source to destination
     * 3. Move n-1 disks from auxillary to destination
     */
    public static void main(String[] args) {
        towersOfHanoi(3, 'f', 't','a');
    }

    static void towersOfHanoi(int n, char from, char to, char aux) {
        // base condition
        if (n == 1) {
            System.out.println("Move disk 1 from "+  from + " to "+  to);
            return;
        }
        // recursive condition
        // move n-1 from source to auxillary
        towersOfHanoi(n-1, from, aux, to);
        // move nth disk from source to auxillary
        System.out.println("Move disk "+ n + " from "+  from + " to "+  to);
        // move n-1 disks from auxillary to destination
        towersOfHanoi(n-1, aux, to, from);

    }
}
