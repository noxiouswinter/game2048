package game;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/15/14
 * Time: 8:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatrixMover {

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
       return new MatrixMoveInfo(copy,mergeScore,calculatePotentialMergeScore(copy),
               caclulateOrderMismatches(copy),calculateEmptyCells(copy));
    }

    public int calculateEmptyCells(Integer[][] matrix) {
        int emptyCount = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j].intValue()==0)
                    emptyCount++;
            }
        }
        return emptyCount;
    }

    public int caclulateOrderMismatches(Integer[][] matrix) {
        int misMatchCount = 0;
        for(int row=0;row<matrix.length;row++){
            misMatchCount += Mover.getOrderMisMatch(matrix[row]);
        }
        for(int columnIdx=0;columnIdx<matrix[0].length;columnIdx++){
            Integer[] column = extractColumn(matrix,columnIdx);
            misMatchCount += Mover.getOrderMisMatch(column);
        }
        return misMatchCount;  //To change body of created methods use File | Settings | File Templates.
    }

    public int calculatePotentialMergeScore(Integer[][] aMatrix) {
        int pms = 0;
        for(int i=0;i<Game.ROWS;i++){
          pms += Mover.getPotentialMergeCount(aMatrix[i]);
        }
        for(int i=0;i<Game.COLUMNS;i++){
            Integer[] column = extractColumn(aMatrix,i);
            pms += Mover.getPotentialMergeCount(column);
        }
        return pms;
    }

    protected Integer[] extractColumn(Integer[][] copy, int colIdx) {
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
