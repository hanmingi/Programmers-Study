import java.util.*;

class Solution {
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edge.length; i++) {
            int m = edge[i][0];
            int h = edge[i][1];
            list.get(m).add(h);
            list.get(h).add(m);
        }
        int[] visited = new int[n + 1];

        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visited[1] = 1;

        while (!que.isEmpty()) {
            answer = que.size();
            for (int i = 0; i < answer; i++) {
                int t = que.poll();
                for (int j = 0; j < list.get(t).size(); j++) { //여기 for문은 만약 가장 먼 것이 돌았으면 더이상 돌일이 없다.
                    if(visited[list.get(t).get(j)] == 0) {
                        que.add(list.get(t).get(j));
                        visited[list.get(t).get(j)] = 1;
                    }
                }
            }
        }
        return answer;
    }
}
