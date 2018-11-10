import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LevelUp extends MouseAdapter implements MouseOver {
    Handler handler;
    int continueX = 95, buttonWidth = 150, buttonHeight = 40, continueY = 150;

    public LevelUp(Handler handler) {
        this.handler = handler;
    }

    public void mouseReleased(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if (mouseOver(mx, my, continueX, continueY, buttonWidth, buttonHeight)){
            handler.restartObjects();
            handler.inGame();

        }
    }
    public void render(Graphics g, int level){
        g.setFont(new Font("arial", 1, 40));
        g.setColor(Color.red);
        g.drawString("Level: " + level, 95, 100);
        g.setFont(new Font(Font.MONOSPACED, 1, 25));
        g.setColor(Color.white);
        g.fillRect(continueX, continueY, buttonWidth, buttonHeight);
        g.setColor(Color.black);
        g.drawString("Continue", 110, 180);

    }
}
