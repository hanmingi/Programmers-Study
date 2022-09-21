import java.util.Scanner;
import java.util.Stack;

public class Main_10773 { // 제로
    public static int main(String[] args) {  
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        Stack<Integer> stackk = new Stack<Integer>();      
        //int[] num = new int[K]; // K개의 정수를 담을 배열
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            if(num == 0) stackk.pop();
            else stackk.push(num);
        }
        int answer = 0;
        while(!stackk.empty()){
            answer += stackk.pop();
        }
        return answer;
    }
}