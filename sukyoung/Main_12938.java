import java.util.*;

class Solution {
  public int[] solution(int n, int s) {     //값이가장크려면 가장비슷한값끼리 곱하는것이 가장큼 1 99 /  50  50
      
        int [] answer = new int[n];
        int nam = s % n;
       if(n > s) {
         answer = new int[1];
         answer[0] = -1;
       }

        if(n <= s) {
          answer = new int[n];
          for(int i=n-1; i>=0 ; i--) {  //거꾸로하면 마지막정렬노필요
           if(nam != 0) {
               answer[i] = s/n + 1;
               nam = nam - 1; 
           } else {
             answer[i] = s/n;
           }
          }
        }
//           for(int i=0; i<n ; i++) {
//            if(nam != 0) {
//                answer[i] = s/n + 1;
//                nam = nam - 1; 
//            } else {
//              answer[i] = s/n;
//            }
//           }  
            //마지막 정렬해줘야해서 sort 하면됨
//         }
//         Arrays.sort(answer);
        return answer;
  }
}
