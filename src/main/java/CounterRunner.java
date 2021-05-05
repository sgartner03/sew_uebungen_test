public class CounterRunner implements Runnable {
    private Counter counter;
    private boolean exec;

    public CounterRunner(Counter counter) {
        this.counter = counter;
        exec = true;
    }

    public void stop() {
        exec = false;
    }

    @Override
    public void run() {

        while(exec) {
            counter.decrement();
        }
    }

}
