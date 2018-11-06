import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter implements Commons{
    int buttonX = 95, buttonWidth = 150, buttonHeight = 40, playY = 100, colorY = 150, quitY = 200;
    private SpaceInvaders game;
    private Handler handler;
    private HUD hud;
    private Spawn spawn;
    public Menu(SpaceInvaders game, Handler handler, HUD hud, Spawn spawn){
        this.game = game;
        this.hud = hud;
        this.spawn = spawn;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        //Play Button
        if(mouseOver(mx, my, buttonX, playY, buttonWidth, buttonHeight)){
            game.setGameState(new InGameState(handler, hud, spawn));
        }
        //Quit Button
        if (mouseOver(mx, my, buttonX, quitY, buttonWidth, buttonHeight)){
            System.exit(0);
        }

    }
    public void mouseReleased(MouseEvent e){}
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }
        }
        return false;
    }
    public void tick(){}
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
        g.drawString("Color", 140, 180);
        g.drawString("Quit", 145, 230);

    }
}
