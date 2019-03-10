import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    public static void main(String[] args) {
        new Gui("Othello");
    }

    public Gui(String title) {
        super(title);

        //Swing-Layout
        setLayout(null);
        setSize(600, 500);

        JPanel player1 = new JPanel();
        JLabel namePlayer1 = new JLabel("Spieler 1");
        player1.add(namePlayer1);
        player1.setBounds(0, 0, 100, 500);
        add(player1);

        JPanel player2 = new JPanel();
        JLabel namePlayer2 = new JLabel("Spieler 2");
        player2.add(namePlayer2);
        player2.setBounds(500, 0, 100, 500);
        add(player2);

        JPanel field = new JPanel(new GridLayout(8, 8));
        field.setBounds(100, 0, 400, 400);
        FieldButton[][] fieldButtons = new FieldButton[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                fieldButtons[i][j] = new FieldButton();
                field.add(fieldButtons[i][j]);
            }
        }

        add(field, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //pack();
        setVisible(true);

        //Event-Handling hinzufügen

    }
}
