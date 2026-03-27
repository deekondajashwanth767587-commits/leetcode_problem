class Solution {
    public int orangesRotting(int[][] grid) {

        //in note book taged gfg
        int n= grid.length;
        int m = grid[0].length;
        int fresh=0;
        int time=0;
        int[][] directions ={{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[] > q= new LinkedList<>();
        for(int i=0;i<n ;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)q.offer(new int[]{i,j});
                else if(grid[i][j]==1)fresh++;
            }
        }

        while(!q.isEmpty() && fresh>0){
            int size=q.size();
             boolean rotten=false;
            for(int i=0;i<size;i++){
                int[] location = q.poll();
                int x= location[0];
                int y = location[1];
                for(int[] dir:directions ){
                    int nx= x+dir[0];
                    int ny= y+dir[1];

                    if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==1 ){
                        rotten=true;
                        fresh--;
                        grid[nx][ny]=2;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            if(rotten)time++;
        

        }

        return (fresh==0)? time:-1;
    }
}