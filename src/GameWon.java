import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWon extends MouseAdapter implements MouseOver{
    int homeX = 95, buttonWidth = 150, buttonHeight = 40, homeY = 150;
    SpaceInvaders game;

    public GameWon(SpaceInvaders game){
        this.game = game;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mouseOver(mx,my,homeX, homeY, buttonWidth, buttonHeight)){
            game.menu();
            game.restartGame();
        }
    }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 35));
        g.drawString("Game Won", 85, 95);
        g.setColor(Color.white);
        g.fillRect(homeX, homeY, buttonWidth, buttonHeight);
        g.setColor(Color.black);
        g.drawString("Home", 128, 180);
    }

    public void tick(){}

}
