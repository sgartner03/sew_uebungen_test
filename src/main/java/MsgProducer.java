import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MsgProducer implements Runnable {
    private Nachrichtenspeicher ns;

    public MsgProducer(Nachrichtenspeicher ns) {
        this.ns = ns;
    }

    @Override
    public void run() {
        for(int i = 0; ; i++) {
            ns.saveMessage(i + "");
        }
    }
}
