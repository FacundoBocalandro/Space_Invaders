import java.awt.*;

public class BigAlien extends Alien{

    public BigAlien(int x, int y, Handler handler) {
        super(x, y, handler, "images/Bigalien.png");
        setSpeedX(1);
        score = BIGALIEN_POINTS;
    }
}
