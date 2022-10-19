import java.util.Scanner;

public class Main_17245 { // 서버실
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = 5; // 테스트케이스
        // int[] computers = { 1,4,0,2,1, 0,0,5,6,3, 8,4,7,2,0, 7,1,0,5,3, 4,5,7,9,1 };

        int n = sc.nextInt(); // 서버실은 n x n 칸으로 되어있음
        int[] computers = new int[n * n]; // 칸마다 쌓인 컴퓨터 대수
        long sum = 0; // 컴퓨터 개수의 총합
        int high = 0; // 가장 높이 쌓여 있는 칸의 컴퓨터 개수 = 가장 높은 층

        for (int i = 0; i < n * n; i++) {
            computers[i] = sc.nextInt(); // 각 칸마다 몇 대씩 컴퓨터가 쌓여있는지 입력
            sum += computers[i];
            if (high < computers[i]) {
                high = computers[i];
            }
        }

        int low = 0;
        int mid; // 중간층 = 쌓인 컴퓨터 높이의 중간
        while (low + 1 < high) {
            mid = (low + high) / 2; // 컴퓨터가 mid층(=소요시간(분))까지 켜졌다고 가정했을 때 
            long turnedOn = 0;      // 켜진 컴퓨터 대수를 구할 것이다.
            for (int i = 0; i < n * n; i++) {
                if (computers[i] > mid) {       // computers[i]가 mid보다 크면, 해당 i칸에 쌓인
                                                // 컴퓨터 대수(=층수) 중에 mid층까지는 다 켜진 것이므로
                    turnedOn += mid;            // turnedOn에 mid를 더한다.
                } else {                        // computers[i]가 mid보다 작으면,
                    turnedOn += computers[i];   // computers[i]만큼만 켜진 것이므로 이를 더한다.
                }
            }
            //System.out.println("low: " + low + " / high: " + high + " / mid: " + mid + " / turnedOn: " + turnedOn);
            if (((double) turnedOn / sum) >= 0.5) { // 가정한 mid층까지 컴퓨터가 켜졌을 때 
                                                    // 켜진 컴퓨터 대수가 전체 컴퓨터 대수의 반 이상이면
                high = mid;                         // 더 낮은 층까지만 켜졌어도 반 이상이 나올수 있으므로 high를 낮춘다.
            } else {
                low = mid;                          // 반 이하이면 더 높은 층을 검사하기 위해 low를 높인다.
            }
        }
        System.out.println(high);
    }
}