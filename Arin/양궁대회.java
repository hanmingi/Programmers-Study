class Solution {
    static int max = Integer.MIN_VALUE;
    static int[] lion = new int[11];
    static int[] answer = { -1 };

    public int[] solution(int n, int[] apeach) {
        dfs(0, n, apeach, lion);
        return answer;
    }

    private static void dfs(int cnt, int n, int[] apeach, int[] lion) {
        if (cnt == n) {
            int sl = 0, sa = 0;
            for (int i = 0; i < 11; i++) {
                if (apeach[i] == 0 && lion[i] == 0) continue;
                if (apeach[i] < lion[i]) sl += (10 - i);
                else sa += (10 - i);
            }
            if (sl > sa) { 
                if (sl - sa >= max) {
                    answer = lion.clone();
                    max = sl - sa;
                }
            }
            return;
        }

        for (int i = 0; i < 11 && lion[i] <= apeach[i]; i++) {
            lion[i]++;
            dfs(cnt + 1, n, apeach, lion);
            lion[i]--;
        }
    }
}
