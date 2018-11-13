import javax.swing.*;
import java.awt.*;

public class StartGameWindow extends JFrame {
    SpaceInvaders game;
    public StartGameWindow(int width, int height, SpaceInvaders game, String title){
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        add(game);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        this.game = game;
        game.start();

    }


}
