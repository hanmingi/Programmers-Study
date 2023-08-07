import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        int max = 0;
        for(int i = 0; i<targets.length; i++) {
            if(targets[i][0]>=max) {  // 같다를 한이유는 개구간 S,E가 딱맞으면 요격불가능

                answer++;
                max = targets[i][1];
            }
            else if (targets[i][1]<max) {
                max = targets[i][1];
            }
        }
        return answer;
    }
}
