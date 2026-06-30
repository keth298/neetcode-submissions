class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> curr = new ArrayDeque<>();
        for(String elem: tokens){
            if(elem.equals("+")){
                int num1 = curr.pop();
                int num2 = curr.pop();
                curr.push(num2 + num1);
            } else if(elem.equals("-")) {
                int num1 = curr.pop();
                int num2 = curr.pop();
                curr.push(num2 - num1);
            } else if(elem.equals("*")) {
                int num1 = curr.pop();
                int num2 = curr.pop();
                curr.push(num2 * num1);
            } else if(elem.equals("/")) {
                int num1 = curr.pop();
                int num2 = curr.pop();
                curr.push(num2 / num1);
            } else {
                int num = 0;
                if(elem.charAt(0) == '-'){
                    num = -1 * Integer.parseInt(elem.substring(1));
                } else{
                    num = Integer.parseInt(elem.substring(0));
                }
                curr.push(num);
            }
        }
        return curr.peek();
    }
}
