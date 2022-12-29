package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/142086

public class 가장가까운글자 {
    public static void main(String[] args) {
        Solution_가장가까운글자 s = new Solution_가장가까운글자();

        String s1 = "banana";
        System.out.println(Arrays.toString(s.solution(s1)));
    }
}


class Solution_가장가까운글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);

            if(map.containsKey(c)){
                int temp = map.get(c);
                answer[i] = i - temp;
                map.replace(c, i);
            }
            else{
                answer[i] = -1;
                map.put(c, i);
            }
        }
        return answer;
    }
}