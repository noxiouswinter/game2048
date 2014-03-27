package strategy;

import game.Game;
import game.MatrixMover;
import game.Mover;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/27/14
 * Time: 8:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class AStrategy implements ScoreStrategy {
    @Override
    public Integer getMisMatchScore(Integer[][] matrix) {
        int misMatchScore = 0;

        for(int row=0;row<Game.ROWS;row++){
            misMatchScore += Mover.getOrderMisMatchDiff(matrix[row]);
        }
        for(int columnIdx=0;columnIdx<Game.COLUMNS;columnIdx++){
            Integer[] column = MatrixMover.extractColumn(matrix, columnIdx);
            misMatchScore += Mover.getOrderMisMatchDiff(column);
        }
        return misMatchScore;

    }

    @Override
    public Integer getSmoothnessScore(Integer[][] matrix) {

        int pms = 0;
        for(int i=0;i< Game.ROWS;i++){
            pms += Mover.getPotentialMergeValue(matrix[i]);
        }
        for(int i=0;i<Game.COLUMNS;i++){
            Integer[] column = MatrixMover.extractColumn(matrix, i);
            pms += Mover.getPotentialMergeValue(column);
        }
        return pms;
           }

    @Override
    public Integer getMaxValueScore(Integer[][] matrix) {
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++)
                if(matrix[i][j].intValue()> max){
                    max = matrix[i][j];
                }
        }
        return max;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Integer getEmptyCellScore(Integer[][] matrix) {
        int emptyCount = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j].intValue()==0)
                    emptyCount++;
            }
        }
        return emptyCount;

    }
}
