package programmers;

import java.util.Arrays;

public class 하노이의탑 {
    public static void main(String[] args) {
        Solution_hanoi s = new Solution_hanoi();

        int n = 2;

        System.out.println(Arrays.deepToString(s.solution(n)));
    }
}

class Solution_hanoi {
    static int[][] answer;
    static int idx = 0;
    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2, n) - 1][2];

        hanoi(n, 1, 3, 2);

        return answer;
    }

    static void hanoi(int n, int from, int to, int other){

        if(n == 0) return;
        else{

            hanoi(n - 1, from, other, to);

//            answer[idx][0] = from;
//            answer[idx][1] = to;
            answer[idx++] = new int[] {from, to};

            hanoi(n - 1, other, to, from);

        }
    }
}