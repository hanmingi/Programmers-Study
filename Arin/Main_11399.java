import java.util.Scanner;
import java.util.Arrays;

public class Main_11399{
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt(); // 사람수 입력받기
	int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) { // 사람수만큼 각각의 대기시간 입력받기
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); // 인출소요시간 짧은 순으로 정렬
        
        int sub_sum = 0;
        int total_sum = 0;
        for (int i = 0; i < N; i++) {
            sub_sum += arr[i];
            total_sum += sub_sum;
        }
        System.out.println(total_sum);        
    }
}
