import java.awt.*;

public class RankingState implements GameState{
    Ranking ranking;
    HighScore highScore;

    public RankingState(Ranking ranking, HighScore highScore) {
        this.ranking = ranking;
        this.highScore = highScore;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        ranking.render(g, highScore);
    }
}
