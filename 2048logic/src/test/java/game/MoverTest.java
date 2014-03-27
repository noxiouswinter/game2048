package game;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: sajit
 * Date: 3/25/14
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class MoverTest {

    @Test
    public void testMisMatchScore(){
          Integer[] arr = {3,5,6,1};
          int result = Mover.getOrderMisMatchValue(arr);
        Assert.assertEquals(5,result);
    }
    @Test
    public void testMisMatchScore1(){
        Integer[] arr = {0,5,0,0};
        int result = Mover.getOrderMisMatchValue(arr);
        Assert.assertEquals(5,result);
    }

    @Test
    public void testMismatchScore2(){
        Integer[] arr = {0,2,4,10};
        Assert.assertEquals(0,Mover.getOrderMisMatchValue(arr).intValue());
    }

    @Test
    public void testDiff1(){
        Integer[] arr = {0,2,4,10};
        Assert.assertEquals(0,Mover.getOrderMisMatchDiff(arr));
    }

    @Test
    public void testDiff2(){
        Integer[] arr = {0,2,4,1};
        Assert.assertEquals(3,Mover.getOrderMisMatchDiff(arr));
    }
    @Test
    public void testDiff3(){
        Integer[] arr = {1,7,1,5};
        Assert.assertEquals(12,Mover.getOrderMisMatchDiff(arr));
    }
}
