import javax.swing.*;

public class FieldButton extends JLabel {
    private Status status;

    ImageIcon emptyIcon, blackIcon, whiteIcon;

    public FieldButton() {
        super();

        emptyIcon = new ImageIcon("./img/empty.png");
        blackIcon = new ImageIcon("./img/black.png");
        whiteIcon = new ImageIcon("./img/white.png");

        status = Status.Empty;
        setSize(50, 50);
        setIcon(emptyIcon);
    }

    private enum Status {Empty, Black, White}
}
