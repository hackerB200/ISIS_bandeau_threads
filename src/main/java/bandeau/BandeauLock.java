package bandeau;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BandeauLock extends Bandeau {

    private final Lock verrou = new ReentrantLock();

    public boolean tryLock(int delay) throws InterruptedException {
        return verrou.tryLock(delay, TimeUnit.SECONDS);
    }

    public void releaseLock() {
        verrou.unlock();
    }


}
