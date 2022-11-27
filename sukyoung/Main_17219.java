import java.util.*;
import java.io.*;

public class Main_17219{
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        Map<String,String> hs=new HashMap<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            String id=st.nextToken();
            String pass=st.nextToken();
            hs.put(id,pass);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            String id=br.readLine();
            sb.append(hs.get(id)+"\n");
        }
        System.out.println(sb);
    }
}
