


import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player extends GameObject implements Commons{
    int lives, score;



    public Player(int x, int y, Handler handler) {
        super(x, y, handler, "Space_Invaders/images/player.png");
        lives = 3;
        score = 0;


    }

    public void tick() {
        if (x + speedX <= 0 || x + speedX >= BOARD_WIDTH - 48) {
            speedX = 0;
        }
        setX(x += speedX);

    }
    public void getShotCollision(AlienShot shot){
        lives --;
        shot.getPlayerCollision(this);
        if (lives == -1){
            handler.endGame();
        }
    }


    public int getLives() {
        return lives;
    }
    public void increaseScore(int increase){
        score += increase;
    }
    public int getScore(){
        return score;
    }
}