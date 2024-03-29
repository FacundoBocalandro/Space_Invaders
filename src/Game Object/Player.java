


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
    int numberOfTicks;
    long initialPowerTime;

    public Player(int x, int y, Handler handler) {
        super(x, y, handler, "images/player.png");
        lives = 3;
        score = 0;
        state = new NormalPlayer();
        powerActivated = false;
        numberOfTicks = 0;

    }

    public void tick() {
        numberOfTicks ++;
        if(numberOfTicks % 5 == 0) {
            if (x + speedX <= 0 || x + speedX >= BOARD_WIDTH - 48) {
                speedX = 0;
            }
            setX(x += speedX);
            state.move(x);
        }
        collides();
        if (powerActivated){
            long timeWithPower = System.currentTimeMillis() - initialPowerTime;
            if (timeWithPower >= 4000){
                state.deactivate(this, handler);
                System.out.println("deactivated");
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
            PlayerState newState;
            int random = (int)(Math.random()*100);
            if (random <= 20){
                newState = new Inmunity();
                System.out.println("Inmunity");
            }else if (random <= 30){
                newState = new FreezeInvaders();
                System.out.println("Freeze");
            }else{
                newState = new DoubleShot();
                System.out.println("Double Shot");
            }
                setState(newState);
                powerActivated = true;
                initialPowerTime = System.currentTimeMillis();

        }
    }
    public void resetSuccesfulShots(){
        succesfulShots = 0;
    }
    public void setNormalPlayer(){
        setState(new NormalPlayer());
        powerActivated = false;
    }
    public void setState(PlayerState state){
        this.state = state;
        state.activate(handler, this);
    }
}