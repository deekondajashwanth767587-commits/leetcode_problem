class Solution {
    public int pivotInteger(int n) {
        int total=(n*(n+1))/2;
        int coun = (int)Math.sqrt(total);
        if(coun*coun==total){
            return coun;
        }
        return -1;
    }
}