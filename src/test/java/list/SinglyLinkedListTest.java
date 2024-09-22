package list;

public class SinglyLinkedListTest extends LinkedListTest<SinglyLinkedList<Integer>>{
    @Override
    protected SinglyLinkedList<Integer> createListInstance() {
        return new SinglyLinkedList<Integer>();
    }
}
