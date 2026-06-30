class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && (stack.peek() == (c - 1) || stack.peek() == (c - 2))) stack.pop();
            else stack.push(c);
            System.out.println(stack);
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
