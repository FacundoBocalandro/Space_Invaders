import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class GameWon extends MouseAdapter implements MouseOver{
    int homeX = 95, buttonWidth = 150, buttonHeight = 150, homeY = 105;
    Handler handler;

    public GameWon(Handler handler){
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mouseOver(mx,my,homeX, homeY, buttonWidth, buttonHeight)){
            handler.menu();
            handler.restartGame();
        }
    }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
        g.drawString("Game Won", 85, 60);
        try {
            g.drawImage(ImageIO.read(new File("images/HomeButton.png")), homeX, homeY, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tick(){}

}
