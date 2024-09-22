package list;

public class DoublyLinkedList<T> implements LinkedList<T>{
    private final Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList(){
        // dummy node
        head = new Node<>();
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
        node.next = new Node<>(val, next, node);
        if(next != null)
            next.prev = node.next;
    }

    private void addBefore(T val, Node<T> node){
        Node<T> prev = node.prev;
        node.prev = new Node<>(val, node, prev);
        if(prev != null)
            prev.next = node.prev;
    }

    @Override
    public void add(T val){
        tail.next = new Node<>(val, null, tail);
        tail = tail.next;
    }

    public void addToBeginning(T val){
        head.next = new Node<>(val, head.next, head);
    }

    @Override
    public void add(T val, int pos){
        if(pos == 0)
            addToBeginning(val);
        else{
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
        if(head.next != null)
            head.prev = null;
        head.next = null;
        tail = head;
    }

    private void remove(Node<T> node){
        Node<T> next = node.next;
        Node<T> prev = node.prev;
        if(prev != null)
            prev.next = next;
        if(next != null)
            next.prev = prev;
        if(node == tail)
            tail = prev;
    }

    @Override
    public T remove(int pos) {
        Node<T> node = getNode(pos);
        if(node == null)
            throw new IndexOutOfBoundsException(pos);
        remove(node);
        return node.val;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    public static class Node<T>{
        public T val;
        public Node<T> next;
        public Node<T> prev;

        public Node(){
            next = null;
        }

        public Node(T val){
            this.val = val;
            next = null;
        }

        public Node(T val, Node<T> next, Node<T> prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
