import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Print> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++){
            queue.add(new Print(i, priorities[i]));
        }

        while(!queue.isEmpty()){
            int current = queue.peek().priority;

            boolean flag = false;

            for(Print print : queue){
                if(print.priority > current){
                    flag = true;
                    break;
                }
            }

            if(flag){
                Print temp = queue.poll();
                queue.add(temp);
            }

            else{
                answer++;
                Print print = queue.poll();
                if(print.index == location){
                    return answer;
                }
            }
        }
        return answer;
    }

    class Print
    {
        int index;
        int priority;

        public Print(int index, int priority){
            this.index = index;
            this.priority = priority;
        }

    }
}

public class 프린터 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] p1 = {2, 1, 3, 2};
        int l1 = 2;
        System.out.println(s.solution(p1, l1));   
    }
}