package list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public abstract class LinkedListTest<List extends LinkedList<Integer>> {
    private List list;

    protected abstract List createListInstance();

    @BeforeEach
    public void setUp() {
        list = createListInstance();
    }

    @Test
    @DisplayName("Add items and check the order of them.")
    public void addAndGet(){
        int size = 100;
        for(int i = 0; i < size; i++)
            list.add(i);
        Assertions.assertEquals(list.size(), size);
        for(int i = 0; i < size; i++)
            Assertions.assertEquals(list.get(i), i);
    }

    @Test
    @DisplayName("Add an item to a position.")
    public void addToPosition(){
        int size = 100;
        for(int i = 0; i < size; i++)
            list.add(i);
        Assertions.assertEquals(list.size(), size);

        list.add(100, 10);
        Assertions.assertEquals(list.size(), size + 1);

        Assertions.assertEquals(list.get(10), 100);
        Assertions.assertEquals(list.get(9), 9);
        Assertions.assertEquals(list.get(11), 10);
    }

    @Test
    @DisplayName("Add an item to the end of list.")
    public void addToEnd(){
        int size = 100;
        for(int i = 0; i < size; i++)
            list.add(i);
        Assertions.assertEquals(list.size(), size);

        list.add(100, size);
        Assertions.assertEquals(list.size(), size + 1);

        Assertions.assertEquals(list.get(100), 100);
        Assertions.assertEquals(list.get(99), 99);
    }

    @Test
    @DisplayName("Add an item to the beginning of list.")
    public void addToBeginning(){
        int size = 100;
        for(int i = 0; i < size; i++)
            list.add(i);
        Assertions.assertEquals(list.size(), size);

        list.add(100, 0);
        Assertions.assertEquals(list.size(), size + 1);

        Assertions.assertEquals(list.get(0), 100);
        Assertions.assertEquals(list.get(1), 0);
    }

    @Test
    @DisplayName("Clear the list.")
    public void clearList(){
        int size = 100;
        for(int i = 0; i < size; i++)
            list.add(i);
        Assertions.assertEquals(list.size(), size);

        list.clear();
        Assertions.assertEquals(list.size(), 0);

        Exception thrown = Assertions.assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(0),
                "Expected list.get(0) to throw, but it didn't"
        );

        Assertions.assertTrue(thrown.getMessage().contains("0"));

        list.add(100);
        Assertions.assertEquals(list.size(), 1);
        Assertions.assertEquals(list.get(0), 100);
    }

    @Test
    @DisplayName("Remove an item from list.")
    public void remove(){
        int size = 100;
        for(int i = 0; i < size; i++)
            list.add(i);
        Assertions.assertEquals(list.size(), size);

        list.remove(10);
        Assertions.assertEquals(list.size(), size - 1);
        Assertions.assertEquals(list.get(10), 11);
        Assertions.assertEquals(list.get(9), 9);
    }

    @Test
    @DisplayName("Remove the last item from list.")
    public void removeLast(){
        int size = 100;
        for(int i = 0; i < size; i++)
            list.add(i);
        Assertions.assertEquals(list.size(), size);

        list.remove(size - 1);
        Assertions.assertEquals(list.size(), size - 1);
        Assertions.assertEquals(list.get(98), 98);
    }

    @Test
    @DisplayName("Remove the first item from list.")
    public void removeFirst(){
        int size = 100;
        for(int i = 0; i < size; i++)
            list.add(i);
        Assertions.assertEquals(list.size(), size);

        list.remove(0);
        Assertions.assertEquals(list.size(), size - 1);
        Assertions.assertEquals(list.get(0), 1);
    }

    @Test
    @DisplayName("Test the isEmpty function.")
    public void isEmpty(){
        Assertions.assertTrue(list.isEmpty());
        int size = 100;
        for(int i = 0; i < size; i++)
            list.add(i);
        Assertions.assertEquals(list.size(), size);
        Assertions.assertFalse(list.isEmpty());
    }
}
