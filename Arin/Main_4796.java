import java.util.Scanner;

public class Main_4796 { // 캠핑 - 탐욕법 풀이

    public static void main(String[] args) {
        // 사용가능 일수 L, 연속일수 P, 휴가일수 V 입력받기
        Scanner sc = new Scanner(System.in);
        int turn = 1; // 순서
        while (true) {
            int answer = 0;
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();
            if (L == 0)
                break; // 0이 입력되면 더이상 입력받지 않음

            // int c = 0;
            for (int i = 0; i < V;) { // 휴가일수 만큼 반복
                answer += L; // 5 > 10 > 15
                i += L; // 5 > 13 > 21
                if (i >= V) {
                    answer -= i - V;
                }
                i += P - L; // 8 > 16 > 24

                // System.out.println("["+i+"]");
                // answer++;
                // c++;
                // if (c >= L) {
                // i += P - L;
                // c = 0;
                // }
                // System.out.println(i+" - answer >>>> "+answer);
                // System.out.println(i+" - c >>>> "+c);
                // i++;

            }

            System.out.println("Case " + turn + ": " + answer);
            turn++;
        }
    }
}