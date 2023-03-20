package LV2;

import java.util.HashMap;

public class EnglishFollowUp {    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int nowCount = 0;
        boolean isGame = true;        
        boolean isFirstWorld = true;
        boolean isAnswer = true;
        
        //정답지 해쉬맵
        HashMap<String,Integer> answerWordMap = new HashMap<>();

        while(isGame){
            if(nowCount >= words.length){
                isAnswer = false;
                break;
            }

            if(isFirstWorld){
                isFirstWorld = false;
                answerWordMap.put(words[0],answerWordMap.getOrDefault(words[0], 0) + 1);
                nowCount++;
                continue;
            }
            
            // isGame = isCorrect(words[nowCount-1], words[nowCount]);
            if(!isCorrect(words[nowCount-1], words[nowCount])){
                isGame = false;
                break;
            }
            answerWordMap.put(words[nowCount],answerWordMap.getOrDefault(words[nowCount], 0) + 1);

            if(answerWordMap.get(words[nowCount]) > 1)
                break;

            nowCount++;            
        }
        //words[nowCount] -> wrong answer
        if(!isAnswer){
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        else{
            int num = (nowCount % n) +1;
            int order = (nowCount / n) +1;
            answer[0] = num;
            answer[1] = order;
            return answer;
        }                     
    }

    public boolean isCorrect(String prevString, String nowString){
        boolean Correct = false;
        char prevWordEndChar = prevString.charAt(prevString.length()-1);
        char nowWordStartChar = nowString.charAt(0);

        // System.out.println("prevWordEndChar : " + prevWordEndChar);
        // System.out.println("nowWordStartChar : " + nowWordStartChar);

        if(prevWordEndChar == nowWordStartChar)
            Correct = true;                    
        else    
            Correct = false;

        return Correct;
    }
}
