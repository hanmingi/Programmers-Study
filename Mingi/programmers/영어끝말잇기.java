package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        Solution_english s = new Solution_english();

        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        System.out.println(Arrays.toString(s.solution(n, words)));
    }
}

class Solution_english {
    public int[] solution(int n, String[] words) {
        // answer 는 무조건 2자리
        int[] answer = new int[2];

        List<String> word_list = new ArrayList<String>();

        for(int i = 0; i < words.length; i++){

            if(word_list.contains(words[i])){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            word_list.add(words[i]);

            if(i > 0 && words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0)){
                answer[0] = (i % n) + 1; // 0, 1, 2 -> + 1 // 1, 2, 3
                answer[1] = (i / n) + 1; //
                break;
            }
        }

        return answer;
    }
}