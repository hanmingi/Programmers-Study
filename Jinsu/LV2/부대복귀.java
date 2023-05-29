package LV3;
import java.util.*;

public class ReturnArmy {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        //n : 노드 
        //roads : 간선
        // sources : 출발지
        // destination : 도착지        

        int[] answer = new int[sources.length];
        int[] dist = new int[n+1];
        // boolean[] isVisited = new boolean[n];


        //인접리스트
        List<Integer>[] graph = new LinkedList[n+1];
        
        //1번노드부터 초기화
        for(int i = 1; i<=n ; i++){
            graph[i] = new LinkedList<>();
        }

        //최단거리 배열 MAX값으로 초기화
        for(int i = 1 ; i<=n ;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        //출발지 = 0
        dist[destination] = 0;

        //간선 입력
        for(int i = 0 ; i< roads.length; i++ ){
            int st = roads[i][0];
            int ed = roads[i][1];
            
            //각 노드 서로 연결
            graph[st].add(ed);
            graph[ed].add(st);
        }

        //우선순위 큐 활용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(destination);

        while(!pq.isEmpty()) {
            int cur = pq.poll();

            for(int next : graph[cur]) {
                // 최단거리 테이블 값보다 현재 순회중인 최단거리가 더 짧으면 최솟값 갱신
                if(dist[cur]+1 < dist[next]) {
                    dist[next] = dist[cur]+1;
                    pq.add(next);
                }
            }
        }
        
        for(int i=0; i<sources.length; i++) {
            int node = sources[i];
            if(dist[node] == Integer.MAX_VALUE) answer[i] = -1;
            else answer[i] = dist[node];
        }
        return answer;
    }
    
}
