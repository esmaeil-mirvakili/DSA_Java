package stack;


import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_SIZE = 1000;
    private int capacity;
    private int pointer;
    private T[] array;

    public ArrayStack(){
        this(DEFAULT_SIZE);
    }

    public ArrayStack(int capacity){
        this.capacity = capacity;
        this.pointer = -1;
        this.array = (T[]) new Object[this.capacity];
    }

    @Override
    public void push(T item) throws Exception {
        if(pointer >= capacity - 1)
            throw new Exception("The stack size has reached the capacity of " + capacity);
        array[++pointer] = item;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        return array[pointer--];
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return array[pointer];
    }

    @Override
    public int size() {
        return pointer + 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
