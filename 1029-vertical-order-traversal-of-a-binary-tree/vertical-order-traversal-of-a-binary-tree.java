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
    
    // Class to store a node with its row and column
    public static class NodeInfo {
        TreeNode node;
        int row;
        int col;
        NodeInfo(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map of column -> list of (row, value)
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<NodeInfo> queue = new LinkedList<>();
        
        queue.offer(new NodeInfo(root, 0, 0));
        
        while(!queue.isEmpty()){
            NodeInfo current = queue.poll();
            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;
            
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, node.val});
            
            if(node.left != null) queue.offer(new NodeInfo(node.left, row + 1, col - 1));
            if(node.right != null) queue.offer(new NodeInfo(node.right, row + 1, col + 1));
        }
        
        // Prepare the result
        List<List<Integer>> result = new ArrayList<>();
        
        for(List<int[]> list : map.values()){
            // Sort first by row, then by value if row is same
            list.sort((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<Integer> colList = new ArrayList<>();
            for(int[] pair : list){
                colList.add(pair[1]);
            }
            result.add(colList);
        }
        
        return result;
    }
}