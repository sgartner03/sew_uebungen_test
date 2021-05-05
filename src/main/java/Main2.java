import java.util.concurrent.TimeUnit;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(1000);
        CounterRunner2 t1 = new CounterRunner2(counter);
        CounterRunner2 t2 = new CounterRunner2(counter);
        CounterRunner2 t3 = new CounterRunner2(counter);
        CounterRunner2 t4 = new CounterRunner2(counter);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        TimeUnit.MILLISECONDS.sleep(500);
        t1.halt();
        t2.halt();
        t3.halt();
        t4.halt();

    }
}
