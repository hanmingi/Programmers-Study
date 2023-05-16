import java.util.*;

class Solution_returnForce {
    private static List<List<Integer>> regionMap;
    private static int[] distance;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        regionMap = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            regionMap.add(new ArrayList<>()); // 지역 수 + 1 만큼 리스트 넣기

        // 각 지역마다 그 지역과 인접한 지역을 넣어준다.
        for (int[] road : roads) { // int[][] roads = { { 1, 2 }, { 1, 4 }, { 2, 4 }, { 2, 5 }, { 4, 5 } };
            int connectFrom = road[0];
            int connectTo = road[1];
            regionMap.get(connectFrom).add(connectTo);
            regionMap.get(connectTo).add(connectFrom);
        }

        distance = new int[n + 1]; // 인덱스는 지역, 값은 destination까지의 최단거리(시간)을 의미
        Arrays.fill(distance, Integer.MAX_VALUE); // 배열의 모든 값을 같은 값으로 초기화
        dijkstra(destination);

        // for (int i = 0; i < distance.length; i++) {
        // System.out.println(distance[i]);
        // }

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) { // 각 부대원이 위치한 서로 다른 지역들 수 만큼 반복
            answer[i] = (distance[sources[i]] < Integer.MAX_VALUE) ? distance[sources[i]] : -1; // 최대값은 최단거리가 없음을 뜻하므로 -1 넣음.
        }
        return answer;
    }

    public void dijkstra(int destination) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(destination);
        distance[destination] = 0; // destination인덱스는 당연히 출발지와 목적지가 같으므로 0이 된다.
        while (!qu.isEmpty()) {
            int quFront = qu.poll(); // 맨 처음은 destination이 된다. destination에서 경로찾기 시작한다.
            for (int i = 0; i < regionMap.get(quFront).size(); i++) { // 해당 행선지에 이어진 지역 수 만큼 반복
                int connect = regionMap.get(quFront).get(i); // 해당 행선지에 이어진 지역을 차례로 돈다.
                if (distance[connect] > distance[quFront] + 1) { // 첫 distance[quFront]은 =distance[destination]=0이므로 무조건 더 작다.
                    distance[connect] = distance[quFront] + 1;
                    qu.add(connect); // 이어진 지역을 큐에 넣는다.
                }
            }
        }
    }
}

public class 부대복귀 {
    public static void main(String[] args) {
        Solution_returnForce so = new Solution_returnForce();
        int n = 5;
        int[][] roads = { { 1, 2 }, { 1, 4 }, { 2, 4 }, { 2, 5 }, { 4, 5 } };
        int[] sources = { 1, 3, 5 };
        int destination = 5;
        System.out.println(so.solution(n, roads, sources, destination));
    }
}