package queue;

public interface Queue<T> {
    public T dequeue();
    public void enqueue(T item) throws Exception;
    public T peek();
    public int size();
    public boolean isEmpty();
}
