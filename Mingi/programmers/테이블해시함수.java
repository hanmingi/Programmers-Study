package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 테이블해시함수 {
    public static void main(String[] args) {
        Solution_th s = new Solution_th();

        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        System.out.println(s.solution(data, col, row_begin, row_end));
    }
}


class Solution_th {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[col - 1] != o2[col - 1] ? o1[col - 1] - o2[col - 1] : o2[0] - o1[0];
            }
        });

        for(int i = row_begin - 1; i <= row_end - 1; i++){
            int S = calcS(data[i], i+1);

            if(answer == 0) answer = S;
            else answer = answer ^ S;
        }

        return answer;
    }

    static int calcS(int[] ds, int s){
        int answer = 0;
        for(int data : ds){
            answer += data % s;
        }
        return answer;
    }
}
