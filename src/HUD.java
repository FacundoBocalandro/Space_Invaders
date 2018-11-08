import java.awt.*;

public class HUD {
    Handler handler;
    public HUD(Handler handler){
        this.handler = handler;
    }
    public void tick(){}
    public void render(Graphics g){
        g.setColor(Color.red);
        Font f = new Font(Font.MONOSPACED, Font.PLAIN, 16);
        g.setFont(f);
        g.drawString("Lives: " + handler.getLives(),10,20);
        g.setColor(Color.green);
        g.drawString("Score: " + handler.getScore(),110,20);
        g.setColor(Color.BLUE);
        g.drawString("Level: " + handler.getLevel(), 235, 20);
    }
}
