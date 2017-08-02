public class Solution {
    public boolean isValid1(String s) {
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


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else { // ) ] }的情况，不能出现在一开始，也不能不与栈顶的匹配
                if (stack.isEmpty() || stack.pop() != c)
                    return false;
            }
        }

        return stack.isEmpty();
    }
}