//package develope;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        Solution_3 s = new Solution_3();

        int n = 6;
        int[] times = { 7, 10 };

        // return 28
        System.out.println(s.solution(n, times));
    }
}

class Solution_3 {
    public long solution(int n, int[] times) {

        Arrays.sort(times);
        long min = 1;
        long max = times[times.length - 1] * n;
        long answer = 0;
        while (min <= max) {
            long mid = (min + max) / 2;

            int cnt = 0;
            for (int i = 0; i < times.length; i++) {
                cnt += (mid / times[i]);
            }
            // System.out.println("========== before check ===========");
            // System.out.println("max : " + max);
            // System.out.println("min : " + min);
            // System.out.println("mid : " + mid);
            // System.out.println("cnt : " + cnt);
            // System.out.println();

            // if (cnt > n)
            //     max = mid;
            // else if (cnt < n)
            //     min = mid;
            // else {
            //     break;
            // }
            
            if(cnt >= n){
                max = mid - 1;
                answer = mid;
            }
            else if(cnt == n) answer = mid;
            else {
                min = mid + 1;
            }


            // System.out.println();
            // System.out.println("========== after check ===========");
            // System.out.println("max : " + max);
            // System.out.println("min : " + min);
            // System.out.println("mid : " + mid);
            // System.out.println("cnt : " + cnt);
            // System.out.println();
        }
        return answer;
    }
}