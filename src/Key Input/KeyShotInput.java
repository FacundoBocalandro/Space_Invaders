import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyShotInput extends KeyAdapter {
    private Handler handler;
    private boolean spacePressed;

    public KeyShotInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_SPACE){
            if(!spacePressed && !handler.isPaused()) {
                handler.getPlayer().shoot();
                spacePressed = true;
            }
        }

    }
    public void keyReleased(KeyEvent e){
        spacePressed = false;

    }
}
