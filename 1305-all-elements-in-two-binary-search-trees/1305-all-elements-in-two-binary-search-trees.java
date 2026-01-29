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
    void find(TreeNode root, List<Integer> a) {
        if(root==null) return;
        find(root.left,a);
        a.add(root.val);
        find(root.right,a);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        find(root1,a);
        find(root2,b);
        a.addAll(b);
        Collections.sort(a);
        return a;
    }
}