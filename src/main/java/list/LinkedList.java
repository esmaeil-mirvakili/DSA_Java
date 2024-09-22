package list;

public interface LinkedList<T> {
    public T get(int pos);
    public T getLast();
    public T getFirst();
    public void add(T val, int pos);
    public void add(T val);
    public int size();
    public void clear();
    public T remove(int pos);
    public boolean isEmpty();
}
