package LV3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FurthestNode {
     public int solution(int n, int[][] edge) {
        int answer = 0;

        //그래프 생성
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        //방문 여부 확인
        boolean[] visit = new boolean[n + 1];
        visit[1] = true;

        //거리 비교
        int[] distance = new int[n + 1];

        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(1);

        while (bfs.size() != 0) {
            int nowNode = bfs.poll();
            ArrayList<Integer> node = graph.get(nowNode);
            for(int i = 0; i< node.size(); i++){
                if(visit[node.get(i)] == false){
                    bfs.add(node.get(i));
                    visit[node.get(i)] = true;
                    distance[node.get(i)] = distance[nowNode] + 1;
                }
            }
        }
        Arrays.sort(distance);
        int max = distance[n];
        for(int i : distance){
            if(i == max){
                answer++;
            }
        }

        return answer;
    }

    
}
