package programmers;

public class 콜라문제 {
    public static void main(String[] args) {
        Solution_kola s = new Solution_kola();

        int a1 = 2;
        int b1 = 1;
        int n1 = 20;

        int a2 = 3;
        int b2 = 1;
        int n2 = 20;

        System.out.println(s.solution(a1, b1, n1)); //19
        System.out.println(s.solution(a2, b2, n2)); //9
    }
}
class Solution_kola {
    public int solution(int a, int b, int n) {
        int answer = 0;

        int temp = n;
        int div = 0;

        while(temp != 0){
            int kola = ((temp + div) / a) * b;
            div = (temp+div) % a;
            temp = kola;
            answer += kola;
        }

        return answer;
    }
}
