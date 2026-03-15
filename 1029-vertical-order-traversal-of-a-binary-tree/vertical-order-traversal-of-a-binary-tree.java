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
    class Node{
        int row;
        int col;
        TreeNode node;

        Node(int r, int c, TreeNode n){
            this.row =r;
            this.col =c;
            this.node =n;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
            if(a.col != b.col) return Integer.compare(a.col, b.col);
            if(a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.node.val, b.node.val);
        });

        List<List<Integer>> ans = new ArrayList<>();
        populatePQ(pq,root,0,0);

        while(!pq.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int currCol = pq.peek().col;
            while(!pq.isEmpty() && pq.peek().col == currCol){
                Node curr = pq.poll();
                list.add(curr.node.val);
            }
            ans.add(list);
        }
        return ans;
    }

    private void populatePQ(PriorityQueue<Node> pq, TreeNode node, int i, int j){
        if(node == null) return;
        pq.offer(new Node(i,j,node));
        populatePQ(pq, node.left, i+1,j-1);
        populatePQ(pq, node.right, i+1, j+1);
    }
}