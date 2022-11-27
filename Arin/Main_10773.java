import java.util.Scanner;
import java.util.Stack;

public class Main_10773 { // 제로
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        Stack<Integer> stackk = new Stack<Integer>(); // Stack 클래스 - FILO(First In Last Out) 자료구조
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            if (num == 0)
                stackk.pop(); // stack.pop() : 가장 마지막에 추가된 Element를 꺼내는 method
            else
                stackk.push(num); // stack.push() : Element를 추가하는 method
        }
        int answer = 0;
        while (!stackk.empty()) { // stack.empty() : Stack이 비어있는지 유무를 return 해주는 method
            answer += stackk.pop();
        }
        System.out.println(answer);
    }
}