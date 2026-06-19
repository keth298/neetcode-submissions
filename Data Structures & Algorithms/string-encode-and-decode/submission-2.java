class Solution {

    public String encode(List<String> strs) {
        StringBuilder code = new StringBuilder();

        for(String s: strs){
            code.append(s.length()).append(':').append(s);
        }

        return code.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int colon = str.indexOf(':', i);
            int length = Integer.parseInt(str.substring(i, colon));
            i = colon + 1;
            strs.add(str.substring(i, i + length));
            i += length;
        }

        return strs;
    }

}