import java.awt.Graphics2D;

public class CellSprite extends AbsSprite2D {

    private boolean fill;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public CellSprite() {
        initSprite();
    }

    @Override
    public void initSprite() {
        setWidth(Consts.CELLW);
        setHeight(Consts.CELLH);
        setColor(Consts.CELLCOLOR);
        setFill(true);
        setActive(false);
        setVisible(true);
    }

    @Override
    public void paintSprite(Graphics2D g2d) {
        g2d.setColor(Consts.CELLCOLOR);
        g2d.fillRect(getX(), getY(), getWidth(), getHeight());
        Chess-Like Games: A Game Othello

        g2d.setColor(Consts.BORDERC);
        g2d.drawRect(getX(), getY(), getWidth(), getHeight());
        g2d.drawRect(getX() + 1, getY() + 1, getWidth() - 2, getHeight() - 2);
    }

    @Override
    public void updateSprite() {
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }
}
