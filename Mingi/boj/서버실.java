//package develope;

import java.util.Scanner;

public class 서버실 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] com = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                com[i][j] = sc.nextInt();
            }
        }
                
        int max = 0;
        int min = 0;
        long sum = 0;

        // 총합과 최값을 구하기 위한 함수
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sum += com[i][j];
                if(max<com[i][j]) max = com[i][j];
            }
        }

        while(min + 1 < max){
            //각 칸이 전부 컴퓨터의 최대값이 들어간다면 int 형을 돌파하게 된다.
            long cnt = 0;

            int mid = (min + max) / 2;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(com[i][j] > mid) cnt += mid;
                    else cnt += com[i][j];
                }
            }

            if(((double) cnt / sum) >= 0.5) max = mid;
            else min = mid;
        }
        System.out.println(max);
    }
}