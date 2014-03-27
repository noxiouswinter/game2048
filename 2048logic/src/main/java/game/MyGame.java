package game;

import strategy.BasicScoreStrategy;
import strategy.ScoreStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/16/14
 * Time: 12:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyGame {

    public static final int ROWS = 4;
    public static final int COLUMNS = 4;
    Integer[][] matrix;
    public MyGame(){
        matrix = new Integer[ROWS][COLUMNS];
         initializeMatrix();
    }

    public void setMatrix(Integer[][] newMatrix){
        this.matrix = newMatrix;
    }
    //Initialize all slots with zero
    public void initializeMatrix() {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++){
                matrix[i][j] = 0;
            }
        }
    }

    MatrixMover aMover = new MatrixMover();
    ScoreStrategy strategy = new BasicScoreStrategy();

    public boolean isGameOver(){
        return getEmptyTilePositions().size()==0 &&
        strategy.getSmoothnessScore(matrix)==0;
    }

    public boolean isGameWon(){
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLUMNS;j++){
                if(matrix[i][j].intValue() == 2048)
                    return true;
            }
        }
        return false;
    }

    public boolean addTile( int value) {

        //Find empty slots
        List<TilePosition> emptyCells = getEmptyTilePositions();

        if(emptyCells.size()==0)
            return false;

        //Assign value at random empty slot
        Random random = new Random();
        int randomNumber = random.nextInt(emptyCells.size());
        TilePosition randomPosition = emptyCells.get(randomNumber);
        matrix[randomPosition.x][randomPosition.y] = value;
        return true;
    }

    private List<TilePosition> getEmptyTilePositions() {
        List<TilePosition> emptyCells = new ArrayList<TilePosition>();
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++){
                if(matrix[i][j].equals(0)){
                    emptyCells.add(new TilePosition(i, j));
                }
            }
        }
        return emptyCells;
    }

    public Integer[][] getMatrix(){
        return matrix;
    }
}
class TilePosition{
    public final int x,y;
    public TilePosition(int x,int y){
        this.x = x;
        this.y = y;
    }
}
