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

    public class Pair{
        int hd;
        TreeNode node;

        Pair(int n, TreeNode root){
            this.hd = n;
            this.node = root;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, List<Integer>> m = new TreeMap<>();
        q.offer(new Pair(0, root));
        while(!q.isEmpty()){
            int n = q.size();
            Map<Integer, List<Integer>> sm = new TreeMap<>();
            while(n!=0){
                Pair p = q.poll();
                int h = p.hd;
                TreeNode node = p.node;
                if(!sm.containsKey(h)){
                    sm.put(h, new ArrayList<>());   
                }
                sm.get(h).add(node.val);
                if(node.left != null){
                    q.offer(new Pair(h-1, node.left));
                }
                if(node.right != null){
                    q.offer(new Pair(h+1, node.right));
                }
                n--;
            }
            for(Map.Entry<Integer, List<Integer>> e : sm.entrySet()){
                int key = e.getKey();
                if(!m.containsKey(key)){
                    m.put(key, new ArrayList<>());   
                }
                List<Integer> li = e.getValue();
                Collections.sort(li);
                for(Integer i : li){
                    m.get(key).add(i);
                }
            }
        }
        for(Map.Entry<Integer, List<Integer>> e : m.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
}