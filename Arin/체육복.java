import java.util.Arrays;

class Solution_PE { // 체육복
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // 최소한 [n명의 학생 - 체육복 도난당한 학생]은 체육복 입음
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) { // 여벌체육복 가져온 학생이 도난당한 경우
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) { // 여벌체육복을 도난당한 학생에게 빌려주는 경우
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
                    answer++;
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                } else if (reserve[j] == lost[i] + 1) {
                    answer++;
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }

}

public class 체육복 { // 체육복
    public static void main(String[] args) {

        Solution_PE s = new Solution_PE();
        // int n = 5;
        // int[] lost = { 2, 4 };
        // int[] reserve = { 1, 3, 5 };
        int n = 5;
        int[] lost = { 4, 5, 1 };
        int[] reserve = { 4, 3, 2 };
        System.out.println(s.solution(n, lost, reserve));
    }
}