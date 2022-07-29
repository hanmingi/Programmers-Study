import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        char [] arr = dartResult.toCharArray();

        String a = "";

        int [] num;

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'S':
                    break;
                case 'D':
                    n = n*n;
                    break;
                case 'T':
                    n = n * n * n;
                    break;
                
                case '*':
                    ;
                    break;
                    
                case '#':
                    n = n * n * n;
                    break;
            
                default:
                    num[] = arr[i];
                    m = arr[i];
                    a += arr[i];
                    break;
            }
        }

        return answer;
    }
}


public class Dart{ //프로그래머스-[1차] 다트 게임
    public static void main(String[] args) {
        
        Solution s = new Solution();
        System.out.println(s.solution("1S2D*3T")); //37
        System.out.println(s.solution("1D2S#10S")); //9 

        System.out.println(s.solution("1D2S0T")); //3 

        System.out.println(s.solution("1S2T3S")); //23 

        System.out.println(s.solution("1D#2S3S")); //5 

        System.out.println(s.solution("1T2D3D#")); //-4 

        System.out.println(s.solution("1D2S3T")); //59
    }
}