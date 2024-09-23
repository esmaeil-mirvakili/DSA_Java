package queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedListQueueTest {

    @Test
    @DisplayName("Add items and check the order of them.")
    public void enqueueAndDequeue() throws Exception {
        int size = 100;
        Queue<Integer> q = new LinkedListQueue<>();
        for(int i = 0; i < size; i++)
            q.enqueue(i);
        Assertions.assertEquals(q.size(), size);
        Assertions.assertFalse(q.isEmpty());
        Assertions.assertEquals(q.peek(), 0);
        for(int i = 0; i < size; i++)
            Assertions.assertEquals(q.dequeue(), i);
        Assertions.assertEquals(q.size(), 0);
        Assertions.assertTrue(q.isEmpty());
        Assertions.assertNull(q.dequeue());
        Assertions.assertNull(q.peek());

        for(int i = 0; i < 50; i++)
            q.enqueue(i);
        for(int i = 0; i < 20; i++)
            Assertions.assertEquals(q.dequeue(), i);
        for(int i = 0; i < 60; i++)
            q.enqueue(i);
        for(int i = 20; i < 50; i++)
            Assertions.assertEquals(q.dequeue(), i);
    }
}
