public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        char[] stack = new char[len + 1];
        int top = 1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack[top++] = c;
            else if (c == ')' && stack[top - 1] != '(')
                return false;
            else if (c == ']' && stack[top - 1] != '[')
                return false;
            else if (c == '}' && stack[top - 1] != '{')
                return false;
            else
                top--;
        }
        if (top == 1)
            return true;
        return false;
    }
    
    //Another simple solution with system stack
    
    // public boolean isValid(String s) {
    //     Stack<Integer> p = new Stack<>();
    //     for(int i = 0; i < s.length(); i++) {
    //         int q = "(){}[]".indexOf(s.substring(i, i + 1));
    //         if(q % 2 == 1) {
    //             if(p.isEmpty() || p.pop() != q - 1) return false;
    //         } else p.push(q);
    //     }
    //     return p.isEmpty();
    // }
}