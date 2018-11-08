import java.awt.*;

public class SmallAlien extends Alien {
    public SmallAlien(int x, int y, Handler handler, int currentSpeedX) {
        super(x, y, handler, "images/smallalien.png", currentSpeedX);
        score = SMALLALIEN_POINTS;
    }
}
