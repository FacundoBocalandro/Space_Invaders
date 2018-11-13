import java.awt.*;

public class GameWonState implements GameState{
    GameWon gameWon;
    public GameWonState(GameWon gameWon){
        this.gameWon = gameWon;
    }
    @Override
    public void tick() {
        gameWon.tick();
    }

    @Override
    public void render(Graphics g) {
        gameWon.render(g);
    }
}
