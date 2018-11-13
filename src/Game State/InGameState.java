import java.awt.*;

public class InGameState implements GameState {
    Handler handler;
    HUD hud;
    Spawn spawn;
    boolean isPaused;

    public InGameState(Handler handler, HUD hud, Spawn spawn) {
        this.handler = handler;
        this.hud = hud;
        this.spawn = spawn;
        isPaused = false;
    }
    @Override
    public void tick() {
        if (!isPaused) {
            handler.tick();
            hud.tick();
            spawn.tick();
        }
    }
    @Override
    public void render(Graphics g) {
        handler.render(g);
        hud.render(g);
    }

    @Override
    public void pause() {
        isPaused = !isPaused;
    }

    @Override
    public boolean isPaused() {
        return isPaused;
    }
}
