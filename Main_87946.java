class Solution {
    int answer;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        boolean[] visited = new boolean[dungeons.length];
        findAnswer(k, dungeons, visited, 0);
        //System.out.println(dungeons.length);
        return answer;
    }

    private void findAnswer(int k, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i<dungeons.length; i++) {
            if (visited[i] == false && dungeons[i][0] <=k) {
                visited[i] = true;
                findAnswer(k - dungeons[i][1], dungeons, visited, count + 1);
                //System.out.print(i);
                visited[i] = false;
            }
            
        }
        if (count>answer) {
            answer = count;
        }
    }
}
