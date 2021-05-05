import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int z;
    private final Lock lock = new ReentrantLock();

    public Counter(int z) {
        this.z = z;
    }

    public void decrement() {
        lock.lock();
        try {
            z-=1;
            System.out.println(z);
        } finally {
            lock.unlock();
        }
    }
}