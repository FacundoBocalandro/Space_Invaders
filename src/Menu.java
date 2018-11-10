import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter implements Commons, MouseOver{
    int buttonX = 95, buttonWidth = 150, buttonHeight = 40, playY = 100, highscoreY = 150, quitY = 200;
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
        g.setFont(new Font("arial", 1, 40));
        g.setColor(Color.white);
        g.drawString("Menu", 125, 70);

        g.setColor(Color.green);
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
        g.drawString("LeaderBoard", 100, 180);

    }
}
