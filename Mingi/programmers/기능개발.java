//package develope;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public static void main(String[] args) {
        Solution_2 s = new Solution_2();

        int[] p1 = {93, 30, 55};
        int[] s1 = {1, 30, 5};
        int[] answer = s.solution(p1, s1);
        //System.out.println(s.solution(p1, s1));
        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}

class Solution_2 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> work = new LinkedList<>();
        ArrayList<Integer> work_temp = new ArrayList<>();
        int count = 1;
        for(int i = 0; i < progresses.length; i++){
            // 아래를 3항 연산자로 변경할 수 있나?
            // if((100 - progresses[i]) % speeds[i] == 0){
            //     work.offer((100 - progresses[i]) / speeds[i] + 1);
            // }
            // else{
            //     work.offer((100 - progresses[i]) / speeds[i]);
            // }
            work.offer((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] == 0 ? 0 : 1));
        }

        int temp = work.poll();

        while (!work.isEmpty()) {
            int next = work.poll();
            if (temp >= next)
                count++;
            else {
                work_temp.add(count);
                count = 1;
                temp = next;
            }
        }

        work_temp.add(count);

        int[] answer = new int[work_temp.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = work_temp.get(i);
        }

        return answer;
    }
}