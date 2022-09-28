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
        while (queuee.peek() != null) {
            for (int i = 0; i < K - 1; i++) {
                int num = queuee.poll();
                queuee.offer(num);
            }
            answer += queuee.poll();
            answer += ", ";
        }
        System.out.println(answer.substring(0, answer.length() - 2) + ">");
    }
}