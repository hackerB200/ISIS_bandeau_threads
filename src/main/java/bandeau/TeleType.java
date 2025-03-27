package bandeau;

/**
 * Un effet qui affiche les caractères du message un par un
 */
public class TeleType extends Effect {

    private final int myDelay;

    public TeleType(String message, int delay) {
        super(message);
        myDelay = delay;
    }

    @Override
    public void playOn(BandeauLock b) throws InterruptedException {
        try {
            if (b.tryLock(1000)) {
                super.init(b);
                String message = b.getMessage();
                for (int i = 0; i <= message.length(); i++) {
                    b.setMessage(message.substring(0, i));
                    b.sleep(myDelay);
                }
            }
        } finally {
            b.releaseLock();
        }

    }
}
