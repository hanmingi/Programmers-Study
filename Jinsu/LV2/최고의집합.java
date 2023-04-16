package LV3;

import java.util.Arrays;

public class BestSet {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int middleRemain = s%n;
        int middle = s /n;

        // System.out.println(middleRemain);
        // System.out.println(middle);
        if(middle < 1){ 
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        for(int i = 0 ; i<n ; i++){
             answer[i] = middle;
        }

        // for(int j = 0 ; j<middleRemain ; j++){
        //     System.out.println(Math.ceil(middleRemain)); // 해당값이 중복으로 들어가면안됨, 모든 원소가 1씩 늘어나야됨
        //     answer[j] += Math.ceil(middleRemain);
        // }        
        for(int j = 0 ; j<middleRemain ; j++){        
        answer[j] += 1;
    }     

        Arrays.sort(answer);

        return answer;
    }
    
}
