import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graphLi = new ArrayList<>();        
        for (int i = 0; i < n + 1; i++) {
            graphLi.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            graphLi.get(edge[i][0]).add(edge[i][1]);
            graphLi.get(edge[i][1]).add(edge[i][0]);
        }        
        
        int[] dis = new int[n + 1]; // 1을 시작점으로, 각 노드까지의 거리를 담는다
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);
        while (qu.size() != 0) {
            int nowNode = qu.poll(); // 다음 탐색 대상 노드 번호를 가져온다
            ArrayList<Integer> nowNoConn = graphLi.get(nowNode); // 탐색 대상 노드에 연결된 노드 번호 리스트를 가져온다
            for(int i = 0; i < nowNoConn.size(); i++) { // 연결된 노드들을 탐색한다.
                if (visited[nowNoConn.get(i)] == false) {
                    qu.add(nowNoConn.get(i)); // 다음 탐색 대상이 되도록 큐에 담는다
                    visited[nowNoConn.get(i)] = true;
                    dis[nowNoConn.get(i)] = dis[nowNode] + 1; // 탐색중인 노드까지의 거리를 넣는다 (+1)
                }      
            }  
        }
        Arrays.sort(dis);
        int answer = 0;
        int max = dis[dis.length-1];
        for(int i = dis.length-1; dis[i] == max; i--)
            answer++;
        return answer;
    }
}