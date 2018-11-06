import java.awt.*;

public class BigAlien extends Alien{

    public BigAlien(int x, int y, Handler handler) {
        super(x, y, handler, "Space_Invaders/images/Bigalien.png");
        setSpeedX(1);
        score = BIGALIEN_POINTS;
    }
}
