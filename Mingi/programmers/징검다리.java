//package develope;

import java.util.Arrays;

public class 징검다리 {
    public static void main(String[] args) {
        Solution_1002 s = new Solution_1002();

        int d1 = 25;
        int[] r1 = { 2, 14, 11, 21, 17 };
        int n1 = 2;

        // return 4
        System.out.println(s.solution(d1, r1, n1));
    }
}

class Solution_1002 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        int start = 0;
        int end = distance;

        Arrays.sort(rocks);

        while (start <= end) {
            int mid = (start + end) / 2;
            int remove_rock = 0;
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid)
                    remove_rock++;
                else
                    prev = rocks[i];
            }

            if (distance - rocks[rocks.length - 1] < mid)
                remove_rock++;
            if (remove_rock <= n) {
                answer = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }

        return answer;
    }
}