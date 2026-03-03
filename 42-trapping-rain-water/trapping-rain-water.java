class Solution {
    public int trap(int[] height) {
        int left =0;
        int right = height.length-1;
        int leftmax=0;
        int rightmax=0;
        int result=0;
        while(right>=left){
            if(height[left]<height[right]){
             leftmax=Math.max(leftmax, height[left]);
             result+=leftmax-height[left];
             left++;

            }else{
                rightmax=Math.max(rightmax,height[right]);
                result+=rightmax-height[right];
                right--;
            }
            
        }
        return result;
        
    }
}