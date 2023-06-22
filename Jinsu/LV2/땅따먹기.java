package LV2;
/**
 * <알고리즘 스터디 45회차 2023.06.06>
 *  LV2_땅따먹기 : https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */

public class EatTheGround {

    //단순구현으로 하면 예외케이스가 나옴
    public int solution2(int[][] land) {
        int answer = 0;
        int beforeSelIdx = 999;
        int afterSelIdx = 999;
        for(int i = 0 ; i< land.length ; i++){
            int max = 0 ;
            
            beforeSelIdx = afterSelIdx;
            for(int j = 0 ; j<4 ; j++){
                if(beforeSelIdx == j )
                    continue;
                
                if(max < land[i][j]){
                    max = land[i][j];
                    afterSelIdx = j;
                }
            }
            answer += max;
        }
        return answer;
    }

    //누적합으로 신규 2차원배열을 생성
    public int solution(int[][] land) {
        int answer[][] = new int[land.length][4];
        int lastMaxIdx = Integer.MIN_VALUE;

        for(int i = 0 ; i < land.length ; i++){
            if(i== 0){
                answer[i][0] = land[i][0];  //0열
                answer[i][1] = land[i][1];  //1열
                answer[i][2] = land[i][2];  //2열
                answer[i][3] = land[i][3];  //3열
            }
            else{
                //n-1행에서 자기열을 제외한 최대값을 누적해서 쌓아올림
                answer[i][0] = land[i][0] + Math.max(Math.max(answer[i-1][1],  answer[i-1][2]),answer[i-1][3]);  //0열
                answer[i][1] = land[i][1] + Math.max(Math.max(answer[i-1][0],  answer[i-1][2]),answer[i-1][3]);  //1열
                answer[i][2] = land[i][2] + Math.max(Math.max(answer[i-1][0],  answer[i-1][1]),answer[i-1][3]);  //2열
                answer[i][3] = land[i][3] + Math.max(Math.max(answer[i-1][0],  answer[i-1][1]),answer[i-1][2]);  //3열
            }
        }

        //n행에서 최대값 찾기
        for(int i = 0 ; i <4 ; i++){
            if(lastMaxIdx < answer[land.length-1][i]){
                lastMaxIdx = answer[land.length-1][i];
            }
        }       
        return lastMaxIdx;
    }
    
}
