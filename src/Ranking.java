import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.List;

public class Ranking extends MouseAdapter {
    Handler handler;

    public Ranking(Handler handler) {
        this.handler = handler;
    }

    public void render(Graphics g, HighScore highScore){
        List<String> highScores = highScore.getHighScores();
        int counter = 1;
        g.setColor(Color.green);
        g.setFont(new Font(Font.MONOSPACED, 0, 20));
        for (String highscore : highScores){
            String[] parts = highscore.split("-");
            String name = parts[0];
            int score = Integer.parseInt(parts[1]);
            g.drawString(counter + ". " + name + ": " + score, 20, 35 + 25*counter );
            counter ++;
        }

    }
}
