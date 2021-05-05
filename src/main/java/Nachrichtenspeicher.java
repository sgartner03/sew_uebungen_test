import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Nachrichtenspeicher {
    private Queue<String> messages = new LinkedList<>();
    private int max;
    private final Lock lock = new ReentrantLock();
    private final Condition isNotFull = lock.newCondition();
    private final Condition isNotEmpty = lock.newCondition();

    public Nachrichtenspeicher(int max) {
        this.max = max;
        System.out.println("h");
    }

    public void saveMessage(String msg) {
        lock.lock();
        try {
            while (messages.size() >= max) {
                try {
                    isNotFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            messages.add(msg);
            isNotEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getMessage() {
        lock.lock();
        try {
            while (messages.size() <= 0) {
                try {
                    isNotEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String msg = messages.poll();
            isNotFull.signalAll();
            return msg;
        } finally {
            lock.unlock();
        }
    }
}
