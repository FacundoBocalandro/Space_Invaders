import java.awt.*;

public class BigAlien extends Alien{

    public BigAlien(int x, int y, Handler handler, int currentSpeedX) {
        super(x, y, handler, "Space_Invaders/images/Bigalien.png", currentSpeedX);
        score = BIGALIEN_POINTS;
    }
}
