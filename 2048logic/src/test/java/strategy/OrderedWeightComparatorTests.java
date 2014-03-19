package strategy;

import game.MatrixMoveInfo;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/18/14
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderedWeightComparatorTests {
    static final int mergeScore = 4;
    OrderedWeightComparator comparator = new OrderedWeightComparator();
    @Test
    public void testSelectsMatrixWithLessMismatch(){
        /*
        this.potenttialMergeScore = potenttialMergeScore;
        this.misMatchCount = misMatchCount;
        this.emptyCellCount = emptyCellCount;
         */
        int pmC = 4,mmC = 5, ecC = 5, mmC2 = 7;
        Integer[][] arr = new Integer[4][4];
        MatrixMoveInfo m1 = new MatrixMoveInfo(arr,4,pmC,mmC,ecC);
        MatrixMoveInfo m2 = new MatrixMoveInfo(arr,56,pmC,mmC2,ecC);
        Assert.assertEquals(1,comparator.compare(m1,m2));



    }

    @Test
    public void testSelectsMatrixWithFreeCellsIfEqualMisMatch(){
        /*
        this.potenttialMergeScore = potenttialMergeScore;
        this.misMatchCount = misMatchCount;
        this.emptyCellCount = emptyCellCount;
         */
        int pmC = 4,mmC = 5, ecC1 = 5, ecc2 = 7;
        Integer[][] arr = new Integer[4][4];
        MatrixMoveInfo m1 = new MatrixMoveInfo(arr,4,pmC,mmC,ecC1);
        MatrixMoveInfo m2 = new MatrixMoveInfo(arr,56,pmC,mmC,ecc2);
        Assert.assertEquals(-1,comparator.compare(m1,m2));



    }

    @Test
    public void testSelectsMatrixWithBestPotentialScore(){
        /*
        this.potenttialMergeScore = potenttialMergeScore;
        this.misMatchCount = misMatchCount;
        this.emptyCellCount = emptyCellCount;
         */
        int pmC1 = 4,pmC2 = 7,mmC = 5, ecC = 5;
        Integer[][] arr = new Integer[4][4];
        MatrixMoveInfo m1 = new MatrixMoveInfo(arr,4,pmC1,mmC,ecC);
        MatrixMoveInfo m2 = new MatrixMoveInfo(arr,56,pmC2,mmC,ecC);
        Assert.assertEquals(-1,comparator.compare(m1,m2));



    }
}
