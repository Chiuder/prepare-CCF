/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-11 14:20
 */
public class ReverseBetweenListNode {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //整体思想是：在需要反转的区间里，每遍历到一个节点，让这个新节点来到反转部分的起始位置。
        // 设置 dummyNode，加个表头，是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //pre：永远指向待反转区域的第一个节点 left 的前一个节点，在循环过程中不变。
        ListNode pre = dummyNode;
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }
        //cur：指向待反转区域的第一个节点 left；
        ListNode cur = pre.next;
        //next：永远指向 cur 的下一个节点，循环过程中，cur 变化以后 next 会变化；
        ListNode next;
        for(int i = 0; i < right - left; i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        //去除伪头节点
        return dummyNode.next;
    }
}
