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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        TreeNode root = null;
        HashSet<Integer> set = new HashSet<>();
        for(int[] nums:descriptions){
            TreeNode node = null;
            if(map.containsKey(nums[0])){
                node = map.get(nums[0]);
            }else{
                node = new TreeNode(nums[0]);
            }
            root = node;
            if(nums[2]==1){
                if(!map.containsKey(nums[1])){
                    node.left = new TreeNode(nums[1]);
                    map.put(nums[1],node.left);
                }else{
                    node.left = map.get(nums[1]);
                }
            }else{
                if(!map.containsKey(nums[1])){
                    node.right = new TreeNode(nums[1]);
                    map.put(nums[1],node.right);
                }else{
                    node.right = map.get(nums[1]);
                }
            }
            map.put(nums[0],node);
            set.add(nums[1]);
        }
        for(int[] nums:descriptions){
            if(!set.contains(nums[0])){
                return map.get(nums[0]);
            }
        }
        return null;
    }
}