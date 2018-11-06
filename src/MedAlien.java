import java.awt.*;

public class MedAlien extends Alien{
    public MedAlien(int x, int y, Handler handler) {
        super(x, y, handler, "Space_Invaders/images/Medalien.png");
        setSpeedX(1);
        score = MEDALIEN_POINTS;
    }
}
