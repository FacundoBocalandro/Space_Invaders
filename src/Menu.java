import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter implements Commons, MouseOver{
    int buttonX = 95, buttonWidth = 150, buttonHeight = 40, playY = 100, colorY = 150, quitY = 200;
    private SpaceInvaders game;
    public Menu(SpaceInvaders game){
        this.game = game;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        //Play Button
        if(mouseOver(mx, my, buttonX, playY, buttonWidth, buttonHeight)){
            game.inGame();
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
        g.fillRect(buttonX, colorY, buttonWidth,buttonHeight);
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
