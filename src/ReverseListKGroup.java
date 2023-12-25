/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-07 16:22
 */
public class ReverseListKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //找到每次翻转的尾部
        ListNode tail = head;
        //遍历k次到尾部
        for(int i = 0; i < k; i++){
            //如果不足k次遍历到了该分组链表的尾部，直接返回，不反转
            if(tail == null)
                return head;
            tail = tail.next;
        }//遍历结束时，tail = 下一个分组的head
        //翻转时需要的前序和当前节点
        ListNode pre = null;
        ListNode cur = head;
        //在到达当前段尾节点前
        while (cur != tail){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        //当前尾指向下一段要翻转的链表
        reverseKGroup(tail, k);
        return pre;
    }
}
