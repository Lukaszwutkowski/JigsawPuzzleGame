import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class LevelScreen extends BaseScreen
{
    public void initialize() 
    {        
        BaseActor background = new BaseActor(0, 0, mainStage);
        background.loadTexture("assets/background.jpg");

        int numberRows = 3;
        int numberCols = 3;

        Texture texture = new Texture(Gdx.files.internal("assets/sun.jpg"), true);
        int imageWidth = texture.getWidth();
        int imageHeight = texture.getHeight();
        int pieceWidth = imageWidth / numberCols;
        int pieceHeight = imageHeight / numberRows;

        TextureRegion[][] temp = TextureRegion.split(texture, pieceWidth, pieceHeight);

        for (int r = 0; r < numberRows; r++){
            for (int c = 0; c < numberCols; c++){
                // Code that create puzzle piece at random location on left half of screen
                int pieceX = MathUtils.random(0, 400 - pieceWidth);
                int pieceY = MathUtils.random(0, 600 - pieceHeight);
                PuzzlePiece pp = new PuzzlePiece(pieceX, pieceY, mainStage);

                Animation<TextureRegion> anim = new Animation<TextureRegion>(1, temp[r][c]);
                pp.setAnimation(anim);
                pp.setRow(r);
                pp.setCol(c);
            }
        }
    }

    public void update(float dt)
    {
       
    }
}