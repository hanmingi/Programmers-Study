import java.util.Arrays;

class Solution_PE {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer += n-lost.length;
        for (int i = 0; i < lost.length; i++) {
            for(int re: reserve){
                if(re == lost[i]+1 || re == lost[i]-1) answer++;
            }
        }
        return answer;
    }

}

public class 체육복 { // 체육복
    public static void main(String[] args) {

        Solution_PE s = new Solution_PE();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(s.solution(n,lost,reserve));
    }
}