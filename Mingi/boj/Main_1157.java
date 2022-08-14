import java.util.*;

public class Main_1157 {

    static int[] arr = new int[26];
    static int answer;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        initArr();

        String t = s.toUpperCase();

        // A = 65
        // Z = 90

        // int temp = (int)'Z';
        // System.out.println(temp);

        for(int i = 0; i < t.length(); i++){
            arr[t.charAt(i) - 'A'] += 1;
        }

        findMax();
    }

    static void initArr(){
        for(int i = 0; i < 26; i++){
            arr[i] = 0;
        }
    }

    static void findMax(){
        int max = -1;
        for(int i = 0; i < 26; i++){
            if(max < arr[i]){
                max = arr[i];
                answer = i + 'A';
            }
            else if(max == arr[i]){
                answer = '?';
            }
        }

        System.out.println((char)answer);
    }
}
