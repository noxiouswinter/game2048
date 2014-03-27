package game;

import junit.framework.Assert;
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
        Assert.assertEquals(8,result);
    }
    @Test
    public void testMisMatchScore1(){
        Integer[] arr = {0,5,0,0};
        int result = Mover.getOrderMisMatchValue(arr);
        Assert.assertEquals(0,result);
    }
}
