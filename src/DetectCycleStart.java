/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-11 14:57
 */
public class DetectCycleStart {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true){
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        fast = head;
        while (slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
