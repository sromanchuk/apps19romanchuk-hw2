package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPeek() {
        Stack new_stack = new Stack();
        new_stack.push(1);
        new_stack.push(2);
        new_stack.push(3);
        Object answ = new_stack.peek();
        assertEquals(3, answ);
    }

    @Test
    public void testPop() {
        Stack new_stack = new Stack();
        new_stack.push(1);
        new_stack.push(2);
        Object actualResult = new_stack.pop();
        assertEquals(2, actualResult);
    }

    @Test
    public void testPush() {
        Stack new_stack = new Stack();
        new_stack.push(1);
        assertEquals("1", new_stack.toString());
    }
}
