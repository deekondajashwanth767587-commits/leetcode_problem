class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        
        int[] even = new int[26]; 
        int[] odd = new int[26];  
        
         for (int i = 0; i < n; i++) {
            char c = s1.charAt(i);
            if (i % 2 == 0) {
                even[c - 'a']++;
            } else {
                odd[c - 'a']++;
            }
        }
        
         for (int i = 0; i < n; i++) {
            char c = s2.charAt(i);
            if (i % 2 == 0) {
                even[c - 'a']--;
            } else {
                odd[c - 'a']--;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}