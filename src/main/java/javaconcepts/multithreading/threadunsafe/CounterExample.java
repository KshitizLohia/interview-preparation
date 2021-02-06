package javaconcepts.multithreading.threadunsafe;

import java.util.Random;

public class CounterExample {

    public int counter = 0;
    public static Random r1 = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();
        Thread one = new Thread(() -> {
            for (int i = 0 ;i< 100; i++) {
                badCounter.incrementCounter();
                try {
                    Thread.sleep(r1.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0 ;i< 100; i++) {
                badCounter.decrementCounter();
                try {
                    Thread.sleep(r1.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        // run both threads
        one.start();
        two.start();
        // wait for them to complete
        one.join();
        two.join();
        badCounter.printCounter();


        badCounter.incrementCounter();
    }
}

