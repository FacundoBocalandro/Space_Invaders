import java.awt.*;

public abstract class Shot extends GameObject{

    public Shot(int x, int y, Handler handler, String imageString){
        super(x, y, handler, imageString);
    }
    public void tick(){
        setY(y += speedY);
        collision();
    }
    public abstract void collision();
    public abstract boolean outOfBounds();

}
