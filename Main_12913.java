import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i = 0; i < land.length; i++) {  //모든첫번째 열의 값을 시작으로 최대값 다 구하기
            
            if(i == 0){ //첫번째 보다 전의 값은 없기 때문에 continue로 넘어감
                continue;
            }
            
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        
        for(int i=0; i<4; i++){
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }
}

// 바로 밑에 열에 큰수가 나올 수도 있기 때문에 틀림
class Solutionxx {
    int solution(int[][] land) {
        int answer = 0;
        int Max1 = 0;  //각 행마다의 최대값
        int p = 0;    //각 행의 최대값의 index값
        for(int i = 0; i < land.length; i++) {
                
            for ( int j = 0; j < 4 ; j++) {    
                Max1 = land[i][j];
                p = j;                
                if(p != 0 && p == j){
                    continue;
                }
                
                if(Max1 < land [i][j]){
                    Max1 = land[i][j];
                    p = j;
                }
                
            }
            answer += Max1; 
            Max1=0;  //다음 행의 최대값구하기 위한 max clear
        }
        
        return answer;
    }
}
  
