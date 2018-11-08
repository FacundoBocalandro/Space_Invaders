import java.awt.*;

public abstract class Alien extends GameObject implements Commons{
    int score;
    int numberOfTicks;
    int initialX;
    int ticksToChangeX;
    int currentSpeedY;
    boolean doTick;

    public Alien(int x, int y, Handler handler, String imageString, int currentSpeedY) {
        super(x, y, handler, imageString);
        setSpeedX(1);
        ticksToChangeX = 20 - (3 * handler.getLevel());
        if (ticksToChangeX <= 0){
            ticksToChangeX = 1;
        }
        this.currentSpeedY = currentSpeedY;
        initialX = x;
        doTick = true;
    }
    public void tick(){
            if(doTick) {
                numberOfTicks++;
                if (numberOfTicks % ticksToChangeX == 0) {
                    speedY = 0;
                    if (x + speedX >= BOARD_WIDTH - (228 - initialX)) {
                        speedX = -1;
                        speedY = currentSpeedY;
                    } else if (x + speedX <= initialX - 18) {
                        speedX = 1;
                        speedY = currentSpeedY;
                    }
                    setX(x += speedX);
                    setY(y += speedY);
                }
            }
        outOfBounds();
        shoot();

    }

    private void outOfBounds() {
        if (y >= BOARD_HEIGHT){
            handler.endGame();

        }    }

    public void shoot(){
        int randomNumber = (int)(Math.random() * 100000) + 1;
        if (randomNumber < 15){
            handler.addObject(new AlienShot(x, y, handler));
        }

    }
    public void getShotCollision(PlayerShot shot){
        shot.getAlienCollision(this);
        handler.allienKilled(score);
        handler.removeAlien(this);
    }
    public void setDoTick(Boolean bool){
        doTick = bool;
    }
}
