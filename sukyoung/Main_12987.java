import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);


        Stack<Integer> p = new Stack<>();
        Stack<Integer> q = new Stack<>();

        for(int i=A.length-1;i>=0; i--) {
            p.push(A[i]);
            q.push(B[i]);
        }

        while(!q.isEmpty()) {

            if(p.peek() < q.peek()) {
                answer++;
                p.pop();
                q.pop();
            }else {
                q.pop();
                System.out.println("ㅇ");
            }
        }
        return answer;
    }
}
