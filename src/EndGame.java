import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class EndGame extends MouseAdapter implements MouseOver{
    int homeX = 120, buttonWidth = 100, buttonHeight = 100, homeY = 150;
    Handler handler;

    public EndGame(Handler handler){
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mouseOver(mx,my,homeX, homeY, buttonWidth, buttonHeight)){
            handler.restartGame();
            handler.menu();
        }
    }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
        g.drawString("Game Over", 80, 95);
        try {
            g.drawImage(ImageIO.read(new File("images/HomeButton.png")), homeX, homeY, null);
        } catch (IOException e) {
        }
    }
}
