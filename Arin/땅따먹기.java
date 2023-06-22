class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) { // 두번째 행부터 최대 합산값을 구해 행마다 누적한다.
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        int answer = 0;
        for (int la : land[land.length - 1]) { // 마지막 행의 누적 합산값중 최대값 출력
            if (answer < la)
                answer = la;
        }
        return answer;
    }
}