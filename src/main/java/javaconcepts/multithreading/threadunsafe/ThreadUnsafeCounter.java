package javaconcepts.multithreading.threadunsafe;

public class ThreadUnsafeCounter {
    private int count;

    /**
     * 1. Read value from register
     * 2. Add 1 value to the count;
     * 3. Store value in the register
     */
    public void incrementCounter() {
        count++;
    }

    public void decrementCounter() {
        count--;
    }

    public void printCounter() {
        System.out.println(count);
    }
}
