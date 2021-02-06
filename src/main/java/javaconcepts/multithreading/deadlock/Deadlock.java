package javaconcepts.multithreading.deadlock;

public class Deadlock {

    private int counter = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void runTest() throws InterruptedException {
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100000; i++) {
                    synchronized (lock1) {
                        synchronized (lock2) {
                            counter++;
                        }
                    }


                }
            }
        });

        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100000; i++) {
                    synchronized (lock2) {
                        synchronized (lock1) {
                            counter--;
                        }
                    }
                }
            }
        });

        one.start();
        two.start();
        one.join();
        two.join();
    }

    public static void main(String[] args) throws InterruptedException {
        Deadlock d1 = new Deadlock();
        d1.runTest();
    }
}
