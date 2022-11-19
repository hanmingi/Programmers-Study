//package develope;

import java.util.Scanner;

public class Main_1012 {

    static int[][] cabbage;
    static boolean[][] visit;
    static int M;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count;

        int tc = sc.nextInt();

        // tc = 테스트 케이스
        for(int i = 0; i < tc; i++){
            count = 0;

            M = sc.nextInt();
            N = sc.nextInt();
            int K = sc.nextInt();

            // 배추있는 텃밭
            cabbage = new int[M][N];

            // 탐색할 때 해당 좌표를 방문 했는지 안했는지 판단할 boolean형 배열
            visit = new boolean[M][N];

            for(int j = 0; j < K; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();

                // 입력받은 해당 좌표에는 배추가 있다를 의미(1)
                // (0)은 배추가 없는 곳을 의미
                cabbage[x][y] = 1;
            }

            for(int x = 0; x < M; x++){
                for(int y = 0; y < N; y++){
                    
                    // 문제에서 탐색해야 하는 조건은 해당 좌표에 배추가 있는가?
                    // 또한 해당 좌표를 한번도 방문하지 않았는가?
                    if(cabbage[x][y] == 1 && !visit[x][y]){
                        dfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y){
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        // 탐색하러 들어왔기 때문에 방문했다를 표시
        visit[x][y] = true;

        for(int i = 0; i < 4; i++){
            // 입력받은 x, y 좌표의 상하좌우를 확인
            int cx = x + dx[i];
            int cy = y + dy[i];

            // 첫번째 유효성 검사 : 상하좌우의 좌표가 텃밭 내부에 있는가?
            if(cx >= 0 && cy >= 0 && cx < M && cy < N){
                // 두번째 유효성 검사 : 해당 좌표를 한번도 방문하지 않았고, 배추가 있는가?
                if(!visit[cx][cy] && cabbage[cx][cy] == 1){
                    dfs(cx, cy);
                }
            }
        }
    }
}
