package programmers;

public class 크기가작은부분문자열 {
    public static void main(String[] args) {

        Solution_크기가작은부분문자열 s = new Solution_크기가작은부분문자열();

        String t = "3141592";
        String p = "271";
        System.out.println(s.solution(t, p));
    }
}

class Solution_크기가작은부분문자열 {
    public int solution(String t, String p) {
        int len = p.length();
        long num = Long.parseLong(p);
        int result = 0;

        for (int i = 0; i < t.length() - len + 1; i++) {
            long diff = Long.parseLong(t.substring(i, i + len));
            if (diff <= num) result++;
        }
        return result;
    }
}