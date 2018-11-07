import java.awt.*;

public class EndGameState implements GameState {
    EndGame endGame;
    public EndGameState(EndGame endGame){
        this.endGame = endGame;
    }
    @Override
    public void tick() {
        endGame.tick();
    }
    @Override
    public void render(Graphics g) {
        endGame.render(g);


    }
}
