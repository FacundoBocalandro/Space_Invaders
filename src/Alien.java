import java.awt.*;

public abstract class Alien extends GameObject implements Commons{
    int score;
    int numberOfTicks;
    int initialX;

    public Alien(int x, int y, Handler handler, String imageString) {
        super(x, y, handler, imageString);
        setSpeedX(1);
        initialX = x;
    }
    public void tick(){
            numberOfTicks++;
            if (numberOfTicks % 10 == 0) {
                speedY = 0;
                if (x + speedX >= BOARD_WIDTH - (228 - initialX)) {
                    speedX = -1;
                    speedY = 5;
                } else if (x + speedX <= initialX - 18) {
                    speedX = 1;
                    speedY = 5;
                }
                setX(x += speedX);
                setY(y += speedY);
            }
            int randomNumber = (int)(Math.random() * 100000) + 1;
            if (randomNumber < 5){
                handler.addObject(new AlienShot(x, y, handler));
            }


    }
    public void getShotCollision(PlayerShot shot){
        shot.getAlienCollision(this);
        handler.increaseScore(score);
        handler.removeAlien(this);
    }
}
