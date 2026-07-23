class Solution {
    public int countSubstrings(String s) {
        int[] numSubstrings = numSubstrings(s);
        int sum = 0;
        for(int num: numSubstrings) sum += (num + 1) / 2;
        return sum;                                                                                                                                                                                                                                                                                                                                                                                                                
    }

    public int[] numSubstrings(String s){
        StringBuilder t = new StringBuilder();
        t.append('#');
        for(char c: s.toCharArray()) t.append(c).append('#');
        int n = t.length();

        int[] p = new int[n];

        int center = 0, right = 0;

        for(int i = 0; i < n; i++){
            int mirror = 2 * center - i;
            p[i] = i < right? Math.min(p[mirror], right - i): 0;

            while(i - p[i] - 1 >= 0 && i + p[i] + 1 < n && t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) p[i]++;

            if(p[i] > right - center + 1){
                right = p[i];
                center = i;
            }
        }
        for(int num: p) System.out.print(num);
        return p;
    }       
}
