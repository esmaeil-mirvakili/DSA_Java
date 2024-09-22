package list;

public class FloydCycleDetection {
    public static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(){}

        public ListNode(int val){
            this.val = val;
        }

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static boolean detectCycle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static ListNode findCycle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(fast == null || fast.next == null)
            return null;
        ListNode node = head;
        while(node != slow){
            slow = slow.next;
            node = node.next;
        }
        return node;
    }
}
