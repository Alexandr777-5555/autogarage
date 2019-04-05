package garage.app.ui.main;

import javafx.application.Application;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *  проверяем что приложение JavaFx запускается {@link Main}
 *
 */

public  class MainTest  {

    private volatile boolean success = false;

    @Test
    public void testMain() {
        Thread thread = new Thread() { // Wrapper thread.
            @Override
            public void run() {
                try {
                    Application.launch(Main.class); // запускаем JavaFX app.
                    success = true;
                } catch(Throwable ex) {
                    if(ex.getCause() != null && ex.getCause().getClass().equals(InterruptedException.class)) {

                        success = true;
                        return;
                    }

                }
            }
        };
        thread.setDaemon(true);
        thread.start();
        try {
            thread.interrupt();
            Thread.sleep(3000);
        } catch(InterruptedException ex) {

        }

        try {
            thread.join(1);
        } catch(InterruptedException ex) {

        }
        assertTrue(success);
    }

}