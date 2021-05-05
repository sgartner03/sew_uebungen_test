import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter2 {
    private int z;

    public Counter2(int z) {
        this.z = z;
    }

    public synchronized void decrement() {
        z-=1;
        System.out.println(z);
    }
}