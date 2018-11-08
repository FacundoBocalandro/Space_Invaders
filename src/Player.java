


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Player extends GameObject implements Commons{
    int lives, score;
    PlayerState state;
    int succesfulShots;
    boolean powerActivated;
    int numberOfTicksWithPower;

    public Player(int x, int y, Handler handler) {
        super(x, y, handler, "Space_Invaders/images/player.png");
        lives = 3;
        score = 0;
        state = new NormalPlayer();
        powerActivated = false;
        numberOfTicksWithPower = 0;

    }

    public void tick() {
        if (x + speedX <= 0 || x + speedX >= BOARD_WIDTH - 48) {
            speedX = 0;
        }
        setX(x += speedX);
        collides();
        state.freezeAliens(handler);
        if (powerActivated){
            numberOfTicksWithPower ++;
            if (numberOfTicksWithPower == 1500){
                state.deactivate(this, handler);
                powerActivated = false;
                System.out.println("deactivated");
                numberOfTicksWithPower = 0;
            }

        }

    }

    private void collides() {
        LinkedList<Alien> aliens = handler.getAliens();
        for (int i = 0; i < aliens.size(); i++) {
            Alien alien = aliens.get(i);
            if (SpaceInvaders.collides(this, alien)){
                this.getAlienCollision(alien);
            }

        }
    }
    public void getAlienCollision(Alien alien){
        handler.endGame();
    }

    public void getShotCollision(AlienShot shot){
        state.getAlienShotCollision(shot, this);
    }
    public void reduceLives(){
        lives --;
        if (lives == -1){
            handler.endGame();
        }
    }
    public void shoot(){
        state.shoot(this, handler);
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

    public void increaseSuccesfulShots() {
        succesfulShots ++;
        if (succesfulShots == 4){
            int random = (int)(Math.random()*100);
            if (random <= 20){
                setState(new Inmunity());
                System.out.println("Inmunity");
            }else if (random <= 30){
                setState(new FreezeInvaders());
                System.out.println("Freeze");
            }else{
                setState(new DoubleShot());
                System.out.println("Double Shot");
            }
            powerActivated = true;

        }
    }
    public void resetSuccesfulShots(){
        succesfulShots = 0;
    }
    public void setNormalPlayer(){
        setState(new NormalPlayer());
    }
    public void setState(PlayerState state){
        this.state = state;
    }
}