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
        int h;
        int d;

        Pair(int h, int d){
            this.h = h;
            this.d = d;
        }
    }

    public Pair solve(TreeNode root){
        if(root == null) return new Pair(0,0);
        // if(root.left == null && root.right == null){
        //     return new Pair(1, 0);
        // }
        Pair lp = solve(root.left);
        Pair rp = solve(root.right);
        int h = Math.max(lp.h, rp.h)+1;
        int tempd = lp.h + rp.h;
        int d = Math.max(Math.max(lp.d,rp.d), tempd);
        return new Pair(h,d);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Pair ans = solve(root);
        return ans.d;
    }
}