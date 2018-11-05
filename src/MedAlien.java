import java.awt.*;

public class MedAlien extends Alien{
    public MedAlien(int x, int y, Handler handler) {
        super(x, y, handler, "images/Medalien.png");
        setSpeedX(1);
        score = MEDALIEN_POINTS;
    }
}
