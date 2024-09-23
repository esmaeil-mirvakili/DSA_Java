package queue;

public class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_SIZE = 1000;
    private int capacity;
    private int size;
    private int front;
    private int rear;
    private T[] array;

    public ArrayQueue(){
        this(DEFAULT_SIZE);
    }

    public ArrayQueue(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.rear = -1;
        this.front = -1;
        this.array = (T[]) new Object[this.capacity];
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            return null;
        T val = array[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    @Override
    public void enqueue(T item) throws Exception {
        if(size() >= capacity)
            throw new Exception("The queue size has reached the capacity of " + capacity);
        rear = (rear + 1) % capacity;
        if(front < 0)
            front = rear;
        array[rear] = item;
        size++;
    }

    @Override
    public T peek() {
        if(isEmpty())
            return null;
        return array[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
