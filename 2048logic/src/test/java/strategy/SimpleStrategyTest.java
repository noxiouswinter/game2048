package strategy;

import game.MatrixMoveInfo;
import org.junit.Assert;
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
    @Test
    public void testGetCorrectMove(){
          MatrixMoveInfo result = ss.bestMove(matrix);
         Integer expected = 36;
        Assert.assertEquals(expected.intValue(), result.mergeScore+result.potenttialMergeScore);
    }
}
