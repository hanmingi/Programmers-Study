package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 인사고과 {
    public static void main(String[] args) {
        Solution_인사고과 s = new Solution_인사고과();

        int[][] scores = {{2,2}, {1,4}, {3,2}, {3,2}, {2,1}};

        System.out.println(s.solution(scores)); //4
    }
}

class Solution_인사고과 {
    public int solution(int[][] scores) {
        int answer = 0;
        int checkScore = 0;

        // 원호의 점수 배열
        int[] wh = scores[0];
        int whSum = wh[0] + wh[1];

        // 정렬 원리
        // 근무태도가 동점일 경우 동료평가 점수를 오름차순으로 구현
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        });

        for(int[] score : scores){

            // 인센티브 탈락 대상
            if(score[1] < checkScore){

                //만일 원호의 배열과 동일하면 원호도 인센 제외 대상이기 때문에 -1 리턴
                if(Arrays.equals(wh, score)) return -1;
            }

            // 인센티브 대상자
            else{
                checkScore = score[1];

                //
                if(score[0] + score[1] > whSum) answer++;
            }
        }
        return answer + 1;
    }
}

//import java.util.*;
//
//class Solution {
//    public int solution(int[][] scores) {
//        int answer = 0;
//
//        int max = 0;
//        int wh = scores[0][0] + scores[0][1];
//
//        boolean[] incentive = new boolean[scores.length];
//        Arrays.fill(incentive, true);
//
//        // 인센티브를 못 받는 사람들 체크
//        for(int i = 0; i < scores.length; i++){
//            if(max < scores[i][0] + scores[i][1]) max = scores[i][0] + scores[i][1];
//
//            for(int j = 0; j < scores.length; j++){
//                if(i == j) continue;
//
//                if(scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]){
//                    incentive[i] = false;
//                    break;
//                }
//            }
//        }
//        if(!incentive[0]) return -1;
//
//        Map<Integer, Integer> treemap = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//
//        for(int i = 0; i < scores.length; i++){
//            if(!incentive[i]) continue;
//            treemap.put(scores[i][0] + scores[i][1], treemap.getOrDefault(scores[i][0] + scores[i][1], 0) + 1);
//        }
//
//        for(int i = max; i > wh; i--){
//            answer += treemap.get(i);
//        }
//
//        return answer + 1;
//    }
//}