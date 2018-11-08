import java.awt.*;

public class MedAlien extends Alien{
    public MedAlien(int x, int y, Handler handler, int currentSpeedX) {
        super(x, y, handler, "images/Medalien.png", currentSpeedX);
        score = MEDALIEN_POINTS;
    }
}
