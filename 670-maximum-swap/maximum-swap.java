class Solution {
    public int maximumSwap(int num) {
        int left=-1;
        int right =-1;
        
        char[] arr = Integer.toString(num).toCharArray();
         int max=arr.length-1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>arr[max])max=i;
            else if(arr[i]<arr[max]){
                right=max;
                left=i;
            }
        }
        if(left!=-1){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        return Integer.parseInt(new String(arr));
    }
}