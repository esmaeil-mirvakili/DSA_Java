package LinkedList;

public class DoublyLinkedList<T> implements LinkedList<T>{
    private final Node head;
    private Node tail;

    public DoublyLinkedList(){
        // dummy node
        head = new Node();
        tail = head;
    }
    private Node getNode(int pos){
        Node node = head;
        while(node != null && pos >= 0){
            node = node.next;
            pos--;
        }
        return node;
    }

    @Override
    public T get(int pos){
        Node node = getNode(pos);
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

    private void addAfter(T val, Node node){
        Node next = node.next;
        node.next = new Node(val, next, node);
        if(next != null)
            next.prev = node.next;
    }

    private void addBefore(T val, Node node){
        Node prev = node.prev;
        node.prev = new Node(val, node, prev);
        if(prev != null)
            prev.next = node.prev;
    }

    @Override
    public void add(T val){
        tail.next = new Node(val, null, tail);
        tail = tail.next;
    }

    public void addToBeginning(T val){
        head.next = new Node(val, head.next, head);
    }

    @Override
    public void add(T val, int pos){
        if(pos == 0)
            addToBeginning(val);
        else{
            Node node = getNode(pos - 1);
            if(node == null)
                throw new IndexOutOfBoundsException(pos);
            addAfter(val, node);
        }
    }

    @Override
    public int size(){
        int size = 0;
        Node node = head.next;
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

    private void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        if(prev != null)
            prev.next = next;
        if(next != null)
            next.prev = prev;
        if(node == tail)
            tail = prev;
    }

    @Override
    public T remove(int pos) {
        Node node = getNode(pos);
        if(node == null)
            throw new IndexOutOfBoundsException(pos);
        remove(node);
        return node.val;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    private class Node{
        public T val;
        public Node next;
        public Node prev;

        public Node(){
            next = null;
        }

        public Node(T val){
            this.val = val;
            next = null;
        }

        public Node(T val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
