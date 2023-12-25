import java.util.List;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-11 13:59
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        //k个链表归并排序
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r){
        if (l == r)
            return lists[l];
        else if (l > r) {
            return null;
        }
        else {
            int mid = l + (r - l) >> 1;
            return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }
            else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
