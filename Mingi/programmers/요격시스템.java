package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 요격시스템 {
    public static void main(String[] args) {
        Solution_요격시스템 s = new Solution_요격시스템();

        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        System.out.println(s.solution(targets));
    }
}

class Solution_요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;

        //System.out.println("targets = " + Arrays.deepToString(targets));

        // 끝나는 시간이 빠른 순서대로 재정렬
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        //System.out.println("targets = " + Arrays.deepToString(targets));

        double tmp = -1;

        for(int[] target : targets){
            // target[0] : 시작지점
            // target[1] : 끝지점
            if(target[0] > tmp || target[1] <= tmp) {
                tmp = target[1] - 0.1;
                answer++;
            }
            //System.out.println("tmp = " + tmp);
        }
        return answer;
    }
}
