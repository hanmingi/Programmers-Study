package programmers;

import java.util.Arrays;

public class 우박수열정적분 {
    public static void main(String[] args) {
        Solution_우박수열정적분 s = new Solution_우박수열정적분();

        int k = 5;
        int[][] ranges = {{0,0}, {0, -1}, {2, -3}, {3, -3}};
        //{33.0, 31.5, 0.0, -1.0}

        System.out.println(Arrays.toString(s.solution(k, ranges)));
    }
}

class Solution_우박수열정적분 {
    public double[] solution(int k, int[][] ranges) {

        double[] answer = new double[ranges.length];

        // 아래에서 구한 cnt 는 y축 점의 갯수가 된다.
        // 배열을 하나 선언하여 cnt 만큼 크기를 준다면 우박수열의 y 좌표를 컨트롤 할 수 있다.
        int cnt = count(k);

        // +1 로 배열을 해주는 이유는 0번째 배열은 입력값 k 가 되어야 한다.
        double[] y = new double[cnt+ 1];
        y[0] = k; // 처음좌표는 k 입력값

        // 우박 수열의 모든 y 좌표 -> y[]
        for(int i = 1; i < y.length; i++){
            double d = y[i-1];
            y[i] = calcY(d);
        }

        // 사다리꼴 넓이
        //double[] trapezoid = new double[];
        double[] t = new double[cnt + 1];
        for(int i = 1; i < t.length; i ++){
            t[i] = (y[i] + y[i-1]) / 2;
        }

        // 누적합을 사용하여 구간합을 구한다.
        double[] s = new double[cnt + 1];
        // 누적합을 사용할 때 s[1] = t[1]이 되며 s[2] 가 = s[1] + t[2]가 된다.
        s[1] = t[1];
        for(int i = 2; i < s.length; i++){
            s[i] = t[i] + s[i-1];
        }

        // s 배열을 열어보면 0 ~ 1, 0 ~ 2, 0 ~ 3 까지의 구간합이 들어있다.
        // 따라서 2 ~ 3의 구간합을 구하고 싶다면 0 ~ 3 (-) 0 ~ 2를 하면 된다.

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = cnt + ranges[i][1];

            if(start==end) answer[i] = 0.0;
            else if(start > end) answer[i] = -1.0;
            else {
                double temp = s[end] - s[start];
                answer[i] = Double.parseDouble(String.format("%.1f", temp));
            }
        }
        return answer;
    }

    // 몇번의 과정을 거쳐야 하는지
    // count 를 구해 return 한다.
    // 실제 y 값은 계속해서 return 해줘야하며 double 형으로 리턴해야 함으로
    // 함수를 재구현한다.
    static int count(int k){
        int cnt = 0;
        while(k > 1){
            if(k%2 == 0) k=k/2;
            else k = (k*3)+1;
            cnt++;
        }
        return cnt;
    }

    static double calcY(double d){
        if(d%2 == 0) return d/2;
        else return (3*d)+1;
    }
}