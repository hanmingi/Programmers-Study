import java.util.*;

class Solution_mineMineral {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2]; // 총 곡괭이 수
        int[][] perFive = new int[minerals.length / 5 + 1][3]; // 5개씩 광물 묶기. 곡괭이 하나 고르면 5개씩 캐야 하기 때문.

        for (int i = 0; i < minerals.length; i++) {
            if (i != 0 && i % 5 == 0)
                totalPicks--;
            if (totalPicks == 0)
                break;
            if (minerals[i].equals("diamond")) {
                perFive[i / 5][0] += 1;
                perFive[i / 5][1] += 5;
                perFive[i / 5][2] += 25;
                continue;
            } else if (minerals[i].equals("iron")) {
                perFive[i / 5][0] += 1;
                perFive[i / 5][1] += 1;
                perFive[i / 5][2] += 5;
                continue;
            } else {
                perFive[i / 5][0] += 1;
                perFive[i / 5][1] += 1;
                perFive[i / 5][2] += 1;
            }
        }
        // for (int i = 0; i < perFive.length; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         System.out.print(" perFive[" + i + "][" + j + "]:" + perFive[i][j]+"/");
        //     }
        // }

        Arrays.sort(perFive, (o1, o2) -> {
            return o2[2] - o1[2];
        });
        // Arrays.sort(perFive, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         if (o1[2] < o2[2])
        //             return 1;
        //         else
        //             return -1;
        //     }
        // });

        int answer = 0;
        int pi = 0;
        for (int i = 0; i < perFive.length; i++) {
            while (pi < 3 && picks[pi] == 0) // 다이아, 철, 돌 순서로 해당 곡괭이 없으면 다음 곡괭이 쓴다.
                pi++;
            if (pi == 3)
                break;
            picks[pi]--;
            answer += perFive[i][pi];
        }

        return answer;
    }

}

public class 광물캐기 {
    public static void main(String[] args) {
        Solution_mineMineral so = new Solution_mineMineral();
        int[] picks = { 1, 3, 2 };
        String[] minerals = { "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone" };
        System.out.println(so.solution(picks, minerals));
    }
}