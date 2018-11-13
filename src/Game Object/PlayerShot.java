import java.awt.*;
import java.util.LinkedList;

public class PlayerShot extends Shot{
    Player player;
    int numberOfTicks;
    public PlayerShot(int x, int y, Handler handler, Player player){
        super(x, y, handler, "images/shot.png");
        setSpeedY(-1);
        this.player = player;
        numberOfTicks = 0;

    }
    public void tick(){
        numberOfTicks ++;
        if (numberOfTicks % 3 == 0) {
            setY(y += speedY);
        }
        collision();
        if (outOfBounds()){
            player.resetSuccesfulShots();
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
        player.increaseSuccesfulShots();
        handler.removeObject(this);
    }
    public void getShieldCollision(Shield shield){
        player.resetSuccesfulShots();
        handler.removeObject(this);}
    public void getUfoCollision(Ufo ufo){
        player.increaseSuccesfulShots();
        handler.removeObject(this);
    }

}
