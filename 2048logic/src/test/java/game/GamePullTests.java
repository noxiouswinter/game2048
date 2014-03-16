package game;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/15/14
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class GamePullTests {



    @Test
    public void testMoveAction1(){
        Integer[] input = new Integer[] { 0,0,4,4};
        Integer mergeScore = Mover.pull(input);
        Integer[] expected = new Integer[] { 8,0,0,0};
        Assert.assertArrayEquals(expected,input);
        Assert.assertEquals(8,mergeScore.intValue());
    }
    @Test
    public void testMoveAction2(){
        Integer[] input = new Integer[] { 0,4,4,4};
        Integer mergeScore = Mover.pull(input);
        Integer[] expected = new Integer[] { 8,4,0,0};
        Assert.assertArrayEquals(expected,input);
        Assert.assertEquals(8,mergeScore.intValue());
    }

    @Test
    public void testMoveAction3(){
        Integer[] input = new Integer[] { 4,4,4,4};
        Integer mergeScore = Mover.pull(input);
        Integer[] expected = new Integer[] { 8,8,0,0};
        Assert.assertArrayEquals(expected,input);
        Assert.assertEquals(16,mergeScore.intValue());
    }

    @Test
    public void testMoveActionOddMerge(){
        Integer[] input = new Integer[] { 4,4,4,0};
        Integer mergeScore = Mover.pull(input);
        Integer[] expected = new Integer[] { 8,4,0,0};
        Assert.assertArrayEquals(expected,input);
        Assert.assertEquals(8,mergeScore.intValue());
    }
    @Test
    public void testMoveActionNoMerge1(){
        Integer[] input = new Integer[] { 0,0,4,0};
        Integer mergeScore = Mover.pull(input);
        Integer[] expected = new Integer[] { 4,0,0,0};
        Assert.assertArrayEquals(expected,input);
        Assert.assertEquals(0,mergeScore.intValue());
    }

    @Test
    public void testMoveAction6(){
        Integer[] input = new Integer[] { 4,4,4,0};
        Integer mergeScore = Mover.pull(input);
        Integer[] expected = new Integer[] { 8,4,0,0};
        Assert.assertArrayEquals(expected,input);
        Assert.assertEquals(8,mergeScore.intValue());
    }
    @Test
    public void testMoveAction5(){
        Integer[] input = new Integer[] { 0,4,0,4};
        Integer mergeScore = Mover.pull(input);
        Integer[] expected = new Integer[] { 8,0,0,0};
        Assert.assertArrayEquals(expected,input);
        Assert.assertEquals(8,mergeScore.intValue());
    }
    @Test
    public void testMoveActionNoMerge2(){
        Integer[] input = new Integer[] { 4,2,4,0};
        Integer mergeScore = Mover.pull(input);
        Integer[] expected = new Integer[] { 4,2,4,0};
        //printArray(input);
        Assert.assertArrayEquals(expected,input);
        Assert.assertEquals(0,mergeScore.intValue());
    }

    @Test
    public void testBug2(){
        Integer[] input = new Integer[] { 2,0,4,4};
        Integer mergeScore = Mover.pull(input);
        Integer[] expected = new Integer[] { 2,8,0,0};
        printArray(input);
        Assert.assertArrayEquals(expected,input);
        Assert.assertEquals(8,mergeScore.intValue());
    }

    @Test
    public void testMoveActionPartialMerge(){
        Integer[] input = new Integer[] { 4,2,0,2};
        Integer mergeScore = Mover.pull(input);
        Integer[] expected = new Integer[] { 4,4,0,0};
        //printArray(input);
        Assert.assertArrayEquals(expected,input);
        Assert.assertEquals(4,mergeScore.intValue());
    }

    @Test
    public void testBug1(){
        Integer[] input = new Integer[]{0,4,2,4};
        Integer mergeScore = Mover.pull(input);
        Integer[] expected = new Integer[] { 4,2,4,0};
        //printArray(input);
        Assert.assertArrayEquals(expected,input);
        Assert.assertEquals(0,mergeScore.intValue());
    }

    private void printArray(Integer[] input) {
        for(int i : input){
            System.out.print(" " + i);
        }
        System.out.println();
        //To change body of created methods use File | Settings | File Templates.
    }

    @Test
    public void testScore1(){
        Integer[] expected = new Integer[] { 4,2,4,0};
        Assert.assertEquals(0,Mover.getPotentialMergeScore(expected).intValue());
        expected = new Integer[]{0,4,2,4};
        Assert.assertEquals(0,Mover.getPotentialMergeScore(expected).intValue());
    }

    @Test
    public void testScoreAllSame(){
        Integer[] expected = new Integer[] { 4,4,4,4};
        Assert.assertEquals(16,Mover.getPotentialMergeScore(expected).intValue());

    }
    @Test
    public void testScore2(){
        Integer[] input = new Integer[] { 2,0,4,4};
        Assert.assertEquals(8,Mover.getPotentialMergeScore(input).intValue());
        Integer[] rinput = new Integer[] { 4,4,0,2};
        Assert.assertEquals(8,Mover.getPotentialMergeScore(rinput).intValue());
    }


}
