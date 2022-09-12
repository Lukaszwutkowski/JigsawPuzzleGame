import com.badlogic.gdx.scenes.scene2d.Stage;

public class PuzzlePiece extends DragAndDropActor{

    private int row;
    private int col;

    private PuzzleArea puzzleArea;

    public PuzzlePiece(float x, float y, Stage s) {
        super(x, y, s);
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

    public PuzzleArea getPuzzleArea() {
        return puzzleArea;
    }

    public void setPuzzleArea(PuzzleArea pa) {
        this.puzzleArea = pa;
    }

    public void clearPuzzleArea(){
        puzzleArea = null;
    }

    public boolean hasPuzzleArea(){
        return puzzleArea != null;
    }

    public boolean isCorrectlyPlaced(){
        return hasPuzzleArea()
                && this.getRow() == puzzleArea.getRow()
                && this.getCol() == puzzleArea.getCol();
    }

    @Override
    public void onDragStart() {
        if (hasPuzzleArea()){
            PuzzleArea pa = getPuzzleArea();
            pa.setTargetable(true);
            clearPuzzleArea();
        }
    }

    @Override
    public void onDrop() {
        if (hasDropTarget()){
            PuzzleArea pa = (PuzzleArea)getDropTarget();
            moveToActor(pa);
            setPuzzleArea(pa);
            pa.setTargetable(false);
        }
    }
}
