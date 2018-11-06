import java.awt.*;

public class InGameState implements GameState {
    Handler handler;
    HUD hud;
    Spawn spawn;

    public InGameState(Handler handler, HUD hud, Spawn spawn) {
        this.handler = handler;
        this.hud = hud;
        this.spawn = spawn;
    }

    @Override
    public void tick() {
        handler.tick();
        hud.tick();
        spawn.tick();
    }

    @Override
    public void render(Graphics g) {
        handler.render(g);
        hud.render(g);
    }
}
