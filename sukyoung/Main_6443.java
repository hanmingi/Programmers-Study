import java.io.*;
import java.util.*;

public class Main_6443 {

    static StringBuilder sb = new StringBuilder();
    static char[] wordAlphabet;
    static char[] answer;
    static boolean[] visited;
    static int wordLenth;

    public static void main(String[] args) throws NumberFormatException, IOException {

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int N = 1;
    //     for (int i = 0; i < N; i++) {
    //         String inputt = "";
    //         wordLenth = inputt.length();
    //         wordAlphabet = inputt.toCharArray();
    //         answer = new char[wordLenth];
    //         visited = new boolean[wordLenth];
    //         Arrays.sort(wordAlphabet);
    //         dfs(0);
    //     }
    //     System.out.println(sb);
    // }

    private static void dfs(int depth) {
        for (int i = 0; i < answer.length; i++) {

        }
        if (depth == wordLenth) {
            for (int i = 0; i < wordLenth; i++) {
                sb.append(answer[i]);
            }
            sb.append("\n");
            return;
        }
        char past = '\0';
        for (int i = 0; i < wordLenth; i++) {
            if (!visited[i] && past != wordAlphabet[i]) {

                visited[i] = true;
                answer[depth] = wordAlphabet[i];
                past = wordAlphabet[i];
                dfs(depth + 1);
                visited[i] = false;
            }

        }
    }
}
public class Main_6443{
    public static void main(String[]args){
        BufferReader br= new BufferredReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        t=Integer.parseInt(st.nextToken());
        for(int k=0;k<t;k++){
            st=new StringTokenizer(bf.readLine());
            s=st.nextToken();
            n=s.length();
            v=new boolean[n];
            a=new int[26];
            PriorityQueue<Character>pq=new PriorityQueue<>();
            for(int i=0;i<n;i++){
                a[s.charAt(i)-'a']++;
                dfs(0,"");
            }
            System.out.println(sb);
        }

    }
}
