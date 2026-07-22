class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        int l = 0, r = 0;
        int max = 0;
        int bestL = l;
        for(int m = 0; m < s.length(); m++){
            l = m; 
            r = m;
            while(l > 0 && s.charAt(l - 1) == s.charAt(m)) l--;
            while(r < s.length() - 2 && s.charAt(r + 1) == s.charAt(m)) r++;
            System.out.println("" + l + "." + r);
            while(l > 0 && r < s.length() - 1 && s.charAt(l - 1) ==  s.charAt(r + 1)){
                l--; 
                r++;
            }
            if(r - l + 1 > max){
                max = r - l + 1;
                bestL = l;
            }
            System.out.println("" + bestL + "." + max);
        }
        return s.substring(bestL, max + bestL);
    }
}
