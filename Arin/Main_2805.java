import java.util.Scanner;

public class Main_2805 { // 나무 자르기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int trees = sc.nextInt(); // 나무수
        int target = sc.nextInt(); // 잘라서 가져갈 나무의 길이
        int[] treeTall = new int[trees]; // 나무들 각각의 높이

        int min = 0; // 절단기 높이 최소값
        int max = 0; // 절단기 높이 최대값

        for (int i = 0; i < trees; i++) {
            treeTall[i] = sc.nextInt();
            if (max < treeTall[i]) { // 나무들 중 가장 높은 높이를 max(절단기 최대값)에 담기
                max = treeTall[i];
            }
        }

        while (min < max) {
            System.out.println("min : " + min + " / max : " + max);
            int mid = (min + max) / 2;
            long sum = 0;
            for (int tt : treeTall) { // mid 값보다 높은 나무일 경우 나무길이-mid 를 sum에 담음
                if (tt - mid > 0) {
                    sum += (tt - mid);
                }
            }

            if (sum < target) { // sum이 목표보다 작으면 절단기 높이를 낮춤 = max를 줄임
                max = mid;
            } else { // sum이 목표보다 크면 절단기 높이를 높임 = min을 높임
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
