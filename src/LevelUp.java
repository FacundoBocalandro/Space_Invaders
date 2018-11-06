import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LevelUp extends MouseAdapter {
    SpaceInvaders game;
    Handler handler;
    HUD hud;
    Spawn spawn;
    int continueX = 95, buttonWidth = 150, buttonHeight = 40, continueY = 150;

    public LevelUp(SpaceInvaders game, Handler handler, HUD hud, Spawn spawn) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
        this.spawn = spawn;
    }

    public void mouseReleased(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if (mouseOver(mx, my, continueX, continueY, buttonWidth, buttonHeight)){
            handler.restartObjects();
            game.setGameState(new InGameState(handler, hud, spawn));
            
        }
    }
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }
        }
        return false;
    }
    public void render(Graphics g, int level){
        g.setFont(new Font("arial", 1, 40));
        g.setColor(Color.red);
        g.drawString("Level: " + level, 95, 100);
        g.setFont(new Font(Font.MONOSPACED, 1, 25));
        g.setColor(Color.white);
        g.drawRect(continueX, continueY, buttonWidth, buttonHeight);
        g.drawString("Continue", 110, 180);

    }
}
