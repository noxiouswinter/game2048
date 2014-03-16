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

    public MatrixMoveInfo(Integer[][] matrix,int mergeScore,int potenttialMergeScore){
        this.outputMatrix = matrix;
        this.mergeScore = mergeScore;
        this.potenttialMergeScore = potenttialMergeScore;
    }

    @Override
    public String toString(){
        return "{Merge Score" + mergeScore + ", Potential Merge Score " + potenttialMergeScore + "}";
    }
}
