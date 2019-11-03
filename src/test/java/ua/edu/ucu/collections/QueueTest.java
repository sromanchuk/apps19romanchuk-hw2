package ua.edu.ucu.collections;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testPeek() {
        Queue new_queue = new Queue();
        new_queue.enqueue(1);
        new_queue.enqueue(2);
        new_queue.enqueue(3);
        Object answ = new_queue.peek();
        assertEquals(1, answ);
    }

    @Test
    public void testEnqueue() {
        Queue new_queue = new Queue();
        new_queue.enqueue(1);
        new_queue.enqueue(2);
        new_queue.enqueue(3);
        assertEquals("1, 2, 3", new_queue.toString());
    }

    @Test
    public void testDequeue() {
        Queue new_queue = new Queue();
        new_queue.enqueue(1);
        new_queue.enqueue(2);
        new_queue.enqueue(3);
        Object answ = new_queue.dequeue();
        assertEquals(1, answ);
    }
}