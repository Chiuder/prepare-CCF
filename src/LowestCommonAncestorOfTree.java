/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description: 二叉树最近公共祖先
 * @author: Chiuder
 * @create: 2023-03-08 20:45
 */
public class LowestCommonAncestorOfTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}
