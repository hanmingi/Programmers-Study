package programmers;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {
    public static void main(String[] args) {
        Solution_성격유형 s = new Solution_성격유형();

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(s.solution(survey, choices));
    }
}

class Solution_성격유형 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<Character, Integer> map = new HashMap<>();

        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);


        for(int i = 0; i < survey.length; i++){
            char[] temp = survey[i].toCharArray();

            switch (choices[i])
            {
                case 1:
                    map.put(temp[0], map.get(temp[0]) + 3);
                    break;
                case 2:
                    map.put(temp[0], map.get(temp[0]) + 2);
                    break;
                case 3:
                    map.put(temp[0], map.get(temp[0]) + 1);
                    break;
                case 5:
                    map.put(temp[1], map.get(temp[1]) + 1);
                    break;
                case 6:
                    map.put(temp[1], map.get(temp[1]) + 2);
                    break;
                case 7:
                    map.put(temp[1], map.get(temp[1]) + 3);
                    break;
                default:
                    break;
            }
        }

        //System.out.println(Collections.unmodifiableMap(map));

        if(map.get('R') >= map.get('T')) answer += "R";
        else answer += "T";

        if(map.get('C') >= map.get('F')) answer += "C";
        else answer += "F";

        if(map.get('J') >= map.get('M')) answer += "J";
        else answer += "M";

        if(map.get('A') >= map.get('N')) answer += "A";
        else answer += "N";

        return answer;
    }
}
