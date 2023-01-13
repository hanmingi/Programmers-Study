package programmers;

public class 파괴되지않은건물 {
    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5}, {5,5,5,5,5}, {5,5,5,5,5}, {5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4}, {1,2,0,2,3,2}, {2,1,0,3,1,2}, {1,0,1,3,3,1}};

        Solution_건물 s = new Solution_건물();
        System.out.println(s.solution(board, skill));
    }
}


class Solution_건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int n = board.length;
        int m = board[0].length;
        int[][] s = new int[n+1][m+1];

        for(int i = 0; i < skill.length; i++){
            int t = skill[i][0];
            int r1 = skill[i][1], c1 = skill[i][2];
            int r2 = skill[i][3], c2 = skill[i][4];
            int degree = skill[i][5];

            if(t == 1){
                s[r1][c1] += -degree;
                s[r2+1][c1] += degree;
                s[r1][c2+1] += degree;
                s[r2+1][c2+1] += -degree;
            }else{
                s[r1][c1] += degree;
                s[r2+1][c1] += -degree;
                s[r1][c2+1] += -degree;
                s[r2+1][c2+1] += degree;
            }
        }

        for(int i = 0; i < n+1; i++){
            int sum = 0;
            for(int j = 0; j < m+1; j++){
                sum += s[i][j];
                s[i][j] = sum;
            }
        }

        for(int i = 0; i<m; i++){
            int sum = 0;
            for(int j = 0; j<n; j++){
                sum += s[j][i];
                s[j][i] = sum;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(s[i][j] + board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}