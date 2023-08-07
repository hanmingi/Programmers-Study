import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int newEnd = 0;
        int answer = 0;
        for (int[] ta : targets) {
            int start = ta[0];
            int end = ta[1];
            if (newEnd <= start) {
                answer++;
                newEnd = end;
            }
        }
        return answer;
    }
}