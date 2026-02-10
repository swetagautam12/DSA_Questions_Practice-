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
    public TreeNode func2(int l, int r, List<TreeNode> list){
        if(l > r) return null;
        int mid = l + (r-l)/2 ;
        TreeNode cur = list.get(mid);
        cur.left = func2(l, mid-1, list);
        cur.right = func2(mid+1, r, list);
        return cur;
    }
    public void func(TreeNode node, List<TreeNode> list){
        if(node == null) return;
       
        func(node.left, list);
         list.add(node);
        func(node.right, list);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        func(root, list);
      
        int n = list.size();
        TreeNode node = func2(0, n-1, list);
        return node;
    }
}