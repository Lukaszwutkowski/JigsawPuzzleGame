import com.badlogic.gdx.scenes.scene2d.Stage;

public class PuzzleArea extends DropTargetActor{

    private int row;
    private int col;

    public PuzzleArea(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("assets/border.jpg");
    }

    public int getRow() {
        return row;
    }

    public void setRow(int r) {
        this.row = r;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int c) {
        this.col = c;
    }
}
