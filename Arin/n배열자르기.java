class Solution_ArrayCut {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        int a = 0;
        for (long i = left; i <= right; i++) { // 1 ≤ n ≤ 10의7승, 0 ≤ left ≤ right < n의제곱
                                               // 이므로 i를 int로 선언하면 int 범위를 넘어간다
                                               // (런타임에러 남).
            long x = i / n + 1; // i번째 칸의 좌표 x, y를 구하고 1을 더한다
            long y = i % n + 1;
            long num = x > y ? x : y; // (x,y 중 큰 수 + 1)이 해당 좌표의 숫자임
            answer[a++] = (int) num;
        }
        return answer;
    }
}

public class n배열자르기 {
    public static void main(String[] args) {
        Solution_ArrayCut sol = new Solution_ArrayCut();
        int n = 4;
        int left = 7;
        int right = 14;
        int[] answer = sol.solution(n, left, right);
        for (int i = 0; i < right - left + 1; i++) {
            System.out.println(answer[i]);
        }
    }
}