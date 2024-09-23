package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

public class LinkedListStackTest {
    @Test
    @DisplayName("Add items and check the order of them.")
    public void enqueueAndDequeue() throws Exception {
        int size = 100;
        Stack<Integer> stack = new LinkedListStack<>();
        for(int i = 0; i < size; i++)
            stack.push(i);
        Assertions.assertEquals(stack.size(), size);
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(stack.peek(), 99);
        for(int i = size - 1; i >= 0; i--)
            Assertions.assertEquals(stack.pop(), i);
        Assertions.assertEquals(stack.size(), 0);
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertThrows(
                EmptyStackException.class,
                stack::pop,
                "Expected stack.pop() to throw, but it didn't"
        );
        Assertions.assertThrows(
                EmptyStackException.class,
                stack::peek,
                "Expected stack.pop() to throw, but it didn't"
        );

        for(int i = 0; i < 50; i++)
            stack.push(i);
        for(int i = 49; i >= 20; i--)
            Assertions.assertEquals(stack.pop(), i);
        for(int i = 0; i < 10; i++)
            stack.push(i);
        Assertions.assertEquals(stack.size(), 30);
        Assertions.assertEquals(stack.peek(), 9);
    }
}
