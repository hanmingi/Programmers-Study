class Solution_notDestructedBuilding {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int[][] count = new int[board.length + 1][board[0].length + 1];

        // 주어진 (x1, y1), (x2+1, y2+1)를 바탕으로 두 점을 대각선으로 한 사각형의 
        // 각 점에 누적합을 할 숫자를 넣어준다.
        for (int i = 0; i < skill.length; i++) {
            int minusOrPlus = skill[i][0] == 1 ? -skill[i][5] : skill[i][5]; // 공격이면 -, 회복이면 +
            int x1 = skill[i][1];
            int y1 = skill[i][2];
            int x2 = skill[i][3];
            int y2 = skill[i][4];
            count[x1][y1] += minusOrPlus;         // 위, 왼쪽
            count[x1][y2 + 1] -= minusOrPlus;     // 위, 오른쪽
            count[x2 + 1][y2 + 1] += minusOrPlus; // 아래, 오른쪽
            count[x2 + 1][y1] -= minusOrPlus;     // 아래, 왼쪽
        }

        // 왼쪽 > 오른쪽
        for (int i = 0; i < board.length + 1; i++) {
            for (int j = 0; j < board[0].length; j++) {
                count[i][j + 1] += count[i][j];
            }
        }

        // 위쪽 > 아래쪽
        for (int i = 0; i < board[0].length + 1; i++) {
            for (int j = 0; j < board.length; j++) {
                count[j + 1][i] += count[j][i];
            }
        }

        // 주어진 빌딩의 내구도에 누적합(공격과 회복 합친 결과)을 더해 0 초과인 건물 수 센다.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + count[i][j] > 0)
                    answer++;
            }
        }

        return answer;
    }
}

public class 파괴되지않은건물 {
    public static void main(String[] args) {
        Solution_notDestructedBuilding sol = new Solution_notDestructedBuilding();
        int[][] board = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
        int[][] skill = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };
        System.out.println(sol.solution(board, skill));
    }
}