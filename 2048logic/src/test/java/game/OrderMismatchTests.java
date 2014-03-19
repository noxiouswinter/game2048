package game;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: skunnumkal
 * Date: 3/17/14
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderMismatchTests {

    @Test
    public void countMismatches1(){
        Integer[] input = new Integer[] { 0,0,4,4};
        Integer mismatchCount = Mover.getOrderMisMatch(input);
        Assert.assertEquals(0,mismatchCount.intValue());
    }

    @Test
    public void downAndUp(){
        Integer[] input = new Integer[] { 4,0,4,4};
        Integer mismatchCount = Mover.getOrderMisMatch(input);
        Assert.assertEquals(1,mismatchCount.intValue());
    }

    @Test
    public void descending(){
        Integer[] input = new Integer[] { 4,3,2,1};
        Integer mismatchCount = Mover.getOrderMisMatch(input);
        Assert.assertEquals(0,mismatchCount.intValue());
    }

    @Test
    public void ascending(){
        Integer[] input = new Integer[] { 1,2,3,4};
        Integer mismatchCount = Mover.getOrderMisMatch(input);
        Assert.assertEquals(0,mismatchCount.intValue());
    }

    @Test
    public void allSame(){
        Integer[] input = new Integer[] { 4,4,4,4};
        Integer mismatchCount = Mover.getOrderMisMatch(input);
        Assert.assertEquals(0,mismatchCount.intValue());
    }

    @Test
    public void upAndDown(){
        Integer[] input = new Integer[] { 0,4,4,2};
        Integer mismatchCount = Mover.getOrderMisMatch(input);
        Assert.assertEquals(1,mismatchCount.intValue());
    }

    @Test
    public void directionIsIrrelevant(){
        Integer[] input = new Integer[] { 0,4,4,2};
        Integer[] reverse = new Integer[] {2,4,4,0};
        Assert.assertEquals(Mover.getOrderMisMatch(reverse).intValue(), Mover.getOrderMisMatch(input).intValue());
    }

    @Test
    public void directionIsIrrelevant2(){
        Integer[] input = new Integer[] { 0,1,-4,-4};
        Integer[] reverse = new Integer[] {-4,-4,1,0};
        Assert.assertEquals(Mover.getOrderMisMatch(reverse).intValue(), Mover.getOrderMisMatch(input).intValue());
    }

    @Test
    public void directionIsIrrelevant3(){
        Integer[] input = new Integer[] { 0,1,-4,4};
        Integer[] reverse = new Integer[] {4,-4,1,0};
        Assert.assertEquals(Mover.getOrderMisMatch(reverse).intValue(), Mover.getOrderMisMatch(input).intValue());
    }
}
