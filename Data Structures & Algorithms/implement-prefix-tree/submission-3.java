class PrefixTree {
    Character val;
    Map<Character, PrefixTree> children;
    boolean end = false;
    public PrefixTree() {
        val = ' ';
        children = new HashMap<>();
    }

    public void insert(String word) {
        int i = 0;
        Map<Character, PrefixTree> curr = children;
        while(i < word.length()){
            char c = word.charAt(i);
            if(!curr.containsKey(c)){
                curr.put(c, new PrefixTree());
                curr.get(c).val = c;
            }
            if(i == word.length() - 1) curr.get(c).end = true;
            curr = curr.get(c).children;
            i++;
        }
    }

    public boolean search(String word) {
        int i = 0;
        Map<Character, PrefixTree> curr = children;
        while(i < word.length()){
            char c = word.charAt(i);
            if(!curr.containsKey(c)){
                return false;
            }
            if(i == word.length() - 1) return curr.get(c).end;
            curr = curr.get(c).children;
            i++;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        int i = 0;
        Map<Character, PrefixTree> curr = children;
        while(i < prefix.length()){
            char c = prefix.charAt(i);
            if(!curr.containsKey(c)){
                return false;
            }
            curr = curr.get(c).children;
            i++;
        }
        return true;
    }
}
