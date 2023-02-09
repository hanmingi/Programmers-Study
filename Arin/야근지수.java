import java.util.*;

class Solution_overWorkIndex {
    public long solution(int n, int[] works) {

        // 숫자는 낮은 것이 우선순위 높기 때문에 역순으로 만들기 위해 reverse
        PriorityQueue<Integer> works_pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int w : works) // 우선순위큐에 작업량 넣음
        works_pq.offer(w);

        // 퇴근까지 남은 n시간 동안 작업량 하나씩 n시간치 처리
        for (int i = 0; i < n; i++) {
            int wp = works_pq.poll(); // poll: 큐 맨 앞에 있는 값(가장 큰 작업량) 반환 후 삭제
            if (wp > 0)
            works_pq.offer(wp - 1); // 작업량 -1하여 다시 큐에 넣음
            else // 제일 큰 작업량이 0이 되었을 때 break
                break; 
        }

        // 작업량 우선순위큐에 남아있는 작업량을 제곱하여 answer에 담음
        long answer = 0;
        for (int wp : works_pq)
            answer += Math.pow(wp, 2);
        return answer;
    }
}

public class 야근지수 {
    public static void main(String[] args) {
        Solution_overWorkIndex sol = new Solution_overWorkIndex();
        int[] works = { 4, 3, 3 };
        int n = 4;
        System.out.println(sol.solution(n, works));
    }
}