import java.util.Arrays;

class Solution_hrEvaluation {
    public int solution(int[][] scores) {
        int answer = 1;

        // (1) 주어진 두가지 점수가 다른 사원들보다 모두 낮은 경우가 한 번이라도 있는지 체크
        // for (int i = 0; i < scores.length; i++) {
        //     for (int j = 0; j < scores.length; j++) {
        //         if (i != j && scores[i][0] < scores[j][0]) {
        //             if (scores[i][1] < scores[j][1]) { // = (1)의 경우
        //                 if (i == 0) { // (1)의 경우가 완호면 -1 리턴
        //                     answer = -1;
        //                     return answer;
        //                 } else { // 다른 사람이면 인센티브 등수에 의미없도록 -1 넣음
        //                     scores[i][0] = -1;
        //                     scores[i][1] = -1;
        //                 }
        //             }
        //         }
        //     }
        // }

        Arrays.sort(scores,(a,b)->a[0]==b[0] ? -(a[1]-b[1]) : -(a[0]-b[0]));
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[0].length; j++) {
                System.out.print(scores[i][j]+",");
            }
            System.out.println();
        }
        if(scores[scores.length-1][1] < scores[scores.length -2][1]){}

        // 2) 완호가 아니면 두 점수 합으로 등수 매기기
        int wanhoScore = scores[0][0] + scores[0][1];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][0] + scores[i][1] > wanhoScore)
                answer++;
        }

        return answer;
    }
}

public class 인사고과 {
    public static void main(String[] args) {
        Solution_hrEvaluation sol = new Solution_hrEvaluation();
        int[][] scores = { { 2, 2 }, { 1, 4 }, { 3, 2 }, { 3, 2 }, { 2, 1 } };
        System.out.println(sol.solution(scores));
    }
}