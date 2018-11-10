import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NameTextField extends JFrame {
    JTextField textField;
    String name;

    public NameTextField(int width, int height, Handler handler, int score){
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        setLocation(150,120);
        textField = new JTextField("Enter Name");
        add(textField);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = textField.getText();
                handler.newHighScore(name, score);
                handler.menu();
                setVisible(false);
            }
        });
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                textField.setText("");
            }

            public void focusLost(FocusEvent e) {
                textField.setText("Enter Name");
            }
        });
        setVisible(true);
    }
}
