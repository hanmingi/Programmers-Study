import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[] p = new int[24*60+10];
        int answer = 0;
        int max = 0;
        int[] listS = new int[24*60+10];
        int[] listE = new int[24*60+10];
        // List<Integer> listS = new ArrayList<Integer>();
        // List<Integer> listE = new ArrayList<Integer>();
        
        for(int i = 0; i < book_time.length; i++){
            String[] startStr = book_time[i][0].split(":");
            String[] endStr = book_time[i][1].split(":");

            int start = Integer.parseInt(startStr[0]) * 60 + Integer.parseInt(startStr[1]);
            int end = Integer.parseInt(endStr[0]) * 60 + Integer.parseInt(endStr[1] )+10; //10은 청소시간까지포함

            listS[i]=start;
            listE[i]=end;
        }
        for(int i = 0; i < 1450;i++){   
            p[listS[i]] =p[listS[i]] + 1;        
            p[listE[i]] =p[listE[i]] - 1;  
            // p[i] += p[i-1];
            // if(max < p[i]){
            //     max = p[i];
            // }
        }
        
        for (int i = 1; i < 1450; i++) {    //길이1부터 해줘야함 i-1이 있기때문에 오류남
            p[i] = p[i] + p[i-1];
            if(max < p[i]){
                max = p[i];
            }
        }
        return max;
    }
}
