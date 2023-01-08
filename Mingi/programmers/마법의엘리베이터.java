package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/148653#
public class 마법의엘리베이터 {
    public static void main(String[] args) {
        Solution_ev s = new Solution_ev();

        int t1 = 16;

        System.out.println(s.solution(t1)); // 6

        int t2 = 2554;

        System.out.println(s.solution(t2)); // 16

        int t3 = 58374969;

        System.out.println(s.solution(t3));
    }
}

class Solution_ev {
    public int solution(int storey) {
        int answer = 0;

        String temp = Integer.toString(storey);
        int[] digits = new int[temp.length()];

        for (int i = 0; i < temp.length(); i++)
            digits[i] = temp.charAt(i) - '0';

        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] > 5){
                answer += 10 - digits[i];

                if(i == 0) answer++;
                else digits[i - 1]++;

            } else if (digits[i] == 5 && i > 0 && digits[i - 1] >= 5) {
                answer += 5;
                digits[i - 1]++;
            } else {
                answer += digits[i];
            }
        }
        //System.out.print(Arrays.toString(digits));
        return answer;
    }
}
