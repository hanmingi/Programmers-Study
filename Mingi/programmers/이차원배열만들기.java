package programmers;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120842
 */

public class 이차원배열만들기 {
    public static void main(String[] args) {
        Solution_이차원배열 s = new Solution_이차원배열();

        int[] nl = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = 3;
        System.out.println(Arrays.deepToString(s.solution(nl, n)));
    }
}

class Solution_이차원배열 {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        int idx = 0;
        for(int i = 0; i < (int)(num_list.length / n); i++){
            for(int j = 0; j < n; j++){
                answer[i][j] = num_list[idx];
                idx++;
            }
        }
        return answer;
    }
}