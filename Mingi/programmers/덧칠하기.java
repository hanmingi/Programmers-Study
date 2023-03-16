package programmers;

public class 덧칠하기 {
    public static void main(String[] args) {
        Solution_덧칠하기 s = new Solution_덧칠하기();

        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};

        System.out.println(s.solution(n,m,section));
    }
}

class Solution_덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int sum = 0;

        // 칠해야 하는 공간들을 하나씩 가져온다.
        for (int s : section) {
            // 여기서 sum 은 현재까지 칠해진 최대 값을 저장하여 사용하며
            // s가 sum 보다 더 작은 경우는 현재 칠해져 있다라는 의미이기 때문에
            // continue 를 사용하여 다른 배열을 탐색한다.
            if (s < sum) {
                continue;
            }

            answer += 1;
            sum = s + m;
        }

        return answer;
    }
}