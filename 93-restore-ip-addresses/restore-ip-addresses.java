class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        backtrack( s , 0,0,"",result);
        return result;
    }
    void backtrack(String s , int index , int parts , String curr ,List<String> result){
            if(parts==4 && index==s.length()){
                result.add(curr.substring(0, curr.length()-1));
                return ;

            }
            if(parts==4 || index==s.length())return ;
            for(int len =1;len<=3 &&  index+len<=s.length();len++){
                String segment = s.substring(index , index+len);
                if((segment.length()>1 && segment.charAt(0)=='0') || Integer.parseInt(segment)>255)continue;
                backtrack(s, index+len , parts+1 , curr+segment+".", result);
            }
    }
}