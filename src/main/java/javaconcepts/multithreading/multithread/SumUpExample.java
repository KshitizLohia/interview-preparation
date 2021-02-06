package javaconcepts.multithreading.multithread;

public class SumUpExample {
    private final int start;
    private final int end;
    private long counter = 0;
    private static int MAX = Integer.MAX_VALUE;

    public SumUpExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void add() {
        for (int i=this.start; i<this.end; i++) {
            counter+=i;
        }
    }

    static public void twoThread() throws InterruptedException {
        long start = System.currentTimeMillis();
        SumUpExample a = new SumUpExample(1, MAX/2);
        SumUpExample b = new SumUpExample(MAX/2+1, MAX);
        Thread t1 = new Thread(() -> {
            a.add();
        });
        Thread t2 = new Thread(() -> {
            b.add();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("Double thread time: "+ (end - start));
        System.out.println("Count: "+ (a.counter + b.counter));
    }

    static public void oneThread() {
        long start = System.currentTimeMillis();
        SumUpExample a = new SumUpExample(1, MAX);
        a.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread time: "+ (end - start));
        System.out.println("Count: "+ (a.counter));
    }

    public static void runTest() throws InterruptedException {
        oneThread();
        twoThread();
    }

    public static void main(String[] args) throws InterruptedException {
        SumUpExample.runTest();
    }
}
