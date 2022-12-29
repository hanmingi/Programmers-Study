package programmers;

import java.util.Stack;

public class 괄호회전 {
    public static void main(String[] args) {
        Solution_괄호회전 s = new Solution_괄호회전();

        String s1 = "{}[]()";

        System.out.println(s.solution(s1));
    }
}

class Solution_괄호회전 {
    public int solution(String s) {
        int answer = 0;
        String temp = s;

        for(int i = 0; i < s.length(); i++){
            if(checkAnswer(temp)){
                answer++;
            }
            temp = temp.substring(1, s.length()) + temp.charAt(0);
        }
        return answer;
    }

    static boolean checkAnswer(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            try
            {
                switch (s.charAt(i)){
                    case '[':
                        stack.add('[');
                        break;
                    case ']':
                        if(stack.peek() != '[') return false;
                        stack.pop();
                        break;
                    case '{':
                        stack.add('{');
                        break;
                    case '}':
                        if(stack.peek() != '{') return false;
                        stack.pop();
                        break;
                    case '(':
                        stack.add('(');
                        break;
                    case ')':
                        if(stack.peek() != '(') return false;
                        stack.pop();
                        break;
                }

            }catch (Exception e)
            {
                return false;
            }
        }
        return stack.isEmpty();
    }
}