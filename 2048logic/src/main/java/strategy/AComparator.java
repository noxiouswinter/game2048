package strategy;

import game.MatrixMoveInfo;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/27/14
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class AComparator implements Comparator<MatrixMoveInfo> {

        double pmcWeight = 0.1;
        double mismatchWeight = 1;
        double emptyCellWeight = 2.3;
        double maxWeight = 1;
        @Override
        public int compare(MatrixMoveInfo o1, MatrixMoveInfo o2) {
            /**
             * What to do when there are empty cells
             */

            double o1TotalScore = pmcWeight*o1.potenttialMergeScore+
                    emptyCellWeight*o1.emptyCellCount -
                    mismatchWeight*o1.misMatchCount + maxWeight* o1.maxValueScore;
            double o2TotalScore = pmcWeight*o2.potenttialMergeScore+
                    emptyCellWeight*o2.emptyCellCount -
                    mismatchWeight*o2.misMatchCount + o2.maxValueScore;

            if(o1TotalScore > o2TotalScore)
                return 1;
            else if(o1TotalScore < o2TotalScore){
                return -1;
            }
            else{
                if(o1.misMatchCount < o2.misMatchCount)  //more important
                    return 1;
                else if(o1.misMatchCount > o2.misMatchCount)
                    return -1;
                else{
                    //same # of mismatches lets look at potential merges
                    if(o1.potenttialMergeScore > o2.potenttialMergeScore)
                        return 1;
                    else if(o1.potenttialMergeScore < o2.potenttialMergeScore)
                        return -1;
                    else{
                        if(o1.emptyCellCount > o2.emptyCellCount)
                            return 1;
                        else if(o1.emptyCellCount < o2.emptyCellCount)
                            return -1;
                        else return 0;
                    }
                }

            }


        }

}
