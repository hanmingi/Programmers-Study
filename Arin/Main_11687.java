import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11687 { // 팩토리얼 0의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine()); // m = 가장 끝의 0의 개수

        int low = 1;
        int high = m * 5;

        boolean check = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            int mm = zeroSearch(mid);
            if (mm > m) {
                high = mid - 1;
            } else if (mm == m) {
                high = mid - 1;
                check = true;
            } else {
                low = mid + 1;
            }
        }

        if (check) {
            System.out.println(low);
        } else {
            System.out.println(-1);
        }
    }

    private static int zeroSearch(int mid) {// 끝의 0의 개수 구하기(mid! 끝의 0 개수)
                                            // 끝이 0이려면 10의 배수여야 함 = 2*5여야 함.
                                            // 2는 2의 배수마다 생성되므로 5의 개수보다 항상 많음.
                                            // 따라서 5의 개수에 따라 0의 개수가 결정됨.
        int zeroCount = 0;
        //System.out.println("------ "+"mid: "+mid+" ------");
        for (int i = 5; i <= mid; i *= 5) {
            //System.out.println("i: "+i+" | mid/i= " +(mid / i));
            zeroCount += (mid / i);
        }
        return zeroCount;
    }
}