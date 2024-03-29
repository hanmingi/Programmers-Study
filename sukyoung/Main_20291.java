import java.io.*;
import java.util.*;

public class Main_20291 {
	
	static int n;
	static TreeMap<String, Integer> map = new TreeMap<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(),".");
			st.nextToken();
			String str = st.nextToken();
			
			//map.put(str, map.getOrDefault(str, 0)+1);
            for(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }
            else{
                map.put(str,1);
            }
		}
		
		for(String key:map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
	}

}
