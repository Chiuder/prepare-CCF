import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-08 19:29
 */
public class ReverseBFSBinaryTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        if (root != null){
            que.add(root);
        }
        boolean flag = true;
        while (!que.isEmpty()){
            int size = que.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = que.poll();
                if (flag){
                    temp.offerLast(node.val);
                }
                else {
                    temp.offerFirst(node.val);
                }
                if (node.left != null)
                    que.add(node.left);
                if (node.right != null)
                    que.add(node.right);
                res.add(temp);
            }
            flag = !flag;
        }
        return res;
    }
}
