package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testAdd() {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = lst.add(1);
        lst = lst.add(2);
        assertEquals(lst.toString(), "1, 2");
    }

    @Test
    public void testAddIndex() {
        ImmutableLinkedList lst = new ImmutableLinkedList();
        lst = lst.add(0, 1);
        lst = lst.add(1, 2);
        lst = lst.add(3);
        assertEquals(lst.toString(), "1, 2, 3");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexError() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        arr1 = arr1.add(7, 3);
    }

    @Test
    public void testAddAll1() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        arr1 = arr1.addAll(new Object[]{10, 15});
        ImmutableLinkedList answ = arr1;
        assertEquals("1, 2, 10, 15", answ.toString());
    }

    @Test
    public void testAddAll2() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        ImmutableLinkedList arr2 = arr1.addAll(new Object[]{10, 15});
        arr2 = arr2.add(20);
        ImmutableLinkedList answ = arr2;
        assertEquals("1, 2, 10, 15, 20", answ.toString());
    }

    @Test
    public void testAddAllIndex() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        arr1 = arr1.add(3);
        arr1 = arr1.addAll(2, new Object[]{10, 15});

        ImmutableLinkedList answ = arr1;
        assertEquals("1, 2, 10, 15, 3", answ.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexError() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        arr1 = arr1.add(3);
        arr1 = arr1.addAll(4, new Object[]{10, 15});
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(2);
        arr1 = arr1.add(3);
        arr1 = arr1.addAll(new Object[]{10, 15});
        arr1 = arr1.addFirst(0);
        assertEquals("0, 1, 2, 3, 10, 15", arr1.toString());
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(2);
        arr1 = arr1.add(3);
        arr1 = arr1.addAll(new Object[]{10, 15});
        arr1 = arr1.addLast(0);
        assertEquals("1, 2, 3, 10, 15, 0", arr1.toString());
    }

    @Test
    public void removeFirst() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(2);
        arr1 = arr1.add(3);
        arr1 = arr1.removeFirst();
        assertEquals("2, 3", arr1.toString());
    }

    @Test
    public void removeLast() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(2);
        arr1 = arr1.add(3);
        arr1 = arr1.removeLast();
        assertEquals("1, 2", arr1.toString());
    }

    @Test
    public void getFirst() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(2);
        arr1 = arr1.add(3);
        Object answ = arr1.getFirst();
        Object expected = "1";
        assertEquals(expected.toString(), answ.toString());
    }

    @Test
    public void getLast() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(2);
        arr1 = arr1.add(3);
        Object answ = arr1.getLast();
        Object expected = "3";
        assertEquals(expected.toString(), answ.toString());
    }
    @Test
    public void testGet() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(5);
        ImmutableLinkedList arr2 = arr1.add(15);
        arr2 = arr2.add(16);
        Object answ = arr2.get(1);
        assertEquals(15, answ);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetError() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        arr1.get(5);
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        ImmutableLinkedList arr2 = arr1.add(1);
        arr2 = arr2.add(2);
        arr2 = arr2.add(3);
        Object answ = arr2.remove(2);
        assertEquals("1, 2", answ.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(2);
        arr1 = arr1.add(3);
        arr1.remove(7);
    }

    @Test
    public void testSet() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        ImmutableLinkedList arr2 = arr1.add(1);
        arr2 = arr2.add(2);
        arr2 = arr2.add(3);
        Object answ = arr2.set(1, 237);
        assertEquals("1, 237, 3", answ.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetError() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(2);
        arr1 = arr1.add(3);
        arr1.set(56, 4);
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        ImmutableLinkedList arr2 = arr1.add(1);
        arr2 = arr2.add(2);
        arr2 = arr2.add(3);
        Object answ = arr2.indexOf(2);
        assertEquals(1, answ);
    }

    @Test
    public void testIndexOfError() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        ImmutableLinkedList arr2 = arr1.add(1);
        arr2 = arr2.add(2);
        arr2 = arr2.add(3);
        Object answ = arr2.indexOf(5545);
        assertEquals(-1, answ);
    }

    @Test
    public void testSize1() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        Object actualResult = arr1.size();
        assertEquals(2, actualResult);
    }

    @Test
    public void testSize2() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        arr1 = arr1.remove(1);
        Object answ = arr1.size();
        assertEquals(1, answ);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        arr1 = arr1.remove(1);
        arr1 = arr1.add(3);
        Object answ = arr1.clear();
        assertEquals("", answ.toString());
    }

    @Test
    public void testEmpty1() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        boolean actualResult = arr1.isEmpty();
        assertFalse(actualResult);
    }

    @Test
    public void testEmpty2() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        arr1 = arr1.remove(0);
        boolean actualResult = arr1.isEmpty();
        assertTrue(actualResult);
    }

    @Test
    public void testToArray() {
        ImmutableLinkedList arr1 = new ImmutableLinkedList();
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        Object[] answ = arr1.toArray();
        Object[] expected = {1, 2};
        assertEquals(Arrays.toString(answ), Arrays.toString(expected));
    }
}
