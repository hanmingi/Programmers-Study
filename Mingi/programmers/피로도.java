package programmers;

public class 피로도 {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};

        // -3
        System.out.println(new Solution_피로도().solution(k,dungeons));
    }
}

class Solution_피로도 {
    // 방문 체크 배열
    static boolean[] visited;
    static int answer;

    public int solution(int k, int[][] dungeons) {

        // 방문 배열의 크기는 던전의 갯수와 동일
        visited = new boolean[dungeons.length];

        answer = 0;

        dfs(0, k, dungeons);

        return answer;
    }

    public void dfs(int count, int k, int[][] d){
        System.out.println("##########################");
        System.out.println("##### count : " + count + " ##########");
        System.out.println("###### k : " + k + " ############");
        System.out.println("##########################");
        for(int i = 0; i < d.length; i++){

            // d[i][0] 이 의미하는 것은 던전에 들어가기 위한 최소 피로도
            // 따라서 던전에 들어갔는지의 여부와 던전의 최소 피로도가 내가 보유하고 있는 피로도 보다 작은지를 체크
            if(!visited[i] && d[i][0] <= k){

                // 들어갈 수 있으니 배열을 참으로 변경
                visited[i] = true;

                // 두번째 깊이 탐색을 위해 depth 증가
                // 해당 문제에서 depth 는 던전 탐색 갯수가 된다.
                //count += 1;
                // d[i][0]이 던전을 들어가기 위한 최소 피로도 였으면
                // d[i][1]은 던전에서 사용한 피로도 이기 때문에 k에서 빼줘야한다.
                //k -= d[i][1];

                dfs(count + 1, k - d[i][1], d);

                // 다른 경우의 수도 있을 수 있으니 탐색했던 던전의 방문 여부를 false 로 변경
                // 이후에 반복문을 다시 진행
                visited[i] = false;
            }
        }

        answer = Math.max(answer, count);
    }
}