class Solution {

    class Pair implements Comparable<Pair>{
        int x;
        int freq;

        Pair(int x, int y){
            this.x = x;
            this.freq = y;
        }

        @Override 
        public int compareTo(Pair p){
            return this.freq-p.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // List<Pair> l = new ArrayList<>();
        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     l.add(new Pair(entry.getKey(), entry.getValue()));
        // }
        // Collections.sort(l);
        // int[] ans = new int[k];
        // for(int i=0;i<k;i++){
        //     ans[i] = l.get(i).x;
        // }
        // return ans

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int size = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(size<k){
                pq.add(new Pair(entry.getKey(), entry.getValue()));
            }else{
                if(pq.peek().freq < entry.getValue()){
                    pq.poll();
                    pq.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }
            size++;
        }
        
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i] = pq.peek().x;
            pq.poll();
        }
        return ans;
    }
}