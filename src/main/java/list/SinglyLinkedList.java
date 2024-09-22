package list;

public class SinglyLinkedList<T> implements LinkedList<T>{
    private final Node<T> head;
    private Node<T> tail;

    public SinglyLinkedList(){
        // dummy node
        head = new Node<T>();
        tail = head;
    }

    private Node<T> getNode(int pos){
        Node<T> node = head;
        while(node != null && pos >= 0){
            node = node.next;
            pos--;
        }
        return node;
    }

    @Override
    public T get(int pos){
        Node<T> node = getNode(pos);
        if(node == null)
            throw new IndexOutOfBoundsException(pos);
        return node.val;
    }

    @Override
    public T getLast() {
        if(tail == head)
            return null;
        return tail.val;
    }

    @Override
    public T getFirst() {
        if(head.next == null)
            return null;
        return head.next.val;
    }

    private void addAfter(T val, Node<T> node){
        Node<T> next = node.next;
        node.next = new Node<>(val, next);
    }

    @Override
    public void add(T val){
        addAfter(val, tail);
        tail = tail.next;
    }

    public void addToBeginning(T val){
        addAfter(val, head);
    }

    @Override
    public void add(T val, int pos){
        if(pos == 0)
            addToBeginning(val);
        else {
            Node<T> node = getNode(pos - 1);
            if(node == null)
                throw new IndexOutOfBoundsException(pos);
            addAfter(val, node);
        }
    }

    @Override
    public int size(){
        int size = 0;
        Node<T> node = head.next;
        while(node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    @Override
    public void clear() {
        head.next = null;
        tail = head;
    }

    private Node<T> removeAfter(Node<T> prev){
        if(prev == null)
            return null;
        Node<T> toBeRemoved = prev.next;
        prev.next = toBeRemoved != null ? toBeRemoved.next : null;
        return toBeRemoved;
    }

    @Override
    public T remove(int pos) {
        Node<T> deleted = null;
        if(pos == 0)
            deleted = removeAfter(head);
        else {
            Node<T> node = getNode(pos - 1);
            if(node == null)
                throw new IndexOutOfBoundsException(pos);
            deleted = removeAfter(node);
        }
        return deleted.val;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    public static class Node<T>{
        public T val;
        public Node<T> next;

        public Node(){
            next = null;
        }

        public Node(T val){
            this.val = val;
            next = null;
        }

        public Node(T val, Node<T> next){
            this.val = val;
            this.next = next;
        }
    }
}
