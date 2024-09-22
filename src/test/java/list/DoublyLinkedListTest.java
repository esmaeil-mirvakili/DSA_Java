package list;

public class DoublyLinkedListTest extends LinkedListTest<DoublyLinkedList<Integer>>{
    @Override
    protected DoublyLinkedList<Integer> createListInstance() {
        return new DoublyLinkedList<Integer>();
    }
}
