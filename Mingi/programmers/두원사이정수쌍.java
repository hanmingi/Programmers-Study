package programmers;

public class 두원사이정수쌍 {
    public static void main(String[] args) {
        Solution_twoCircle s = new Solution_twoCircle();

        int r1 = 2;
        int r2 = 3;

        // answer = 20
        System.out.println(s.solution(r1, r2));
    }
}


class Solution_twoCircle {
    public long solution(int r1, int r2) {
        long answer = 0;

        // y^2 = r^2 - x^2

        // 문제 조건이 r1 <= r2
        for(int x = 1; x <= r2; x++) {
            double in = Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2));
            double out = Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));

            in = (int) Math.ceil(in);
            out = (int) Math.floor(out);

            answer += (long) (out - in + 1);
        }
        return answer * 4;
    }
}