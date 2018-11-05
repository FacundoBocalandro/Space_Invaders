import javax.swing.*;
import java.awt.*;

public class StartGameWindow extends Canvas {
    JFrame frame;
    SpaceInvaders game;
    public StartGameWindow(int width, int height, SpaceInvaders game, String title){
        frame = new JFrame(title);
        this.game = game;

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.add(game);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();

    }

}
