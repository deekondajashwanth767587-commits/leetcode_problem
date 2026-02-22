class Solution {
    public int subarraySum(int[] nums, int k) {
        int result=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix=0;
        for(int i:nums){
            prefix+=i;
            result+=map.getOrDefault(prefix-k,0);
            if(prefix==k){
                result++;
            }
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        return result;

    }
}