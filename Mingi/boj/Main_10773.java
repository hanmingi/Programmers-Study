import java.util.Scanner;
import java.util.Stack;

public class Main_10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tc; i++){
            int n = sc.nextInt();

            if(n != 0) stack.push(n);

            else if(n == 0) stack.pop();
            // printstack(stack);
        }

        int answer = 0;
        while(!stack.empty()){
            answer +=  stack.pop();
        }

        System.out.println(answer);
    }

    // static void printstack(Stack<Integer> s){
    //     for(int i =0 ; i < s.size(); i++){
    //         System.out.println(s.elementAt(i));
    //     }
    // }
}
