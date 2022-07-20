import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1431{ //시리얼 번호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0;i<n;i++) arr[i] = br.readLine();
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.length() - o2.length()==0){   // 1. 길이비교
                int a = getSum(o1);
                int b = getSum(o2);
                if(a - b == 0){                 // 2. 문자열에 숫자값의 합 비교
                    return o1.compareTo(o2);    // 3. 알파벳 순서 = 문자열 비교
                }
                else {
                    return a - b;
                }
            }else {
                return o1.length() - o2.length();
            }
        });
        for (String s : arr) System.out.println(s);
    }
    public static int getSum(String s){
        int a=0;
        s = s.replaceAll("[^0-9]","");
        for(char c : s.toCharArray()) a+=Character.getNumericValue(c);
        return a;
    }
}