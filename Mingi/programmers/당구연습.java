package programmers;

import java.util.Arrays;

public class 당구연습 {
    public static void main(String[] args) {
        Solution_당구연습 s = new Solution_당구연습();

        int m = 10;
        int n = 10;
        int startX = 3;
        int startY = 7;
        int[][] balls = {{7,7}, {2, 7}, {7, 3}};

        System.out.println(Arrays.toString(s.solution(m, n, startX, startY, balls)));
    }
}

class Solution_당구연습 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int tmp, idx = 0;

        for(int[] ball : balls){

            // 시작지점의 공과 도착지점의 공의 x, y 좌표의 차이
            // 해당 두개의 변수로 같은 위치선상에 있는지 알 수 있음
            int diffX = startX - ball[0];
            int diffY = startY - ball[1];

            double top = Math.pow(diffX, 2) + Math.pow((n - startY) + (n - ball[1]), 2);
            double bottom = Math.pow(diffX, 2) + Math.pow(startY + ball[1], 2);
            double left = Math.pow(startX + ball[0], 2) + Math.pow(diffY, 2);
            double right = Math.pow((m-startX) + (m - ball[0]) , 2) + Math.pow(diffY , 2);

            System.out.println();
            System.out.println("###################################");
            System.out.println("top = " + top);
            System.out.println("bottom = " + bottom);
            System.out.println("left = " + left);
            System.out.println("right = " + right);
            System.out.println("###################################");

            // diffX 가 0이면 같은 X 축 상에 있는 것이기 때문에
            // diffY 가 양수, 음수에 따라 위 아래의 쿠션 가능 여부가 나온다.
            if(diffX == 0){
                // diffY 가 양수는 시작 공이 더 위에 있다는 의미 이기 때문에 아래 쿠션은 사용 불가
                if(diffY > 0) tmp = CalcMin(top, Double.MAX_VALUE, left, right);
                else tmp = CalcMin(Double.MAX_VALUE, bottom, left, right);
            }
            // diffY 가 0이면 같은 Y 축 상에 있는 것이기 때문에
            // diffX 가 양수, 음수에 따라 좌, 우 쿠션 가능 여부가 나온다.
            else if (diffY == 0) {
                if (diffX > 0) tmp = CalcMin(top, bottom, Double.MAX_VALUE, right);
                else tmp = CalcMin(top, bottom, left, Double.MAX_VALUE);
            }
            // 같은 축이 없다면 상, 하, 좌, 우의 길이를 전부 넣어서 최소값을 구한다.
            else{
                tmp = CalcMin(top, bottom, left, right);
            }

            // tmp 가 나왔다면 answer 에 더해준다.
            answer[idx] = tmp;
            idx++;
        }
        return answer;
    }

    public int CalcMin(double top, double bottom, double left, double right){
        double res = 0;

        double[] tmps = {top, bottom, left, right};

        for(double tmp : tmps){
            if(res == 0) res = tmp;
            else res = Math.min(res, tmp);
        }

        return (int)res;
    }
}