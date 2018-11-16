import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Ranking extends MouseAdapter implements MouseOver{
    int homeX = 230, buttonWidth = 100, buttonHeight = 100, homeY = 100;
    Handler handler;

    public Ranking(Handler handler) {
        this.handler = handler;
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mouseOver(mx,my,homeX, homeY, buttonWidth, buttonHeight)){
            handler.menu();
        }
    }

    public void render(Graphics g, HighScore highScore){
        List<String> highScores = highScore.getHighScores();
        int counter = 1;
        g.setColor(Color.green);
        g.setFont(new Font(Font.MONOSPACED, 0, 30));
        g.drawString("HighScores", 70,32);
        g.setFont(new Font(Font.MONOSPACED, 0, 20));
        for (String highscore : highScores){
            String[] parts = highscore.split("-");
            String name = parts[0];
            int score = Integer.parseInt(parts[1]);
            g.drawString(counter + ". " + name + ": " + score, 20, 35 + 25*counter );
            counter ++;
        }
        g.fillRect(homeX, homeY, buttonWidth, buttonHeight);
        g.setColor(Color.black);
        g.setFont(new Font(Font.SERIF, 1, 40));
        g.drawString("Back", 235, 162);

    }
}
