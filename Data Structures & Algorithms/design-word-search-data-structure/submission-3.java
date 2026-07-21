class WordDictionary {
    char val;
    Map<Character,WordDictionary> children;
    boolean end = false;
    public WordDictionary() {
        val = ' ';
        children = new HashMap<>();
    }

    public void addWord(String word) {
        Map<Character,WordDictionary> curr = children;
        int i = 0;
        while(i < word.length()){
            if(!curr.containsKey(word.charAt(i))) curr.put(word.charAt(i), new WordDictionary()); 
            if(i == word.length() - 1) curr.get(word.charAt(i)).end = true;
            curr = curr.get(word.charAt(i++)).children;
        }
    }

    public boolean search(String word) {
        return bfs(word, children, 0);
    }

    private boolean bfs(String word, Map<Character,WordDictionary> curr, int i){
        while(i < word.length()){
            if(word.charAt(i) == '.'){
                boolean validSkip = false;
                for(Character c: curr.keySet()){
                    if (i == word.length() - 1) {
                        if (curr.get(c).end) return true;
                    } else {
                        if (bfs(word, curr.get(c).children, i + 1)) return true;
                    }
                }
                return false;
            }
            if(!curr.containsKey(word.charAt(i))){
                return false;
            }
            if(i == word.length() - 1) return curr.get(word.charAt(i)).end;
            curr = curr.get(word.charAt(i++)).children;
        }
        return false;
    }
}