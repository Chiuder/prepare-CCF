import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-16 9:56
 */
public class RightViewOfTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int size = que.size();
            for (int i = 0; i < size; i++){
                TreeNode node = que.pop();
                if (i == size - 1)
                    res.add(node.val);
                if (node.left != null)
                    que.offer(node.left);
                if(node.right != null)
                    que.offer(node.right);
            }
        }
        return res;
    }
}
