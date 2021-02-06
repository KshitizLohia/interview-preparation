package javaconcepts.multithreading.racecondition;

import java.util.Random;

public class RaceCondition {
    private int randInt;
    private Random random = new Random(System.currentTimeMillis());

    public void printer() {
        for (int i = 1000000; i>=0 ; i--) {
            // synchonized
            if (randInt % 5 == 0) {
                if (randInt % 5 != 0) {
                    System.out.println(randInt);
                }
            }
        }
    }

    public void modifier() {
        for (int i = 1000000; i>=0 ; i--) {
            // synchonized
            randInt = random.nextInt(1000);
        }
    }

    public static void runTest() throws InterruptedException {
        final RaceCondition rc = new RaceCondition();
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                rc.modifier();
            }
        });
        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                rc.printer();
            }
        });
        one.start();
        two.start();
        one.join();
        two.join();
    }

    public static void main(String[] args) throws InterruptedException {
        runTest();
    }
}
