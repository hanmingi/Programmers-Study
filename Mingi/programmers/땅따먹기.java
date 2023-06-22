package programmers;

import java.util.Arrays;

public class 땅따먹기 {
    public static void main(String[] args) {
        Solution_land s = new Solution_land();

        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}; // 16

        System.out.println(s.solution(land));
    }
}


class Solution_land {
    int solution(int[][] land) {
        int answer = 0;

        int[][] s = new int[land.length][4];

        System.arraycopy(land[0], 0, s[0], 0, 4);

        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < 4; j++){
                int max = 0;
                for(int k = 0; k < 4; k++){
                    if(j!=k) max = Math.max(max, s[i-1][k]);
                }
                s[i][j] = max + land[i][j];
            }
            System.out.println("s = " + Arrays.deepToString(s));
        }

        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, s[land.length - 1][i]);
        }
        return answer;
    }
}