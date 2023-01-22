package programmers;

public class 문자열나누기 {
    public static void main(String[] args) {
        Solution_문자열나누기 s = new Solution_문자열나누기();

        //3
        System.out.println(s.solution("banana"));

        //6
        System.out.println(s.solution("abracadabra"));

        //3
        System.out.println(s.solution("aaabbaccccabba"));
    }
}

class Solution_문자열나누기 {
    public int solution(String s) {
        int answer = 0;

        // 첫번째 문자 추출
        char c = s.charAt(0);

        // idx : 처음나온 문자의 갯수
        // jdx : 처음나온 문자가 아닌 문자의 갯수
        int idx = 0, jdx = 0;

        for (int i = 0; i < s.length(); i++) {

            // 문제의 첫번째 요건 : 처음나온 문자의 갯수와 처음나온 문자가 아닌 문자의 갯수가 동일할 때
            // 문자열을 분리하기 때문에 answer 를 증가 시켜준 후 c 즉, 첫번째 문자를 저장한다.
            if (idx == jdx) {
                answer++;
                c = s.charAt(i);
            }

            // 추출한 첫번째 문자와 동일할 경우 idx 를 증가
            // 첫번째 문자가 아닐 경우 jdx 증가
            if (s.charAt(i) == c) idx++;
            else jdx++;
        }

        return answer;
    }
}
