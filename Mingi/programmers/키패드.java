class Solution {

    static int left_before = -1;
    static int right_before = -2;

    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        for(int i = 0; i < numbers.length; i++){
            answer += checkHands(numbers[i], hand);
        }

        return answer;
    }

    static String checkHands(int n, String h){
        String temp = "";

        if(n == 1 || n == 4 || n == 7) {
            temp += "L";
            left_before = n;
        }

        else if(n == 3 || n == 6 || n ==9) {
            temp += "R";
            right_before = n;
        }

        else{
            temp += findHand(n, h);
        }

        return temp;
    }

    static String findHand(int n, String h){
        String f = "";
        
        int[] l = findIndex(left_before);
        int[] r = findIndex(right_before);
        int[] t = findIndex(n);

        int l1 = Math.abs(t[0] - l[0]) + Math.abs(t[1] - l[1]);
        int r1 = Math.abs(t[0] - r[0]) + Math.abs(t[1] - r[1]);

        // System.out.println("n : " + n);

        // System.out.println("l1 : " + l1 + "  r1 : " + r1);
        // System.out.println("left_before : " + left_before);
        // System.out.println("right_before : " + right_before);

        // System.out.println();

        if(l1 < r1) {
            f += "L";
            left_before = n;
        }
        else if(l1 > r1) {
            f += "R";
            right_before = n;
        }
        else{
            if(h.equals("left")) {
                f += "L";
                left_before = n;
            }
            else {
                f += "R";
                right_before = n;
            }
        }

        return f;
    }

    static int[] findIndex(int n){
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(arr[i][j] == n) return new int[] {i, j};
            }
        }
        if(n == -1) return new int[] {3, 0};
        else return new int[] {3, 2};
    }
}


public class 키패드 {
    public static void main(String[] args){

        Solution s = new Solution();

        int[] t1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        //int[] t1 = {1, 3, 4, 5};
        String h1 = "right";

        int[] t2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String h2 = "left";

        int[] t3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String h3 = "right";

        //LRLLLRLLRRL
        // System.out.println(s.solution(t1, h1));
        // System.out.println("LRLLLRLLRRL");

        //LRLLRRLLLRR
        System.out.println(s.solution(t2, h2));
        System.out.println("LRLLRRLLLRR");


        //LLRLLRLLRL
        // System.out.println(s.solution(t3, h3));
        // System.out.println("LLRLLRLLRL");
    }
}
