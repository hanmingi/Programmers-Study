import java.util.Stack;

class Solution_rightBracket {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stackk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stackk.empty() && s.charAt(i) == ')') {
                answer = false;
                break;
            }
            if (s.charAt(i) == '(') {
                stackk.push(s.charAt(i));
            } else {
                stackk.pop();
            }
        }
        if (!stackk.empty())
            answer = false;

        return answer;
    }
}

public class 올바른괄호 {
    public static void main(String[] args) {
        Solution_rightBracket s = new Solution_rightBracket();
        String st = ")()(";
        System.out.println(s.solution(st));
    }
}