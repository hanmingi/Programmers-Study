package programmers;

import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};

        Solution_택배상자 s = new Solution_택배상자();

        // 2
        System.out.println(s.solution(order));
    }
}

class Solution_택배상자 {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> sub = new Stack<>();

        int box = 1;

        for(int o : order){
            while(box <= order.length){
                if(box == o){
                    break;
                } else if (!sub.isEmpty() && sub.peek() == o) {
                    break;
                }
                else {
                    sub.push(box);
                    box++;
                }
            }

            if(box == o){
                box++;
                answer++;
            } else if (!sub.isEmpty() && sub.peek() == o) {
                sub.pop();
                answer++;
            } else{
                break;
            }
        }
        return answer;
    }
}