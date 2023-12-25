import java.util.List;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-11 16:33
 */
public class ReorderListNode {
    public void reorderList(ListNode head) {
        if (head ==null)
            return;
        ListNode mid = findMiddleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    private ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private void mergeList(ListNode l1, ListNode l2){
        ListNode l1temp;
        ListNode l2temp;
        while (l1 != null && l2 != null){
            l1temp = l1.next;
            l2temp = l2.next;

            l1.next = l2;
            l1 = l1temp;

            l2.next = l1;
            l2 = l2temp;
        }
    }
}
