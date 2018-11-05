import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            handler.getPlayer().setSpeedX(-1);
        }else if (key == KeyEvent.VK_RIGHT) {
            handler.getPlayer().setSpeedX(1);
        }

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        handler.getPlayer().setSpeedX(0);

    }
}
