import java.util.Stack;

class Solution_rightBracket {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stackk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stackk.empty() && s.charAt(i) == ')') { // 스택이 비어있는데 ')'가 들어오면
                answer = false; // 괄호 안 열었는데 닫은 것이므로 바로 false 리턴 후 for문 종료
                break;
            }
            if (s.charAt(i) == '(') { // '(' 는 스택에 넣음
                stackk.push(s.charAt(i));
            } else { // ')' 는 스택에 넣지 않고 직전 값을 빼냄(어차피 스택에는 '('만 들어가 있음)
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