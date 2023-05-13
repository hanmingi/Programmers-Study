package programmers;

import java.util.*;

public class 부대복귀 {
    public static void main(String[] args) {
        Solution_부대복귀 s = new Solution_부대복귀();

        int n = 5;
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = {1, 3, 5};
        int destination = 5;

        System.out.println(Arrays.toString(s.solution(n, roads, sources, destination))); // [2, -1, 0]
    }
}


class Solution_부대복귀 {
    static List<List<Integer>> graph;
    static int N;
    static int D;
    static int[] answer;

    public class Node{
        int n, c;
        public Node(int n, int c){
            this.n = n;
            this.c = c;
        }
    }


    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        //int[] answer = {};
        N = n;
        D = destination;

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        System.out.println("graph = " + graph);
        // [[], [2, 4], [1, 4, 5], [], [1, 2, 5], [2, 4]]

        answer = new int[N + 1];
        Arrays.fill(answer, -1);

        dijkstra();
        System.out.println(Arrays.toString(answer));

        int[] result = new int[sources.length];
        for(int i = 0; i < sources.length; i++){
            result[i] = answer[sources[i]];
        }
        return result;
    }

    public void dijkstra(){
        Queue<Node> q = new ArrayDeque<>();
        answer[D] = 0;
        q.add(new Node(D, 0));
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < graph.get(cur.n).size(); i++) {
                int nextN = graph.get(cur.n).get(i);
                if (answer[nextN] != -1) continue;
                answer[nextN] = cur.c + 1;
                q.add(new Node(nextN, cur.c + 1));
            }
        }
    }
}