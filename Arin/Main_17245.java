import java.util.Arrays;
import java.util.Scanner;

public class Main_17245 { // 서버실
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n = 5;
        int[] computers = { 1, 4, 0, 2, 1, 0, 0, 5, 6, 3, 8, 4, 7, 2, 0, 7, 1, 0, 5, 3, 4, 5, 7, 9, 1 };
        // int n = sc.nextInt();
        // int[] computers = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            // computers[i] = sc.nextInt();
            sum += computers[i];
        }
        Arrays.sort(computers);
        int[] floor = new int[computers[n*n-1]]; // 층마다 누적
        System.out.println("max: "+computers[n*n-1]);
        for (int j = 0; j < computers.length; j++) {
            if (computers[j] > 0) {
                floor[0]++;
                computers[j]--;
            }
        }
        for (int i = 1; i < floor.length; i++) {
            floor[i] = floor[i - 1];
            for (int j = 0; j < computers.length; j++) {
                if (computers[j] > 0) {
                    floor[i]++;
                    computers[j]--;
                }
            }
        }
        int low = 0;
        int high = floor.length-1;
        double target = (double) sum / 2;
        System.out.println("target: " + target);
        for (int i = 0; i < floor.length; i++) {
            System.out.print(i + 1 + "층(" + i + ")까지 누적: " + floor[i] + " / ");
        }
        System.out.println();
        int mid;
        int answer = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target < floor[mid]) {
                if (target > floor[mid - 1] || mid == 0) {
                    answer = mid+1;
                    break;
                }
                high = mid - 1;
            } else if (target == floor[mid]) {
                answer = mid+1;
                break;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(answer);
    }
}