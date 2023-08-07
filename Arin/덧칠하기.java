class Solution_Repaint {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] painted = new int[n]; // 색칠 여부 담을 배열 선언

        // 다시 페인트를 칠하기로 정한 구역들의 번호가 담긴 정수 배열 section에서 구역 번호 꺼내와
        // painted에 -1(색칠X) 넣는다. section에 없는 구역은 초기값인 0(색칠O) 그대로이다.
        for (int i = 0; i < section.length; i++)
            painted[section[i] - 1] = -1;

        for (int i = 0; i < section.length; i++) {
            if (painted[section[i] - 1] == -1) {
                // 롤러 너비(m)만큼 0넣는다(=색칠한다)
                for (int j = section[i] - 1; j < section[i] - 1 + m; j++) {
                    if (j >= painted.length)
                        break;
                    painted[j] = 0;
                }
                answer++;
            }
        }
        return answer;
    }
}

public class 덧칠하기 {
    public static void main(String[] args) {
        Solution_Repaint sol = new Solution_Repaint();
        int n = 8;
        int m = 4;
        int[] section = { 2, 3, 6 };
        sol.solution(n, m, section);
    }
}