import java.awt.*;
import java.util.LinkedList;

public class AlienShot extends Shot {
    int numberOfTicks;
        public AlienShot(int x, int y, Handler handler){
        super(x, y, handler, "images/shot.png");
        setSpeedY(1);

    }
    public void tick(){
        numberOfTicks ++;
        if (numberOfTicks % 5 == 0) {
            setY(y += speedY);
            collision();
            if (outOfBounds()) {
                handler.removeObject(this);
            }
        }

    }
    public void collision(){
        LinkedList<GameObject> objects = handler.getObjects();
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = handler.getObjects().get(i);
            if (SpaceInvaders.collides(this, object)) {
                collides(object);

            }

        }
    }
    public boolean outOfBounds(){
        if (y + speedY >= BOARD_HEIGHT){
            return true;
        }
        return false;
    }
    public void collides (GameObject object){
        object.getShotCollision(this);
    }
    public void getPlayerCollision(Player player){
        handler.removeObject(this);
    }
    public void getShieldCollision(Shield shield){ handler.removeObject(this);}
}
