import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2852 { // NBA 농구

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 골이 들어간 횟수
        int goalTeam = 0; // 골을 넣은 팀 (팀1 혹은 팀2)
        int goalTime = 0; // 골을 넣은 시각 (mm:ss)
        int winningTime1 = 0; // 팀1이 이기고 있는 시간
        int winningTime2 = 0; // 팀2가 이기고 있는 시간
        int winStatus = 0; // 승부상황
        int prevWinStatus = 0; // 직전승부상황
        int Score1 = 0; // 팀1의 스코어
        int Score2 = 0; // 팀2의 스코어
        int timeToRem = 0; // 이기고 있는 시간에 계산될 시각

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            goalTeam = Integer.parseInt(stk.nextToken());
            String mmss = stk.nextToken();
            String[] time = mmss.split(":");
            goalTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            if (goalTeam == 1) Score1++;
            else if (goalTeam == 2) Score2++;

            // 승부상황 (0:무승부, 1:팀1이기는중, 2:팀2이기는중)
            if (Score1 > Score2) winStatus = 1;
            else if (Score1 < Score2) winStatus = 2;
            else winStatus = 0;

            if (prevWinStatus == 0) { // 직전에 무승부였다가 한 팀이 골을 넣은 경우
                timeToRem = goalTime; // 이기고 있는 시간에 계산될 시각 기록
            } else if (winStatus == 0) { // 이번에 무승부가 된 경우
                if (goalTeam == 1) { // 이기고 있던 팀의 이기고 있는 시간 계산
                    winningTime2 += goalTime - timeToRem;
                } else if (goalTeam == 2) {
                    winningTime1 += goalTime - timeToRem;
                }
            }
            prevWinStatus = winStatus; // 직전승부상황
        }

        // 경기가 끝나고 이기고 있던 팀의 이기고 있는 시간을 계산해줌
        if (winStatus == 1) {
            winningTime1 += 48 * 60 - timeToRem;
        } else if (winStatus == 2) {
            winningTime2 += 48 * 60 - timeToRem;
        }
        System.out.printf("%02d:%02d\n%02d:%02d\n", winningTime1 / 60, winningTime1 % 60,
                           winningTime2 / 60, winningTime2 % 60);
    }

}