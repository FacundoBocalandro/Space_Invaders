import java.awt.*;

public interface GameState {
    void tick();
    void render(Graphics g);
    default void pause(){}
    default boolean isPaused(){return false;}
}
