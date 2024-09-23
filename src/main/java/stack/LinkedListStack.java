package stack;

import list.SinglyLinkedList.Node;

import java.util.EmptyStackException;

public class LinkedListStack<T> implements Stack<T> {
    private final Node<T> head;
    int size;

    public LinkedListStack() {
        head = new Node<>();
        size = 0;
    }

    @Override
    public void push(T item) {
        head.next = new Node<>(item, head.next);
        size++;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        T val = head.next.val;
        head.next = head.next.next;
        size--;
        return val;
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return head.next.val;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public int size() {
        return size;
    }
}
