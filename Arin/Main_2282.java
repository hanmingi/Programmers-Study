import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] scores = new int [8][2];
        int[] topfive = new int [5];
        int sum = 0;

        for (int i = 0; i < 8; i++) {
            scores[i][0] = sc.nextInt();
            scores[i][1] = i + 1;            
        }

		    //이중배열 정렬
        Arrays.sort(scores, (int[] a, int[] b) -> {
            return b[0] - a[0];
        });

        for (int i = 0; i < 5; i++) {
            sum += scores[i][0];
            topfive[i] = scores[i][1];                       
        }

        Arrays.sort(topfive);

        System.out.println(sum);
        for (int i = 0; i < 5; i++) {
            System.out.print(topfive[i] + " ");
        }        
        sc.close();
    }
}
