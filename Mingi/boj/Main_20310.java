//package develope;

import java.util.*;

public class Main_20310 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] arr = str.toCharArray();
        String answer = "";

        int count_0 = 0;
        int count_1 = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '0') count_0++;
            else count_1++;
        }
        
        count_0 /= 2;
        count_1 /= 2;

        for(int i = 0; i < str.length(); i++){
            if(count_1 == 0) break;

            if(arr[i] == '1') {
                arr[i] = '-';
                count_1--;
            }
        }

        for(int i = arr.length - 1; i >= 0; i--){
            if(count_0 == 0) break;

            if(arr[i] == '0'){
                arr[i] = '-';
                count_0--;
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != '-') answer += arr[i];
        }
        System.out.println(answer);
    }
}

// HashMap<Character, Integer> map = new HashMap<>();

//         map.put('0', 0);
//         map.put('1', 0);

//         Scanner sc = new Scanner(System.in);

//         String str = sc.next();

//         for(int i = 0; i < str.length(); i++){
//             char c = str.charAt(i);

//             int value = map.get(c);

//             map.replace(c, ++value);
//         }

//         String answer = "";

//         for(int i = 0; i < map.get('0') / 2; i++){
//             answer += '0';
//         }

//         for(int i = 0; i < map.get('1') / 2; i++){
//             answer += '1';
//         }

//         System.out.println(answer);