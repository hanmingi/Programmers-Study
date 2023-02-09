package programmers;

public class 미로탈출명령어 {
    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k = 5;

        Solution_미로탈출 s = new Solution_미로탈출();

        System.out.println(s.solution(n,m,x,y,r,c,k));
        //"dllrl"

    }
}

class Solution_미로탈출 {
    String[][] map;
    static String answer = "";
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] alpha = {"d", "l", "r", "u"};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if(dist > k || (k - dist) % 2 == 1) return "impossible";

        dfs(n, m, x, y, r, c, "", 0, k);

        return answer;
    }


    static void dfs(int n, int m, int x, int y, int r, int c, String temp, int cnt, int k){
        if(k < cnt + Math.abs(x - r) + Math.abs(y - c)) return;

        if(x == r && y == c && cnt == k) {
            answer = temp;
            return;
        }

        for(int i = 0; i < 4; i++){
            if(isValid(x + dx[i], y + dy[i], n, m) && isDict(temp, answer)){
                dfs(n, m,x + dx[i], y + dy[i], r, c, temp + alpha[i], cnt + 1, k);
            }
        }
    }

    static boolean isValid(int nx, int ny, int n, int m){
        return 1 <= nx && nx <= n && 1 <= ny && ny <= m;
    }

    static boolean isDict(String temp, String answer){
        if(answer.equals("")) return true;
        int t_count = 0;
        int a_count = 0;
        for(int i = 0; i < temp.length(); i++){
            char t = temp.charAt(i);
            t_count += (int)t;

            char a = answer.charAt(i);
            a_count += (int)a;
        }
        return t_count < a_count;
    }
}
