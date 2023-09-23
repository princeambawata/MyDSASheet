class Solution {

    class Pair{
        int val;
        int freq;

        Pair(int v, int f){
            this.val = v;
            this.freq = f;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(m.containsKey(nums[i])){
                m.put(nums[i], m.get(nums[i]) + 1);
            }else{
                m.put(nums[i], 1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.freq,b.freq);
        });
        for(Map.Entry<Integer, Integer> e : m.entrySet()){
            if(pq.size()<k){
                pq.offer(new Pair(e.getKey(), e.getValue()));
            }else{
                if(pq.peek().freq < e.getValue()){
                    pq.poll();
                    pq.offer(new Pair(e.getKey(), e.getValue()));
                }
            }
        }
        int ans[] = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ans[i++] = p.val;
        }
        return ans;
    }
}