class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j = numbers.length-1;
        int diff =0;
        int[] result=new int[2];
        while(i<numbers.length && j>=0){
            int currsum = numbers[i]+numbers[j];
            if(currsum==target){
                result[0]=i+1;
                result[1]=j+1;
                return result;
            }else if(currsum >target){
                j--;
            }else{
                i++;
            }
        }
        

        return result;
    }


}