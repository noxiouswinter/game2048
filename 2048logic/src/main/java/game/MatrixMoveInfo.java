package game;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/15/14
 * Time: 8:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatrixMoveInfo {

    final public Integer[][] outputMatrix;
    final public int mergeScore;
    final public int potenttialMergeScore;
    final public int misMatchCount;
    final public int emptyCellCount;

    public MatrixMoveInfo(Integer[][] matrix,int mergeScore,int potenttialMergeScore,int misMatchCount,
                          int emptyCellCount){
        this.outputMatrix = matrix;
        this.mergeScore = mergeScore;
        this.potenttialMergeScore = potenttialMergeScore;
        this.misMatchCount = misMatchCount;
        this.emptyCellCount = emptyCellCount;
    }

    @Override
    public String toString(){
        return "{Empty Cell Count" + emptyCellCount + ", Potential Merge Score " + potenttialMergeScore +
                " MisMatch Count " +misMatchCount + "}";
    }
}
