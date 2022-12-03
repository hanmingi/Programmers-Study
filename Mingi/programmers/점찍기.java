package programmers;

public class 점찍기 {
    public static void main(String[] args) {
        Solution_점 s = new Solution_점();

        int k1 = 1;
        int d1 = 4;
        //6
        System.out.println(s.solution(k1, d1));

        int k2 = 1;
        int d2 = 5;
        //26
        System.out.println(s.solution(k2, d2));
    }
}

class Solution_점 {
    public long solution(int k, int d) {
        long answer = 0;

        for(int i = 0; i <= d; i += k){
            answer += (int)(Math.pow(Math.pow(d, 2) - Math.pow(i, 2), 0.5)) / k + 1;
        }

//        for(int i = 0; i <= d; i += k){
//            for(int j = 0; j <=d; j += k){
//                if(calcLength(j, i, d)) answer++;
//                else break;
//            }
//        }
        return answer;
    }

    static boolean calcLength(int x, int y, int z){
        System.out.println("x : " + x + "/ y : " + y + "/ z : " + z);
        if(Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(z, 2)) return true;
        else return false;
    }
}