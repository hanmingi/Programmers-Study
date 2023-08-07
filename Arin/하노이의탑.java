import java.util.Arrays;

class Solution_towerOfHanoi {
    private int index = 0;

    public int[][] solution(int n) {
        int[][] answer = new int[(int) Math.pow(2, n) - 1][2];
        hanoi(n, 1, 2, 3, answer);
        return answer;
    }

    public void hanoi(int n, int first, int second, int third, int[][] answer) {
        System.out.println("hanoi~ n: "+n);
        if (n == 1){
            System.out.println("n=1 index: "+index+" / first: "+first+" / third: "+third);
            answer[index++] = new int[] { first, third }; // index++ 이므로 이전 인덱스가 들어가고
                                                          // 이후 index부터 1 증가된 값이 적용됨
        }
        else {
            hanoi(n - 1, first, third, second, answer); // 가장 큰 링을 제외하고 모두 2번으로 이동
            System.out.println("n!1 index: "+index+" / first: "+first+" / third: "+third);
            answer[index++] = new int[] { first, third }; // 가장 큰 링을 3번으로 이동
            hanoi(n - 1, second, first, third, answer); // n-1 하노이의 탑을 다시 반복하기 위해 재귀호출
        }
    }
}

public class 하노이의탑{
    public static void main(String[] args) {
        Solution_towerOfHanoi sol = new Solution_towerOfHanoi();
        int n = 4;
        System.out.println(Arrays.deepToString(sol.solution(n)));
    }
}
