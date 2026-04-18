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
    int count= 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = getKthInt(root, k);
        return node != null ? node.val : -1;
    }

    private TreeNode getKthInt(TreeNode node, int k){
        if(node == null) return null;

        TreeNode left = getKthInt(node.left, k);
        
        if(left != null){
            return left;
        }

        count++;
        if(count == k){
            return node;
        }

        return getKthInt(node.right, k);
    }
}
