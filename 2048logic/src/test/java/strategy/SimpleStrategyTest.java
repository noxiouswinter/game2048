package strategy;

import game.MatrixMoveInfo;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/15/14
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleStrategyTest {

    SimpleStrategy ss = new SimpleStrategy();
    Integer[][] matrix = {{4,2,4,0},{4,8,8,4},{0,0,2,0},{2,0,2,2}};
    Integer[][] fullMatrix = {{128,16,8,2},{128,8,4,2},{2,8,2,8},{4,2,4,8}};

    @Test
    public void testGetCorrectMove(){
          MatrixMoveInfo result = ss.bestMove(matrix);
         int expectedPMC = 2;
         int expectedECC = 7;
         int expectedMMC = 5;
        //Assert.assertEquals(expectedPMC,result.potenttialMergeScore);
        //Assert.assertEquals(expectedMMC,result.misMatchCount);
        Assert.assertEquals(expectedECC,result.emptyCellCount);
        Integer[][] output = {{8,2,4,4},{2,8,8,2},{0,0,4,0},{0,0,0,0}};
        Assert.assertArrayEquals(output,result.outputMatrix);
    }

    @Test
    public void fullMatrixCorrectMove(){
        MatrixMoveInfo result = ss.bestMove(fullMatrix);
        int expectedPMC = 2;
        int expectedECC = 4;
        int expectedMMC = 7;
        //Assert.assertEquals(expectedPMC,result.potenttialMergeScore);
        //Assert.assertEquals(expectedMMC,result.misMatchCount);
        Assert.assertEquals(expectedECC,result.emptyCellCount);
        Integer[][] expected = {{256,16,8,4},{2,16,4,16},{4,2,2,0},{0,0,4,0}};

        Assert.assertArrayEquals(expected,result.outputMatrix);
    }
}
