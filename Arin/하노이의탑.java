import java.util.Arrays;

class Solution_towerOfHanoi {
    private int index = 0;

    public int[][] solution(int n) {
        int[][] answer = new int[(int) Math.pow(2, n) - 1][2];
        hanoi(n, 1, 2, 3, answer);
        return answer;
    }

    public void hanoi(int n, int first, int second, int third, int[][] answer) {
        if (n == 1){
            answer[index++] = new int[] { first, third };
        }
        else {
            hanoi(n - 1, first, third, second, answer); // 가장 큰 링을 제외하고 모두 2번으로 이동
            answer[index++] = new int[] { first, third }; // 가장 큰 링을 3번으로 이동
            hanoi(n - 1, second, first, third, answer); // n-1 하노이의 탑을 다시 반복하기 위해 재귀호출
        }
    }
}

public class 하노이의탑{
    public static void main(String[] args) {
        Solution_towerOfHanoi sol = new Solution_towerOfHanoi();
        int n = 3;
        System.out.println(Arrays.deepToString(sol.solution(n)));
    }
}

////////////////////////////////////////////////////////

// class Solution_towerOfHanoi {
//     public int[][] solution(int n) {

//         int[][] answer = new int[(n - 1) * 2 + 1][2];
//         for (int i = 0; i < n - 1; i++) {
//             answer[i][0] = 1;
//             answer[i][1] = 2;
//         }
//         answer[n - 1][0] = 1;
//         answer[n - 1][1] = 3;

//         for (int i = 0; i < n - 1; i++) {
//             answer[i + n][0] = 2;
//             answer[i + n][1] = 3;
//         }
//         return answer;
//     }
// }

// public class 하노이의탑 {
//     public static void main(String[] args) {
//         Solution_towerOfHanoi sol = new Solution_towerOfHanoi();
//         int n = 3;
//         for (int i = 0; i < (n - 1) * 2 + 1; i++) {
//             for (int j = 0; j < 2; j++) {
//                 int[][] a = sol.solution(n);
//                 System.out.print(a[i][j]);
//             }
//             System.out.println();
//         }
//     }
// }