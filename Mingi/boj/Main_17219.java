import java.io.*;
import java.util.*;

public class Main_17219 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            sb.append(map.get(br.readLine())).append('\n');
        }
        System.out.println(sb.toString());

    }
}
