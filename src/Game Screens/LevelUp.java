import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class LevelUp extends MouseAdapter implements MouseOver {
    Handler handler;
    int continueX = 70, buttonWidth = 200, buttonHeight = 58, continueY = 150;

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
        g.setFont(new Font(Font.MONOSPACED, 1, 35));
        g.setColor(Color.orange);
        g.drawString("Level: " + level, 85, 90);
        /*g.setFont(new Font(Font.MONOSPACED, 1, 25));
        g.setColor(Color.white);
        g.fillRect(continueX, continueY, buttonWidth, buttonHeight);
        g.setColor(Color.black);
        g.drawString("Continue", 110, 180);*/
        try {
            g.drawImage(ImageIO.read(new File("images/ContinueButton.png")), continueX, continueY, null);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
