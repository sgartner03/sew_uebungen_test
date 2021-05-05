import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(1000);
        CounterRunner c1 = new CounterRunner(counter);
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c1);
        Thread t3 = new Thread(c1);
        Thread t4 = new Thread(c1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        TimeUnit.MILLISECONDS.sleep(500);
        c1.stop();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("Ende");

    }
}
