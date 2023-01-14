package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 명예의전당 {
    public static void main(String[] args) {
        Solution_명예전당 s = new Solution_명예전당();

        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        System.out.println(Arrays.toString(s.solution(k, score)));
    }
}

class Solution_명예전당 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        ArrayList<Integer> arr = new ArrayList<>();
        int idx = 0;
        for(int temp : score){
            if (arr.size() == k){
                int min = arr.get(0);

                if(min < temp){
                    arr.remove(0);
                    arr.add(temp);
                    Collections.sort(arr);
                }

                answer[idx++] = arr.get(0);
            }
            else {
                arr.add(temp);
                Collections.sort(arr);
                answer[idx++] = arr.get(0);
            }
        }
        return answer;
    }
}