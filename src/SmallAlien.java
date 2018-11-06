import java.awt.*;

public class SmallAlien extends Alien {
    public SmallAlien(int x, int y, Handler handler) {
        super(x, y, handler, "Space_Invaders/images/smallalien.png");
        setSpeedX(1);
        score = SMALLALIEN_POINTS;
    }
}
