package javaconcepts.multithreading.deadlock;

public class NonReEntrantLock {
    private boolean isLocked;

    public NonReEntrantLock() {
        isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        NonReEntrantLock nreLock = new NonReEntrantLock();

        nreLock.lock();
        System.out.println("Acquired first lock");

        // Second locking results in a self deadlock
        System.out.println("Trying to acquire second lock");
        nreLock.lock();
        System.out.println("Acquired second lock");
    }
}
