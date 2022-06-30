import java.util.*;

public class Main_1263 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] work = new int[n][2];

        for(int i = 0; i < n; i++){
            work[i][0] = sc.nextInt();
            work[i][1] = sc.nextInt();
        }

        Arrays.sort(work, (o1, o2) -> o2[1] - o1[1]);
        
        int answer = work[0][1] - work[0][0];

        for(int i = 1; i < n; i++){
            if(work[i][1] < answer){
                answer = work[i][1];
            }
            answer -= work[i][0];
        }
        if(answer > 0) System.out.println(answer);
        else System.out.println(-1);
    }
}
