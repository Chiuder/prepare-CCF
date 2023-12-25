import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-14 16:03
 */
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i <= n; i++){
            right = right.next;
        }
        while (right != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummyNode.next;
    }
}
