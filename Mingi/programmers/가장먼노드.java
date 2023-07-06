package programmers;

import java.util.*;

public class 가장먼노드 {
    public static void main(String[] args) {
        Solution_가장먼노드 s = new Solution_가장먼노드();

        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(s.solution(n, edge));
    }
}


class Solution_가장먼노드 {
    static boolean[] visited;
    static int[] distance;

    List<List<Integer>> lst = new ArrayList<>();

    public int solution(int n, int[][] edge) {
        visited = new boolean[n];
        distance = new int[n];

        // 최대값으로 일단 채우기
        // 거리를 구하면서 min을 갱신
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i < n; i++){
            lst.add(new ArrayList<>());
        }

        // 양방향
        // -1 해주는 이유는 실제 index 는 0부터 시작
        for(int[] eg : edge){
            lst.get(eg[0] - 1).add(eg[1] - 1);
            lst.get(eg[1] - 1).add(eg[0] - 1);
        }

        //System.out.println("lst = " + lst);
        // lst = [[2, 1], [2, 0, 3, 4], [5, 3, 1, 0], [2, 1], [1], [2]]

        bfs(0);

        //System.out.println("distance = " + Arrays.toString(distance));

        Arrays.sort(distance);

        int answer = 0;
        for(int i = distance.length - 1; i> 0; i--){
            answer++;
            if(distance[i] != distance[i - 1]) break;
        }
        return answer;
    }

    public void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        // 시작지점의 거리는 0
        visited[n] = true;
        distance[n] = 0;

        while(!queue.isEmpty()) {
            Integer i = queue.poll();
            for(Integer e : lst.get(i)){
                if(!visited[e]){
                    queue.add(e);
                    visited[e] = true;
                    distance[e] = Math.min(distance[e], distance[i] + 1);
                }
            }
        }

        return;
    }
}