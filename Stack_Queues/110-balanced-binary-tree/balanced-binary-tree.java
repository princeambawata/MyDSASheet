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

    class Pair{
        int height;
        boolean isBT;

        Pair(int x, boolean b){
            this.height = x;
            this.isBT = b;
        }
    }

    public Pair solve(TreeNode root){
        if(root == null) return new Pair(0, true);
        if(root.left == null && root.right == null){
            return new Pair(1, true);
        }
        Pair la = solve(root.left);
        Pair ra = solve(root.right);
        if(la.isBT == false || ra.isBT == false){
            return new Pair(0, false);
        }else{
            int lah = la.height;
            int rah = ra.height;
            int diff = Math.abs(lah-rah);
            if(diff>1) return new Pair(0, false);
            else{
                return new Pair(1+Math.max(lah,rah), true);
            }
        }
    }

    public boolean isBalanced(TreeNode root) {
        Pair ans = solve(root);
        return ans.isBT;
    }
}