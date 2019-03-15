import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas extends AbsGameCanvas {

    private CellBoard cellBoard;
    private PieceBoard pieceBoard;
    private PlayerBoard playerBoard;
    private ScoreBoard scoreBoard;
    private Color curPieceColor;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public GameCanvas() {
        super();
        setSleepTime(300);

        addMouseMotionListener(new BrowseCellBoardListener());
        addMouseListener(new ClickPieceBoardListener());
        setCurPieceColor(Consts.WHITEP);
    }

    private void initPieceBoard() {
        pieceBoard = new PieceBoard();
        pieceBoard.addPropertyChangeListener(new ClickChange());
        // pieceBoard is used inside cellBoard
        cellBoard.setPieceBoard(pieceBoard.getPieceBoard());
        getSpriteAry().add(pieceBoard);
    }

    @Override
    public void initComponent() {
        getSpriteAry().clear();
        new AllClips();

        initCellBoard();
        initPieceBoard();
        initScoreBoard();
        initPlayerBoard();

        // initialize two white and two black pieces
        pieceBoard.initPieces();
        scoreBoard.setNumWhite(scoreBoard.getNumWhite() + 2);
        scoreBoard.setNumBlack(scoreBoard.getNumBlack() + 2);
    }

    private void initCellBoard() {
        cellBoard = new CellBoard();
        getSpriteAry().add(cellBoard);
    }

    private void initPieceBoard() {
        pieceBoard = new PieceBoard();
        getSpriteAry().add(pieceBoard);
    }

    private void initScoreBoard() {
        scoreBoard = new ScoreBoard();
        getSpriteAry().add(scoreBoard);
    }

    private void initPlayerBoard() {
        playerBoard = new PlayerBoard();
        getSpriteAry().add(playerBoard);
    }

    // Othello is played by two players. It does not have a current score
    @Override
    public void paintCurrScore(Graphics2D g2d) {
    }

    @Override
    public void announceTermination(Graphics2D g2d) {
 //…
    }

    // A listener for re-starting the game.
    // Assume it is based on a mouse click
    class NewGameListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent evt) {
 //…
        }
    }

    class BrowseCellBoardListener extends MouseMotionAdapter {

        @Override
        public void mouseMoved(MouseEvent evt) {
            int x = evt.getX();
            int y = evt.getY();
            cellBoard.setMoveXY(x, y);
        }
    }

    class ClickPieceBoardListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent evt) {
            int x = evt.getX();
            int y = evt.getY();
            pieceBoard.setClickXY(x, y);
        }
    }

    class ClickChange implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            String theChange = evt.getPropertyName();
            if (theChange.equals("clickDone")) {
                if (getCurPieceColor().equals(Consts.WHITEP)) {
                    setCurPieceColor(Consts.BLACKP);
                } else if (getCurPieceColor().equals(Consts.BLACKP)) {
                    setCurPieceColor(Consts.WHITEP);
                }
            }
        }
    }

    public Color getCurPieceColor() {
        return curPieceColor;
    }

    public void setCurPieceColor(Color curPieceColor) {
        this.curPieceColor = curPieceColor;
        pieceBoard.setCurPieceColor(getCurPieceColor());
        playerBoard.setCurPieceColor(getCurPieceColor());
    }
}
