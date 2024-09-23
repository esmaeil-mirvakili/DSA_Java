package stack;

public interface Stack<T> {
    public void push(T item) throws Exception;
    public T pop();
    public T peek();
    public boolean isEmpty();
    public int size();
}
