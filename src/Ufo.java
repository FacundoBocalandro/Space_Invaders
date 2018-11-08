import java.awt.*;

public class Ufo extends GameObject implements Collision{
    int numberOfTicks;
    int score;
    public Ufo(int x, int y, Handler handler){
        super(x, y, handler, "Space_Invaders/images/UFO.png");
        setSpeedX(1);
        numberOfTicks = 0;
        score = (int)(Math.random() * 250 + 30);
    }

    @Override
    public void tick() {
        numberOfTicks ++;
        if (numberOfTicks % 10 == 0){
            setX(x + speedX);
        }
        if (outOfBounds()){
            handler.removeObject(this);
        }

    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }
    public boolean outOfBounds(){
        if (x + speedX >= BOARD_HEIGHT){
            return true;
        }
        return false;
    }

    public void getShotCollision(PlayerShot shot){
        shot.getUfoCollision(this);
        handler.allienKilled(score);
        handler.removeObject(this);
    }
}
