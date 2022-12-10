package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120841
 * */

public class 점의위치구하기 {
    public static void main(String[] args) {
        Solution_점의위치 s = new Solution_점의위치();

        int[] d1 = {2, 4};
        System.out.println(s.solution(d1));
    }
}

class Solution_점의위치 {
    public int solution(int[] dot) {
        int x = dot[0];
        int y = dot[1];

        if(x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else  {
            return 4;
        }
    }
}