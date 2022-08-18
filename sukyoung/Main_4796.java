import java.util.Scanner;

public class Main_4796 { 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int turn = 1; // 순서
        while (true) {
            int answer = 0;
            Long L = sc.nextLong();
            Long P = sc.nextLong();
            Long V = sc.nextLong();
            if (L == 0 && P==0 && V==0)
                break; // 0이 입력되면 더이상 입력받지 않음

            for (long i = 0; i < V;) { // 휴가일수 만큼 반복
                answer += L; //5 > 10 > 15
                i += L; //5 > 13 > 21
                if(i>=V){
                    answer -= i-V;
                }
                i += P-L; //8 > 16 > 24
            }

            System.out.println("Case " + turn + ": " + answer);
            turn++;
        }
    }
}