package queue;

import list.SinglyLinkedList.Node;

public class LinkedListQueue<T> implements Queue<T>{
    private final Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListQueue() {
        head = new Node<>();
        tail = head;
        size = 0;
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            return null;
        T val = head.next.val;
        if(tail == head.next)
            tail = head;
        head.next = head.next.next;
        size--;
        return val;
    }

    @Override
    public void enqueue(T item) throws Exception {
        tail.next = new Node<>(item);
        tail = tail.next;
        size++;
    }

    @Override
    public T peek() {
        if(isEmpty())
            return null;
        return head.next.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
