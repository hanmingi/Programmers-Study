import java.util.*;

class Solution_removeMatch {
    public int solution(String s) {
        int answer = -1;
        char[] s_charAr = s.toCharArray();
        Stack<Character> s_stack = new Stack<>();
        for (int i = 0; i < s_charAr.length; i++) {
            if (s_stack.empty())
                s_stack.push(s_charAr[i]);
            else if (s_stack.peek() == s_charAr[i])
                s_stack.pop();
            else
                s_stack.push(s_charAr[i]);
        }
        if (s_stack.empty())
            answer = 1;
        else
            answer = 0;
        return answer;
    }
}

public class 짝지어제거하기 {
    public static void main(String[] args) {
        Solution_removeMatch sol = new Solution_removeMatch();
        String s = "baabaa";
        System.out.println(sol.solution(s));
    }
}