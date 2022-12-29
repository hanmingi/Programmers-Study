package programmers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스게임 {
    public static void main(String[] args) {
        Solution_game s = new Solution_game();

        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        System.out.println(s.solution(n, k, enemy));
    }
}

class Solution_game {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;

        Queue<Integer> queue  = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < enemy.length; i++){
            n -= enemy[i];
            queue.add(enemy[i]);

            if(n < 0){
                if(k > 0 && queue.size() != 0){
                    n += queue.poll();
                    k--;
                }
                else{
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}
