class Solution_towerOfHanoi {
    private int index = 0;

    public int[][] solution(int n) {
        int[][] answer = new int[(int) Math.pow(2, n) - 1][2];
        hanoi(n, 1, 3, 2, answer);
        return answer;
    }

    public void hanoi(int n, int first, int second, int third, int[][] answer) {
        if (n == 1)
            answer[index++] = new int[] { first, third };
        else {
            hanoi(n - 1, first, second, third, answer); // 가장 큰 링을 제외하고 모두 2번으로 이동
            answer[index++] = new int[] { first, third }; // 가장 큰 링을 3번으로 이동
            hanoi(n - 1, second, third, first, answer); // n-1 하노이의 탑을 다시 반복하기 위해 재귀호출
        }
    }
}