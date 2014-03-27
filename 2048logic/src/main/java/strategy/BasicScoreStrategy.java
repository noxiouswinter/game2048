package strategy;

import game.Game;
import game.MatrixMover;
import game.Mover;

/**
 * Created with IntelliJ IDEA.
 * User: sajit
 * Date: 3/24/14
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicScoreStrategy implements ScoreStrategy{
    @Override
    public Integer getMisMatchScore(Integer[][] matrix) {

            int misMatchCount = 0;
            for(int row=0;row<matrix.length;row++){
                misMatchCount += Mover.getOrderMisMatch(matrix[row]);
            }
            for(int columnIdx=0;columnIdx<matrix[0].length;columnIdx++){
                Integer[] column = MatrixMover.extractColumn(matrix, columnIdx);
                misMatchCount += Mover.getOrderMisMatch(column);
            }
            return misMatchCount;  //To change body of created methods use File | Settings | File Templates.

        //return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Integer getSmoothnessScore(Integer[][] matrix) {
        int pms = 0;
        for(int i=0;i< Game.ROWS;i++){
            pms += Mover.getPotentialMergeCount(matrix[i]);
        }
        for(int i=0;i<Game.COLUMNS;i++){
            Integer[] column = MatrixMover.extractColumn(matrix,i);
            pms += Mover.getPotentialMergeCount(column);
        }
        return pms;
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Integer getMaxValueScore(Integer[][] matrix) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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

        //return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
