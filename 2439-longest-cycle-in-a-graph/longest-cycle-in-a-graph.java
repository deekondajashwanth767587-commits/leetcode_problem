class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] time = new int[n];
        int max=-1;
        int timer=1;
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            int node =i;
            int starttime=timer;
            while(node!=-1 && !visited[node]){
                visited[node]=true;
                time[node]=timer++;
                node=edges[node];



            }
            if(node!=-1 && time[node]>=starttime){
                int cycle = timer-time[node];
                max = Math.max(max , cycle);
                            }
        }
        return max;
    }


}