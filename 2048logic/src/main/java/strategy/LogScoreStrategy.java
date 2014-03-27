package strategy;

import game.Game;
import game.MatrixMover;
import game.Mover;

/**
 * Created with IntelliJ IDEA.
 * User: sajit
 * Date: 3/25/14
 * Time: 9:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class LogScoreStrategy implements ScoreStrategy {
    @Override
    public Integer getMisMatchScore(Integer[][] matrix) {
        int misMatchScore = 0;
        Integer[][] logMath = getLog(matrix);
        for(int row=0;row<Game.ROWS;row++){
            misMatchScore += Mover.getOrderMisMatchValue(logMath[row]);
        }
        for(int columnIdx=0;columnIdx<Game.COLUMNS;columnIdx++){
            Integer[] column = MatrixMover.extractColumn(logMath, columnIdx);
            misMatchScore += Mover.getOrderMisMatchValue(column);
        }
        return misMatchScore;
    }

    @Override
    public Integer getSmoothnessScore(Integer[][] matrix) {
        Integer[][] logMath = getLog(matrix);
        int pms = 0;
        for(int i=0;i< Game.ROWS;i++){
            pms += Mover.getPotentialMergeValue(logMath[i]);
        }
        for(int i=0;i<Game.COLUMNS;i++){
            Integer[] column = MatrixMover.extractColumn(logMath, i);
            pms += Mover.getPotentialMergeValue(column);
        }
        return pms;
        //return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Integer[][] getLog(Integer[][] matrix) {
        Integer[][] log = new Integer[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                log[i][j] = (int)Math.log(matrix[i][j].intValue());
            }
        }
        return log;  //To change body of created methods use File | Settings | File Templates.
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
        return emptyCount; //To change body of implemented methods use File | Settings | File Templates.
    }
}
