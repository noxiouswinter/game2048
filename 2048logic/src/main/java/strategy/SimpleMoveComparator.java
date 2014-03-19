package strategy;

import game.MatrixMoveInfo;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/17/14
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleMoveComparator implements Comparator<MatrixMoveInfo> {
    @Override
    public int compare(MatrixMoveInfo o1, MatrixMoveInfo o2) {
        if(o1.mergeScore+o1.potenttialMergeScore > o2.mergeScore+ o2.potenttialMergeScore)
            return 1;
        else if(o1.mergeScore+o1.potenttialMergeScore < o2.mergeScore+ o2.potenttialMergeScore){
            return -1;
        }
        else{
            if(o1.mergeScore > o2.mergeScore)
                return 1;
            else if(o1.mergeScore < o2.mergeScore)
                return -1;
            else return 0;
        }
        //return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
