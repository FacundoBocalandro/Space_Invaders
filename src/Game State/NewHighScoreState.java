import java.awt.*;

public class NewHighScoreState implements GameState{
    NewHighScore newHighScore;
    int score;

    public NewHighScoreState(NewHighScore newHighScore) {
        this.newHighScore = newHighScore;
    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        newHighScore.render(g);
    }
}
