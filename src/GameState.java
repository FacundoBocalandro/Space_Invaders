import java.awt.*;

public interface GameState {
    void tick();
    void render(Graphics g);
}
