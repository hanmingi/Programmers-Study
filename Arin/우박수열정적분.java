import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Integer> woo = new ArrayList<>(); // 우박수열 담을 리스트 선언. 우박수열이 몇개 나올지 모르므로 리스트.
        woo.add(k); // 우박수열 시작하는 주어진 수 k는 무조건 첫번째로 담는다.
        while (k > 1) { // 1이 될 때까지 아래의 연산 반복하여 우박수열 woo에 담는다.
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            woo.add(k);
        }

        double[] answer = new double[ranges.length];
        int idx = 0; // 리턴배열 answer의 인덱스
        for (int[] r : ranges) { // int[][] ranges = [[0,0],[0,-1],[2,-3],[3,-3]]
            double ans = 0;
            if (r[0] > woo.size() + r[1] - 1) { // 주어진 범위의 시작점은 r[0], 끝점은 수열의 개수 + r[1](오프셋 빼줌) - 1
                                                  // -1해줘야 함. 수열의 맨 끝부터 순차적으로 -0, -1... 빼줘야 끝점 나오므로.
                answer[idx++] = -1.0; // 문제에서 시작점이 끝점보다 크면 정적분 결과는 -1로 정의함
                continue;
            // } else if (r[0] == woo.size() + r[1] - 1) { // 시작점과 끝점이 같은 경우는 0.0이지만, 디폴트값이므로 안써도 무방.
            //     answer[idx++] = 0.0;
            //     continue;
            }
            for (int i = r[0]; i < woo.size() + r[1] - 1; i++) { // [0,-1] -> 0부터 5+(-1)-1=3까지 x축 1칸마다의 넓이를 구해 누적한다.
                ans += ((woo.get(i) + woo.get(i + 1)) / 2.0) * 1; // 사다리꼴 넓이 더해줌. 높이는 항상 1(x축 한 칸이니까)
            }
            answer[idx] = ans;
            idx++;
        }
        return answer;
    }
}