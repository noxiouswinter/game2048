package game;

import strategy.BasicScoreStrategy;
import strategy.ScoreStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/15/14
 * Time: 8:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatrixMover {

    private ScoreStrategy scoreStrategy = new BasicScoreStrategy();

    public MatrixMoveInfo moveMatrix(Integer[][] matrix, Game.Action action){
        int mergeScore = 0;
        Integer[][] copy = deepCopy(matrix);
        if(action.equals(Game.Action.LEFT)){
            for(int row=0;row<matrix.length;row++){
                mergeScore += Mover.pull(copy[row]);
            }
        }

        if(action.equals(Game.Action.RIGHT)){
            for(int row=0;row<matrix.length;row++){
                Integer[] rowReverse = reverse(copy[row]);
                mergeScore += Mover.pull(rowReverse);
                copy[row] = reverse(rowReverse);
            }

        }
        if(action.equals(Game.Action.UP)){
           for(int col=0;col<Game.COLUMNS;col++){
               Integer[] column = extractColumn(copy,col);
               mergeScore += Mover.pull(column);
               for(int row=0;row<Game.ROWS;row++){
                   copy[row][col] = column[row];
               }
           }
        }
        if(action.equals(Game.Action.DOWN)){
            for(int col=0;col<Game.COLUMNS;col++){
                Integer[] column = extractColumn(copy,col);
                Integer[] reverseCol = reverse(column);
                mergeScore += Mover.pull(reverseCol);
                Integer[] modifiedOriginal = reverse(reverseCol);
                for(int row=0;row<Game.ROWS;row++){
                    copy[row][col] = modifiedOriginal[row];
                }
            }
        }
       return new MatrixMoveInfo(copy,mergeScore,scoreStrategy.getSmoothnessScore(copy),
               scoreStrategy.getMisMatchScore(copy),scoreStrategy.getEmptyCellScore(copy));
    }



    public static Integer[] extractColumn(Integer[][] copy, int colIdx) {
        Integer[] column = new Integer[Game.ROWS];
        for(int row=0;row<column.length;row++){
            column[row] = copy[row][colIdx];
        }
        return column;
    }

    protected Integer[] reverse(Integer[] integers) {
        Integer[] aReverse = new Integer[integers.length];
        for(int i=0;i<aReverse.length;i++){
            aReverse[i] = integers[integers.length-1-i];
        }
        return aReverse;
    }

    private Integer[][] deepCopy(Integer[][] inputMatrix) {
        Integer[][] aCopy = new Integer[Game.ROWS][Game.COLUMNS];
        for(int i=0;i<aCopy.length;i++){
            for(int j=0;j<aCopy[i].length;j++){
                aCopy[i][j] = new Integer(inputMatrix[i][j].intValue());

            }
        }
        return aCopy;  //To change body of created methods use File | Settings | File Templates.
    }
}
