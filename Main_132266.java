import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        

        boolean[] visit = new boolean[n+1]; //방문여부
        int[] dist = new int[n+1];
        int[] answer;

        List<Integer>[] graph = new LinkedList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new LinkedList<>();
        }

        // 간선 add해서 각노드이어쥬기
        for(int[] r : roads) {
            int a = r[0];
            int b = r[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        // 거리 일단 최대치 처음부터 끝까지 연결되어있다고 범위10만까지라서
        for(int i=1; i<=n; i++) {
            dist[i] = 100000;
        }
        // 출발지점 거리 0
        dist[destination] = 0;        

        Queue<Integer> p = new LinkedList<>();
        p.add(destination);
        visit[destination]= true;
        while(!p.isEmpty()) {
            int cur = p.poll();
            
            // if(!visit[cur]){
            //     visit[cur]=true;
            // }
            
            
            for(int next : graph[cur]) {
                // 최단거리보다 방문하는곳이 더작으면 작은값으로 셋팅
                if(dist[cur]+1 < dist[next]) {
                    dist[next] = dist[cur]+1;
                }
                if(!visit[next]){ //방문으로 바꾸어주고 큐에 쌓기
                    p.add(next);
                    visit[next]= true;
                }
            }
        }
        answer = new int[sources.length];
        for(int i=0; i<sources.length; i++) {
            int node = sources[i];
            if(dist[node] < 100000) {
                answer[i] = dist[node];
            }
            else answer[i] = -1;
        }

        return answer;
    }
}
