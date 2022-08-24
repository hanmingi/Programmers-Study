import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        // for(int[] route : routes){
        //     System.out.println(route[0] + " " + route[1]);
        // }


        int min = Integer.MIN_VALUE;
        for(int[] route : routes){
            if(min < route[0]){
                min = route[1];
                answer++;
            }
        }
        return answer;
    }
}

public class 단속카메라 {
    public static void main(String[] args){
        Solution s = new Solution();

        int[][] t1 = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};

        System.out.println(s.solution(t1));

    }
}
