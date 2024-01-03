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

    public TreeNode getRMN(TreeNode child, TreeNode root){
        while(child.right != null && child.right != root){
            child = child.right;
        }
        return child;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeNode temp = root;
        while(temp != null){
            if(temp.left != null){
                TreeNode rmn = getRMN(temp.left, temp);
                if(rmn.right == temp){
                    ans.add(temp.val);
                    temp = temp.right;
                    rmn.right = null;
                }else{
                    rmn.right = temp;
                    temp = temp.left;
                }
            }else{
                ans.add(temp.val);
                temp = temp.right;
            }
        }
        return ans;
    }
}