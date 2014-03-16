package game;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/15/14
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatrixMoverTests {
    Integer[][] matrix = {{4,2,4,0},{4,8,8,4},{0,0,2,0},{2,0,2,2}};

    @Test
    public void testMoveLeft(){
        MatrixMover matrixMover = new MatrixMover();
        MatrixMoveInfo moveInfo = matrixMover.moveMatrix(matrix, Game.Action.LEFT);
        Integer[][] expected = {{4,2,4,0},{4,16,4,0},{2,0,0,0},{4,2,0,0}};
        Assert.assertArrayEquals(expected,moveInfo.outputMatrix);
        Assert.assertEquals(20,moveInfo.mergeScore);
        Assert.assertEquals(16,moveInfo.potenttialMergeScore);
    }

    @Test
    public void testMoveRight(){
        MatrixMover matrixMover = new MatrixMover();
        MatrixMoveInfo moveInfo = matrixMover.moveMatrix(matrix, Game.Action.RIGHT);
        Integer[][] expected = {{0,4,2,4},{0,4,16,4},{0,0,0,2},{0,0,2,4}};
        Assert.assertArrayEquals(expected,moveInfo.outputMatrix);
        Assert.assertEquals(20,moveInfo.mergeScore);
        Assert.assertEquals(16,moveInfo.potenttialMergeScore);
    }
    @Test
    public void testMoveUp(){
        MatrixMover matrixMover = new MatrixMover();
        MatrixMoveInfo moveInfo = matrixMover.moveMatrix(matrix, Game.Action.UP);
        Integer[][] expected = {{8,2,4,4},{2,8,8,2},{0,0,4,0},{0,0,0,0}};
        Assert.assertArrayEquals(expected,moveInfo.outputMatrix);
        Assert.assertEquals(12,moveInfo.mergeScore);
        Assert.assertEquals(24,moveInfo.potenttialMergeScore);
    }
    @Test
    public void testMoveDown(){
        MatrixMover matrixMover = new MatrixMover();
        MatrixMoveInfo moveInfo = matrixMover.moveMatrix(matrix, Game.Action.DOWN);
        Integer[][] expected = {{0,0,0,0},{0,0,4,0},{8,2,8,4},{2,8,4,2}};
        Assert.assertArrayEquals(expected,moveInfo.outputMatrix);
        Assert.assertEquals(12,moveInfo.mergeScore);
        Assert.assertEquals(0,moveInfo.potenttialMergeScore);
    }

    @Test
    public void testPotentialMerge(){
        MatrixMover matrixMover = new MatrixMover();
         Assert.assertEquals(32,matrixMover.calculatePotentialMergeScore(matrix));
    }

}
