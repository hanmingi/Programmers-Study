import java.io.*;
import java.util.*;

public class Main_1388 { // 바닥 장식
    static int N, M; // 가로, 세로 크기
    static char[][] arr; // 바닥 장식 무늬 (- 또는 |)
    static boolean[][] visited; // 방문여부

    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // N = sc.nextInt();
        // M = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            // String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                // System.out.println("arr["+i+"]["+j+"]: "+arr[i][j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    // System.out.println(i+","+j+": "+visited[i][j]);
                    continue;
                }
                // System.out.println(i+","+j+": "+visited[i][j]);
                char charToCheck = arr[i][j];
                dfs(i, j, charToCheck);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int i, int j, char charToCheck) {
        visited[i][j] = true;

        if (charToCheck == '-') { // 체크할 장식이 - 이면
            j++;                  // 같은 행에서 옆의 장식을 확인해야 함
            if (j < M && arr[i][j] == '-') // 옆의 장식도 똑같이 - 이면
                dfs(i, j, arr[i][j]);      // dfs 탐색
        } else { // 체크할 장식이 | 이면
            i++; // 같은 열에서 아래의 장식을 확인해야 함
            if (i < N && arr[i][j] == '|') // 아래의 장식도 똑같이 | 이면
                dfs(i, j, arr[i][j]);      // dfs 탐색
        }
    }
}