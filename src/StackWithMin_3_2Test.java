import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by david on 1/7/2017.
 */
public class StackWithMin_3_2Test {

    StackWithMin_3_2 testStack = new StackWithMin_3_2();


    @org.junit.Test
    public void testPush() throws Exception {
        testStack.push(3);
        assertEquals(true, testStack.contains(3));

    }

    @org.junit.Test
    public void testPop() throws Exception {
        testStack.push(5);
        assert 5 == testStack.pop();
    }

    @org.junit.Test
    public void testGetMin() throws Exception {
        testStack.push(3);
        testStack.push(1);
        testStack.push(3);
        assert 1 == testStack.getMin();
        testStack.pop();
        assert 1 == testStack.getMin();
        testStack.pop();
        assert 3 == testStack.getMin();
    }

}