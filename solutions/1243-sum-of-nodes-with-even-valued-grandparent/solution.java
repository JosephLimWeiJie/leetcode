/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, false, false);
        return sum;
    }
    
    public void dfs(TreeNode node, boolean isNodeWithEvenGrandparent, boolean isGrandparentEven) {
        if (isNodeWithEvenGrandparent) {
            sum += node.val;
        }
        
        if (node.left != null) {
            dfs(node.left, isGrandparentEven, node.val % 2 == 0);
        }
        
        if (node.right != null) {
            dfs(node.right, isGrandparentEven, node.val % 2 == 0);
        }
    }
}
