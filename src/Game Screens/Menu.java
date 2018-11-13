import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Menu extends MouseAdapter implements Commons, MouseOver{
    int buttonX = 95, buttonWidth = 150, buttonHeight = 40, playY = 90, highscoreY = 150, quitY = 210;
    Handler handler;
    public Menu(Handler handler){
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        //Play Button
        if(mouseOver(mx, my, buttonX, playY, buttonWidth, buttonHeight)){
            handler.inGame();
        }
        // Highscore button
        if (mouseOver(mx, my, buttonX, highscoreY, buttonWidth, buttonHeight)){
            handler.ranking();
        }
        //Quit Button
        if (mouseOver(mx, my, buttonX, quitY, buttonWidth, buttonHeight)){
            System.exit(0);
        }

    }
    public void mouseReleased(MouseEvent e){}
    public void render(Graphics g){
        g.setFont(new Font(Font.MONOSPACED, 1, 35));
        g.setColor(Color.orange);
        g.drawString("Space Invaders", 36, 60);

        /*g.setColor(Color.green);
        g.fillRect(buttonX, playY, buttonWidth, buttonHeight);
        g.setColor(Color.red);
        g.fillRect(buttonX, highscoreY, buttonWidth,buttonHeight);
        g.setColor(Color.blue);
        g.fillRect(buttonX, quitY, buttonWidth,buttonHeight);
        Font font = new Font("arial", 1, 25);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("Play", 145, 130);
        g.drawString("Quit", 145, 230);
        g.setFont(new Font("arial", 1, 23));
        g.drawString("LeaderBoard", 100, 180);*/
        try {
            g.drawImage(ImageIO.read(new File("images/PlayButton.png")), buttonX, playY, null);
            g.drawImage(ImageIO.read(new File("images/HighScoresButton.png")), buttonX, highscoreY, null);
            g.drawImage(ImageIO.read(new File("images/QuitButton.png")), buttonX, quitY, null);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
