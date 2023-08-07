// import java.util.*;  시간초과

// class Solution {
//      public int solution(int n, int k, int[] enemy) {
//         int answer = 0;
//         List<Integer> arr = new ArrayList<>();
//         for (int e : enemy) {
//             arr.add(e);
//             Collections.sort(arr);
//             answer++;
//             n = n-e;
//             if (n < 0) {
//                 if (k == 0) {
//                     return answer - 1;
//                 }
//                 n = n + arr.get(0);
//                 arr.remove(0);
//                 k--;
//             }
//         }
//         return enemy.length;
//     }
// }

import java.util.*;

class Solution {
     public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int e : enemy) {
            queue.add(e);
            answer++;
            n = n-e;
            if (n < 0) {
                if (k == 0) {
                    answer--;
                    break;
                }
                n = n + queue.poll();
                k--;
            }
        }
        return answer;
    }
}
