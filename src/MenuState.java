import java.awt.*;

public class MenuState implements GameState {
    Menu menu;

    public MenuState(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void tick() {
        menu.tick();
    }

    @Override
    public void render(Graphics g) {
        menu.render(g);

    }
}
