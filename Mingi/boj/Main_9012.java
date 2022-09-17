import java.util.Scanner;
import java.util.Stack;

public class Main_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int tc = sc.nextInt();
        
        for(int i = 0; i < tc; i++){
            String s = sc.next();
            String flag = "YES";

            Stack<Character> stack = new Stack<>();

            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);

                if(c == '('){
                    stack.push(c);
                } 

                else if(stack.empty()) {
                    flag = "NO";
                    break;
                }

                else stack.pop();
            }

            if(!stack.empty()) flag = "NO";

            System.out.println(flag);
        }
        
    }
}