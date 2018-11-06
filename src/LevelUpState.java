import java.awt.*;

public class LevelUpState implements GameState{
    LevelUp levelUp;
    int level;

    public LevelUpState(LevelUp levelUp, int level) {
        this.levelUp = levelUp;
        this.level = level;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        levelUp.render(g, level);
    }
}
