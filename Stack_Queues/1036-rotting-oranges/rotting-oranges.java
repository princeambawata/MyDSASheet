class Solution {

    class Pair {
        int x;
        int y;
        int t;

        Pair(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            int xc = p.x;
            int yc = p.y;
            int tc = p.t;
            ans = Math.max(ans, tc);
            if(xc-1>=0 && grid[xc-1][yc] == 1){
                grid[xc-1][yc] = 2;
                q.offer(new Pair(xc-1, yc, tc+1));
            }
            if(yc-1>=0 && grid[xc][yc-1] == 1){
                grid[xc][yc-1] = 2;
                q.offer(new Pair(xc, yc-1, tc+1));
            }
            if(xc+1<n && grid[xc+1][yc] == 1){
                grid[xc+1][yc] = 2;
                q.offer(new Pair(xc+1, yc, tc+1));
            }
            if(yc+1<m && grid[xc][yc+1] == 1){
                grid[xc][yc+1] = 2;
                q.offer(new Pair(xc, yc+1, tc+1));
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}