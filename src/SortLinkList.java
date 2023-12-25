import java.util.List;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-16 14:50
 */
public class SortLinkList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while (left != null && right != null){
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right.next;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return dummyNode.next;
    }
}
