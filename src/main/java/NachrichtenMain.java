public class NachrichtenMain {
    public static void main(String[] args) {
        Nachrichtenspeicher ns = new Nachrichtenspeicher(20);

        Thread w1 = new Thread(new MsgProducer(ns));
        Thread w2 = new Thread(new MsgProducer(ns));
        Thread w3 = new Thread(new MsgProducer(ns));
        Thread r1 = new Thread(new MsgConsumer(ns));
        Thread r2 = new Thread(new MsgConsumer(ns));
        Thread r3 = new Thread(new MsgConsumer(ns));

        w1.start();
        w2.start();
        w3.start();
        r1.start();
        r2.start();
        r3.start();
    }
}
