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
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        boolean isLeftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            Deque<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode toRemove = queue.poll();

                if (toRemove.left != null) {
                    queue.add(toRemove.left);
                }

                if (toRemove.right != null) {
                    queue.add(toRemove.right);
                }

                if (isLeftToRight) {
                    levelList.addLast(toRemove.val);
                } else {
                    levelList.addFirst(toRemove.val);
                }
            }

            ans.add((List) levelList);
            isLeftToRight = !isLeftToRight;
        }

        return ans;
    }
}
