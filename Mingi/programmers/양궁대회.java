package programmers;

import java.util.Arrays;

public class 양궁대회 {
    public static void main(String[] args) {
        Solution_양궁 s = new Solution_양궁();

        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        // result = {0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0};

        System.out.println(Arrays.toString(s.solution(n, info)));
    }
}

class Solution_양궁 {
    static int[] lion = new int[11];
    static int[] answer = new int[11];
    static int MAX = Integer.MIN_VALUE;

    static int count;
    static int[] bow;


    public int[] solution(int n, int[] info) {
        count = n;
        bow = info;
        backTracking(0);
        //int[] answer = {};

        if(MAX == -1) return new int[] {-1};

        return answer;
    }

    public void backTracking(int d) {
        // 화살의 갯수와 깊이가 동일할 때
        if(d == count){
            int score = calcScore(); // 점수차 리턴
            if(MAX <= score){
                MAX = score;
                answer = lion.clone();
            }
            return;
        }

        for(int i = 0; i < bow.length && lion[i] <= bow[i]; i++){
            lion[i] += 1;
            backTracking(d+1);
            lion[i] -= 1;
        }
    }

    public int calcScore(){
        int a = 0;  // 어피치
        int l = 0;  // 라이언

        for(int i = 0; i < lion.length; i++){
            if (bow[i] == 0 && lion[i] == 0) continue;     // 둘다 점수 미획득
            else if (bow[i] >= lion[i] ) a += (10 - i);    // 어피치 점수 획득
            else l += (10 - i);                             // 라이언 점수 획득
        }

        if(a >= l) return -1;   // 라이언 패배
        else return l - a;      // 점수차
    }
}
