/**
 * @BelongsPackage: PACKAGE_NAME
 * @Description:
 * @author: Chiuder
 * @create: 2023-03-14 14:42
 */
public class MaxPathSumOfTree {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node){
        if (node == null)
            return 0;
        int leftGain = Math.max(maxGain(node.left),0);
        int rightGain = Math.max(maxGain(node.right),0);

        int priceNewPath = node.val + leftGain + rightGain;
        maxSum = Math.max(priceNewPath, maxSum);
        return node.val + Math.max(leftGain, rightGain);
    }
}
