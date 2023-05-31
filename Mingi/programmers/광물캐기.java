package programmers;

import java.util.ArrayList;

public class 광물캐기 {
    public static void main(String[] args) {
        Solution_mine s = new Solution_mine();
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        System.out.println(s.solution(picks, minerals));
    }
}

class Solution_mine {
    static int depth;
    static int min = Integer.MAX_VALUE;
    static int calc = 0;
    static boolean[] visit;

    public int solution(int[] picks, String[] minerals) {

        // Diamond : 0
        // Iron : 1
        // stone : 2
        // -> { 1, 3, 2 } -> 0, 1, 1, 1, 2, 2
        // pIdx 는 곡괭이 전체 갯수
        int pIdx = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < picks.length; i++) {
            for (int j = 0; j < picks[i]; j++) {
                if (picks[i] > 0) {
                    al.add(i);
                    pIdx++;
                }
            }
        }
        //System.out.println("al = " + al);

        depth = Math.min((int) Math.ceil((double) minerals.length / 5), pIdx);

        visit = new boolean[al.size()];
        dfs(0, al, minerals);

        return min;
    }
    
    public static void dfs(int idx, ArrayList<Integer> al, String[] minerals) {

        // 종료 조건, 계산 도중 min 이상이 되면 더 계산할 필요가 없으므로 리턴!
        if (calc >= min) return;

        // 종료 조건, 최솟값을 계산하고 리턴!
        if (idx == depth) {
            min = calc;
            return;
        }

        // 탐색!
        for (int i = 0; i < al.size(); i++) {
            if (!visit[i]) {

                // 해당 인덱스의 피로도 총 합
                int tmp = calc(al.get(i), idx, minerals);

                visit[i] = true;

                // 첫번째 피로도를 더한 후 dfs 실행하여 다음 구간의 피로도를 또 구한다.
                calc += tmp;

                dfs(idx+1, al, minerals);

                visit[i] = false;

                // 더한만큼 다시 빼줘야한다.
                calc -= tmp;

            }
        }
    }

    public static int calc(int num, int start, String[] minerals) {
        // start 를 입력받은 후 5를 곱하면
        // 해당 index 에서 시작 index 를 알 수 있다.
        // index 가 0 일경우 시작 index 는 0,
        // index 가 1 일경우 시작 index 는 5가  된다.
        start = start * 5;

        // 마지막 index
        // 5를 더한 것보다 남은 광물의 길이가 작을 수 있기 때문에
        int range = Math.min(start + 5, minerals.length);


        int sum = 0;
        //System.out.println(num);
        for (int i = start; i < range; i++) {
            switch (minerals[i]) {
                case "diamond":
                    sum += num == 0 ? 1 : num == 1 ? 5 : 25;
                    // num = 0 : 곡괭이가 다이아
                    // num = 1 : 곡괭이가 철이기 때문에 1이면 피로도 5를 추가
                    // 아니면 곡괭이가 돌이기 때문에 피로도 25 추가
                    break;

                case "iron":
                    sum += num == 0 ? 1 : num == 1 ? 1 : 5;
                    // num = 0 : 곡괭이가 다이아 임으로 피로도 1 추가
                    // num = 1 : 곡괭이가 철이고 광물도 철이기 때문에 피로도 1 추가
                    // 그외 피로도 5추가
                    break;

                case "stone":
                    sum += 1;
                    // 돌은 어떤 곡괭이로 캐던 피로도 1추가
                    break;
            }
        }
        return sum;
    }
}
