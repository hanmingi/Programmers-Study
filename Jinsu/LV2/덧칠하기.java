package LV2;

import java.util.Arrays;

public class PaintOver {
    /**
     * @param int n : 벽의 길이
     * @param int m : 롤러의 길이
     * @param arr section : 칠해야하는 벽의 길이
     * @return int result : 최소개수
     */

    // 중간값에서 반례가나옴
    // public int solution2(int n, int m, int[] section) {
    //     double answer = 0;

    //     double startPoint = section[0];
    //     double endPoint = section[section.length];
    //     double totalPaintLength = endPoint-startPoint+1;

    //     answer = Math.ceil(totalPaintLength / m);
    //     System.out.println(totalPaintLength);
    //     System.out.println(m);
    //     return (int) answer;
    // }

    public int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean[] wallArr = new boolean[n];
        Arrays.fill(wallArr,true);        
        
        //칠해야하는부분 체크
        for(int i = 0 ; i<section.length; i++){
            wallArr[section[i]-1] = false;
        }       
        
        //arr 탐색
        for(int i = 0 ; i<n; i++){
            //칠해야하는 부분이있으면
            if(!wallArr[i]){
                //옆으로 m칸만큼 칠하기
                for(int startPoint = i; startPoint < i+m;startPoint++){
                    //예외처리
                    if(startPoint > n-1)
                        break;                        
                    wallArr[startPoint] = true;
                }
                answer++;
            }
        }
        return answer;
    }    
}