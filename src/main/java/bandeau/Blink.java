package bandeau;

/**
 * Un effet qui clignote le texte une fois, avec un délai à specifier
 */
public class Blink extends Effect {

    private final int myDelay;

    public Blink(String message, int delay) {
        super(message);
        myDelay = delay;
    }

    @Override
    public void playOn(BandeauLock bandeau) throws InterruptedException {
        try {
            if (bandeau.tryLock(1000)) {
                super.init(bandeau);
                String message = bandeau.getMessage();
                bandeau.setMessage("");
                bandeau.sleep(myDelay);
                bandeau.setMessage(message);
                bandeau.sleep(myDelay);
            }
        } finally {
            bandeau.releaseLock();
        }
    }

}
