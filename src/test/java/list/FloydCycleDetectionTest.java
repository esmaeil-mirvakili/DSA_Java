package list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import list.FloydCycleDetection.ListNode;

public class FloydCycleDetectionTest {
    public ListNode createList(int num, boolean cycle, int cycleSource) {
        ListNode dummy = new ListNode();
        ListNode node = dummy, cycleNode = null;
        for(int i = 0; i < num; i++){
            node.next = new ListNode(i);
            node = node.next;
            if(cycle && cycleSource == i)
                cycleNode = node;
        }
        node.next = cycleNode;
        return dummy.next;
    }

    @Test
    @DisplayName("Detect cycle.")
    public void detectCycle(){
        int size = 100;
        ListNode headWithCycle = createList(size, true, 50);
        boolean cycle = FloydCycleDetection.detectCycle(headWithCycle);
        Assertions.assertTrue(cycle);

        headWithCycle = createList(size, true, 0);
        cycle = FloydCycleDetection.detectCycle(headWithCycle);
        Assertions.assertTrue(cycle);

        headWithCycle = createList(size, true, 99);
        cycle = FloydCycleDetection.detectCycle(headWithCycle);
        Assertions.assertTrue(cycle);

        ListNode headWithoutCycle = createList(size, false, 0);
        cycle = FloydCycleDetection.detectCycle(headWithoutCycle);
        Assertions.assertFalse(cycle);
    }

    @Test
    @DisplayName("Find cycle.")
    public void findCycle(){
        int size = 100;
        ListNode headWithCycle = createList(size, true, 50);
        ListNode cycle = FloydCycleDetection.findCycle(headWithCycle);
        Assertions.assertNotNull(cycle);
        Assertions.assertEquals(cycle.val, 50);

        headWithCycle = createList(size, true, 0);
        cycle = FloydCycleDetection.findCycle(headWithCycle);
        Assertions.assertNotNull(cycle);
        Assertions.assertEquals(cycle.val, 0);

        headWithCycle = createList(size, true, 99);
        cycle = FloydCycleDetection.findCycle(headWithCycle);
        Assertions.assertNotNull(cycle);
        Assertions.assertEquals(cycle.val, 99);

        ListNode headWithoutCycle = createList(size, false, 0);
        cycle = FloydCycleDetection.findCycle(headWithoutCycle);
        Assertions.assertNull(cycle);
    }
}
