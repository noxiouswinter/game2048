package strategy;

import game.MatrixMoveInfo;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/17/14
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderedWeightComparator implements Comparator<MatrixMoveInfo> {
    double pmcWeight = 0.1;
    double mismatchWeight = 1.0;
    double emptyCellWeight = 2.7;

    /**
     * var smoothWeight = 0.1,
     //monoWeight   = 0.0,
     //islandWeight = 0.0,
     mono2Weight  = 1.0,
     emptyWeight  = 2.7,
     maxWeight    = 1.0;

     return this.grid.smoothness() * smoothWeight
     //+ this.grid.monotonicity() * monoWeight
     //- this.grid.islands() * islandWeight
     + this.grid.monotonicity2() * mono2Weight
     + Math.log(emptyCells) * emptyWeight
     + this.grid.maxValue() * maxWeight;
     };
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(MatrixMoveInfo o1, MatrixMoveInfo o2) {
        /**
         * What to do when there are empty cells
         */

        double o1TotalScore = pmcWeight*o1.potenttialMergeScore+
                emptyCellWeight*o1.emptyCellCount -
                mismatchWeight*o1.misMatchCount;
        double o2TotalScore = pmcWeight*o2.potenttialMergeScore+
                emptyCellWeight*o2.emptyCellCount -
                mismatchWeight*o2.misMatchCount;

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
