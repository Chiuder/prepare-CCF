import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-08 14:16
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BFSBinaryTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        if (root != null)
            que.add(root);
        while (!que.isEmpty()){
            int size = que.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = que.poll();
                temp.add(node.val);
                if (node.left != null)
                    que.add(node.left);
                if (node.right != null)
                    que.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
