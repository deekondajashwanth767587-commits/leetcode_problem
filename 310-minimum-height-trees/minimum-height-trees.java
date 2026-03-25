class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       List<Integer> res = new ArrayList<>();
       if(n==1){
        res.add(0);
        return res;
       }
       List<List<Integer>> graph = new ArrayList<>();
       for(int i=0;i<n;i++){
        graph.add(new ArrayList<>());
       }
        int[] degree = new int[n];
        for(int[] edge :edges){
            int u=edge[0];
              int v=edge[1];
              graph.get(u).add(v);
              graph.get(v).add(u);
              degree[u]++;
              degree[v]++;

        }
       
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n ;i++){
            if(degree[i]==1){
                q.offer(i);
            }
        }
        int remain=n;
        while(remain>2){
            int size = q.size();
            remain-=size;
            for(int i=0;i<size;i++){
                int leaf= q.poll();
                for(int x:graph.get(leaf)){
                    degree[x]--;
                    if(degree[x]==1)q.offer(x);

                }
            }
        }
        
       while(!q.isEmpty())res.add(q.poll());
       return res;
    }
}