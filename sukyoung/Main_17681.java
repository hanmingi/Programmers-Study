import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String answer = "";
        String addanswer = "";
        String[] answer1 = new String[n];

        String p = "";
        for (int j = 0; j < n; j++) {
            int num1 = arr1[j];
            for (int i = 0; i < n; i++) {
                if (num1 / (int) (Math.pow(2, (n - i - 1))) == 0) {
                    p += " ";
                } else {
                    p += "#";
                    num1 = num1 - (int) (Math.pow(2, (n - i - 1)));
                }
            }
        }

        String q = "";
        for (int j = 0; j < n; j++) {
            int num2 = arr2[j];
            for (int i = 0; i < n; i++) {
                if (num2 / (int) (Math.pow(2, (n - i - 1))) == 0) {
                    q += " ";
                } else {
                    q += "#";
                    num2 = num2 - (int) (Math.pow(2, (n - i - 1)));
                }
            }
        }

        for (int i = 0; i < p.length(); i++) {

            if (p.charAt(i) == q.charAt(i) && p.charAt(i) == ' ') {
                addanswer += " ";

            } else {
                addanswer += "#";
            }
        }

        for (int i = 0; i < n; i++) {
            answer1[i] = addanswer.substring(i * n, i * n + n);
        }

        return answer1;
    }
}

public class Main_17681 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        int[] t1 = { 9, 20, 28, 18, 11 };
        int[] t2 = { 30, 1, 21, 17, 28 };
        String[] answer = s.solution(n, t1, t2);

        for (int i = 0; i < n; i++) {
            System.out.println(answer[i]);
        }
    }

}