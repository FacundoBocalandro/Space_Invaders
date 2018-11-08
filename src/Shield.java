import java.awt.*;
import java.util.LinkedList;

public class Shield extends GameObject{
    int numberOfHits;
    private static String imageString= "images/shield.png";
    public Shield(int x, int y, Handler handler) {
        super(x, y, handler, imageString);
        numberOfHits = 0;
    }
    public void tick(){
        collision();

    }

    public void collision() {
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

    public void getShotCollision(PlayerShot shot){
        shot.getShieldCollision(this);
        numberOfHits++;
        decreaseSize(numberOfHits);
    }
    public void getShotCollision(AlienShot shot){
        shot.getShieldCollision(this);
        numberOfHits++;
        decreaseSize(numberOfHits);

    }
    public void decreaseSize(int numberOfHits){
        switch (numberOfHits){
            case 16: setImg("images/shieldBroken1.png"); break;
            case 33: setImg("images/shieldBroken2.png"); break;
            case 50: handler.removeObject(this); break;
        }
    }
}
