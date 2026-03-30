class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        
        int[] even = new int[26]; // even indices
        int[] odd = new int[26];  // odd indices
        
        // Count frequencies for s1
        for (int i = 0; i < n; i++) {
            char c = s1.charAt(i);
            if (i % 2 == 0) {
                even[c - 'a']++;
            } else {
                odd[c - 'a']++;
            }
        }
        
        // Subtract frequencies using s2
        for (int i = 0; i < n; i++) {
            char c = s2.charAt(i);
            if (i % 2 == 0) {
                even[c - 'a']--;
            } else {
                odd[c - 'a']--;
            }
        }
        
        // Check if both arrays are zero
        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}