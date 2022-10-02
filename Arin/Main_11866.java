import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11866 { // 요세푸스 문제 0 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        Queue<Integer> queuee = new LinkedList<>();
        String answer = "<";

        for (int i = 1; i <= N; i++) {
            queuee.add(i);
        }
        while (queuee.peek() != null) { // 큐의 첫번째값이 비어있을 때까지(null 반환)
            for (int i = 0; i < K - 1; i++) { // K-1번 동안 첫값 빼서 뒤에 넣기
                int num = queuee.poll();
                queuee.offer(num);
            }
            answer += queuee.poll(); // K번째 첫값을 빼서 answer에 담기
            answer += ", ";
        }
        System.out.println(answer.substring(0, answer.length() - 2) + ">");
    }
}