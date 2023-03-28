import java.util.*;

class Solution_EnglishWords {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> wordsList = new ArrayList<>(); // 단어 중복 체크를 위한 리스트 선언
        wordsList.add(words[0]); // 첫 단어는 틀릴 경우가 없으므로 그냥 리스트에 넣어준다
        for (int i = 1; i < words.length; i++) { // 두번째단어(i=1)부터 확인 시작
            if (!words[i - 1].substring(words[i - 1].length() - 1, words[i - 1].length())
                .equals(words[i].substring(0, 1)) // 직전단어의 마지막 스펠과 현단어의 첫스펠이 일치하는지 확인
                || wordsList.contains(words[i])) { // 현 단어가 이미 나온 단어인지 확인(= 리스트에 있는 단어인지 확인)
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } else { // 1) 끝스펠과 첫스펠이 맞고, 2) 이전에 나오지 않은 단어라면
                wordsList.add(words[i]); // 리스트에 해당 단어를 넣어준다
                // if (i == words.length - 1) { //
                //     answer[0] = 0;
                //     answer[1] = 0;
                // }
            }
        }
        // if (answer[0]) { //
        //     answer[0] = 0;
        //     answer[1] = 0;
        // }
        return answer;
    }
}

public class 영어끝말잇기 {
    public static void main(String[] args) {
        Solution_EnglishWords sol = new Solution_EnglishWords();
        // int n = 3;
        // String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
        int n = 5;
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        
        int[] a = sol.solution(n, words);
        System.out.println(a[0] + "," + a[1]);
    }
}