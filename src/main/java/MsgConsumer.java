import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MsgConsumer implements Runnable {
    private Nachrichtenspeicher ns;

    public MsgConsumer(Nachrichtenspeicher ns) {
        this.ns = ns;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(ns.getMessage());
        }
    }
}
