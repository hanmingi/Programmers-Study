import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long p= (long) Math.pow(r1, 2);   //짤은부분 구하기
        long q= (long) Math.pow(r2, 2);   // 긴부분 구하기

        for (int i = 1; i <= r2; i++) {  
            int MIN = (int) Math.ceil(Math.sqrt(p- Math.pow(i, 2))); 
            int MAX = (int) Math.floor(Math.sqrt(q- Math.pow(i, 2)));
            answer = answer+ (MAX - MIN +1);   //차기때문에 1개플러스
        }
        return answer * 4;   //4분면값곱하기
    }
}
