public class CounterRunner2 extends Thread {
    private Counter counter;
    private boolean exec;

    public CounterRunner2(Counter counter) {
        this.counter = counter;
        exec = true;
    }

    public void halt() {
        exec = false;
    }

    @Override
    public void run() {

        while(exec) {
            counter.decrement();
        }
    }
}
