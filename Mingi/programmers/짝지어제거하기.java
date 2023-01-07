package programmers;

import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        Solution_pair s = new Solution_pair();

        String s1 = "baabaa";
        String s2 = "cdcd";

        System.out.println(s.solution(s1));
        System.out.println(s.solution(s2));
    }
}

class Solution_pair
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}