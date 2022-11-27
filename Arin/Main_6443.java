import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_6443 { // 애너그램

    static StringBuilder sb = new StringBuilder(); // answer char배열에 단어 담아두고 마지막에 for문으로 sb에 담아서 출력.
    static char[] wordAlphabet;
    static char[] answer;
    static boolean[] visited;
    static int wordLenth;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = Integer.parseInt(br.readLine()); // 단어의 개수 받기

        int N = 1;
        for (int i = 0; i < N; i++) { // 단어 개수만큼 반복
            //String inputt = br.readLine(); // 단어 입력받기
            String inputt = "abb";
            wordLenth = inputt.length(); // 입력받은 단어의 문자길이
            wordAlphabet = inputt.toCharArray(); // 단어의 알파벳을 char형 배열에 담기
            answer = new char[wordLenth];
            visited = new boolean[wordLenth]; // boolean의 기본값은 false이고,
                                              // visited 배열은 선언만 해두었으므로, visited에는 false만 들어있음
            Arrays.sort(wordAlphabet);
            dfs(0);
        }
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        System.out.println();
        System.out.println("depth: "+depth);
        if (depth == wordLenth) {
            for (int i = 0; i < wordLenth; i++) {
                sb.append(answer[i]);
            }
            sb.append("\n");
            return;
        }
        char past = '\0'; // 중복 제거 위해 이전 문자를 담아둘 변수
        for (int i = 0; i < wordLenth; i++) {
            if (!visited[i] && past != wordAlphabet[i]) { // 이전에 방문한 적 없고, 이전 문자와 다른 문자일 때
                visited[i] = true;
                answer[depth] = wordAlphabet[i];
                System.out.print("["+i+"] answer[depth]: "+answer[depth]+"  ");
                past = wordAlphabet[i];
                dfs(depth + 1);
                visited[i] = false;
            }

        }
    }
}