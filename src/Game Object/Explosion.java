import java.awt.*;

public class Explosion extends GameObject{
    int numberOfTicks;
    public Explosion(int x, int y, Handler handler){
        super(x, y, handler, "images/explosion.gif");
        numberOfTicks = 0;

    }
    @Override
    public void tick() {
        numberOfTicks ++;
        if (numberOfTicks == 50){
            handler.removeObject(this);
        }
    }
}
