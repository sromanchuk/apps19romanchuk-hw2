package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testAdd() {
        ImmutableList arr1 = new ImmutableArrayList();
        ImmutableList arrn = arr1.add(5);
        String answ = "[5]";
        assertEquals(answ, arrn.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddError() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1.add(100, 5);
    }

    @Test
    public void testAddIndex() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 5);
        String answ = "[1, 5]";
        assertEquals(answ, arr1.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexError() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 5);
        Object got = arr1.get(4);
    }

    @Test
    public void testAddAll() {
        Integer[] lst = {1, 2, 3, 4, 5};
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.addAll(lst);
        String res = "[1, 2, 3, 4, 5]";
        assertEquals(res, arr1.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllError() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 5);
        Integer[] lst = {1, 7};
        ImmutableList got = arr1.addAll(100, lst);
    }

    @Test
    public void testAddAllIndex() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 5);
        String res = "[1, 2, 1, 5]";
        Integer[] lst = {1, 2};
        arr1 = arr1.addAll(0, lst);
        ImmutableList got = arr1;
        assertEquals(res, got.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexError() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        arr1 = arr1.add(3);
        arr1.addAll(5, new Integer[]{1, 4});
    }

    @Test
    public void testGet() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 5);
        arr1 = arr1.add(1, 7);
        arr1 = arr1.add(2, -1);
        Object elem = arr1.get(1);
        String res = "7";
        assertEquals(res, elem.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetError() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 3);
        arr1 = arr1.add(1, 4);
        arr1 = arr1.add(2, 5);
        Integer elem = (Integer) arr1.get(100);
    }

    @Test
    public void testRemove() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0);
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        String res = "[0, 1]";
        ImmutableList arrn = arr1.remove(2);
        assertEquals(res, arrn.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 2);
        ImmutableList arrn = arr1.remove(100);
    }

    @Test
    public void testSet() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0);
        arr1 = arr1.add(1);
        arr1 = arr1.add(2);
        ImmutableList arrn = arr1.set(2, 1);
        String res = "[0, 1, 1]";
        assertEquals(res, arrn.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetError() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 2);
        Object got = arr1.set(50, 5);
    }

    @Test
    public void testIndexOf1() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 3);
        arr1 = arr1.add(4);
        int got = arr1.indexOf(3);
        assertEquals(1, got);
    }

    @Test
    public void testIndexOf2() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 3);
        arr1 = arr1.add(4);
        arr1 = arr1.addAll(new Integer[]{10, 15});
        int arrn = arr1.indexOf(100);
        assertEquals(-1, arrn);
    }

    @Test
    public void testSize1() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 2);
        arr1 = arr1.add(3);
        arr1 = arr1.addAll(0, new Integer[]{10, 15});

        int arrn = arr1.size();
        assertEquals(5, arrn);
    }

    @Test
    public void testSize2() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 2);
        arr1 = arr1.add(3);
        arr1 = arr1.addAll(new Integer[]{10, 15});

        int arrn = arr1.size();
        assertEquals(5, arrn);
    }

    @Test
    public void testClear() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 2);
        arr1 = arr1.add(3);
        ImmutableList arrn = arr1.clear();
        String answ = "[]";
        assertEquals(answ, arrn.toString());
    }

    @Test
    public void testIsEmpty1() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 2);
        arr1 = arr1.add(3);
        boolean answ = arr1.isEmpty();
        assertFalse(answ);
    }

    @Test
    public void testIsEmpty2() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 2);
        arr1 = arr1.add(3);
        arr1 = arr1.clear();
        boolean answ = arr1.isEmpty();
        assertTrue(answ);
    }

    @Test
    public void testToArray() {
        ImmutableList arr1 = new ImmutableArrayList();
        arr1 = arr1.add(0, 1);
        arr1 = arr1.add(1, 2);
        arr1 = arr1.add(3);
        assertEquals(Arrays.toString(new Object[]{1, 2, 3}), Arrays.toString(arr1.toArray()));
    }
}