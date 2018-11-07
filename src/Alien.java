import java.awt.*;

public abstract class Alien extends GameObject implements Commons{
    int score;
    int numberOfTicks;
    int initialX;
    int currentSpeedX;

    public Alien(int x, int y, Handler handler, String imageString, int currentSpeedX) {
        super(x, y, handler, imageString);
        this.currentSpeedX = currentSpeedX;
        setSpeedX(currentSpeedX);
        initialX = x;
    }
    public void tick(){
            numberOfTicks++;
            if (numberOfTicks % 10 == 0) {
                speedY = 0;
                if (x + speedX >= BOARD_WIDTH - (228 - initialX)) {
                    speedX = -currentSpeedX;
                    speedY = 1;
                } else if (x + speedX <= initialX - 18) {
                    speedX = currentSpeedX;
                    speedY = 1;
                }
                setX(x += speedX);
                setY(y += speedY);
            }
            shoot();


    }
    public void shoot(){
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
