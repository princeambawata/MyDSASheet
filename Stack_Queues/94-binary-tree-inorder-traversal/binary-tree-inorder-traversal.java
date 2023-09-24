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

    public void solve(TreeNode root, List<Integer> ans){
        if(root == null) return;
        solve(root.left, ans);
        ans.add(root.val);
        solve(root.right, ans);
        return;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode t = s.peek();
            TreeNode p = null;
            if(t == null){
                s.pop();
                if(!s.isEmpty()){
                    p = s.pop();
                    ans.add(p.val);
                    s.push(p.right);
                }
            }else{
                s.push(t.left);
            }
        }
        return ans;
    }
}