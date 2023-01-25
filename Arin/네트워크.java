class Solution_network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // dfs 재귀 도중 방문하지 않았던 노드만 dfs 호출
                dfs(computers, i, visited);
                answer++;
            }
        }
        return answer;
    }

    void dfs(int[][] computers, int ii, boolean[] visited) {
        visited[ii] = true;
        for (int j = 0; j < computers.length; j++) {
            // (n,n)이 아니고, 1이고(컴퓨터끼리 연결ㅇ), 방문하지 않았던 경우에만 dfs 호출
            if (ii != j && computers[ii][j] == 1 && !visited[j]) {
                dfs(computers, j, visited);
            }
        }
    }
}

public class 네트워크 {
    public static void main(String[] args) {
        Solution_network sol = new Solution_network();
        int n = 3;
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(sol.solution(n, computers));
    }
}