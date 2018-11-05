import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class GameObject implements Collision, Commons{
    protected int x, y, width, height;
    protected int speedX, speedY;
    Handler handler;
    BufferedImage img;

    public GameObject(int x, int y, Handler handler, String imageString){
        this.x = x;
        this.y = y;
        this.handler = handler;
        try {
            img = ImageIO.read(new File(imageString));
        } catch (IOException e) {
        }
        width = img.getWidth();
        height = img.getHeight();
    }

    public abstract void tick();
    public void render(Graphics g){
        g.drawImage(img, x, y,null);
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y, width, height);
    }

    public int getX() { return x; }

    public int getY() {
        return y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
    public void setImg(String imageString){
        try {
            img = ImageIO.read(new File(imageString));
        } catch (IOException e) {
        }
    }
}
