import java.awt.*;
import java.util.LinkedList;

public class PlayerShot extends Shot{
    public PlayerShot(int x, int y, Handler handler){
        super(x, y, handler, "images/shot.png");
        setSpeedY(-1);

    }
    public void tick(){
        setY(y += speedY);
        collision();
        if (outOfBounds()){
            handler.removeObject(this);
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
        if (y + speedY <= 0){
            return true;
        }
        return false;
    }
    public void collides (GameObject object){
        object.getShotCollision(this);
    }
    public void getAlienCollision(Alien alien){
        handler.removeObject(this);
    }
    public void getShieldCollision(Shield shield){ handler.removeObject(this);}

}
