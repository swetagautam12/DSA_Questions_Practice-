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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> ans = new ArrayList<>();
       dfs(root,0,ans);
       return ans;

    }
    private void dfs(TreeNode root , int i , List <List<Integer>> ans){
        if(root==null) return ;
        if(ans.size()==i){
            ans.add(new ArrayList<>());

        }
        if(i%2==0) ans .get(i).add(root.val);
        else ans.get(i).add(0,root.val);
        dfs(root.left,i+1,ans);
        dfs(root.right,i+1,ans);
    }
}