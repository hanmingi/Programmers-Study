import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> checkword = new ArrayList<String>();

        for (int i = 0; i< words.length; i++){
            String word = words[i];
            
            if(checkword.contains(word)){
                answer[0]=(i+1) % n;
                if(answer[0]==0){
                    answer[0]=n;
                    answer[1]=(i+1) /n;
                }else{
                    answer[1]=((i+1) /n )+1;
                }    
                return answer;
            }
            
            checkword.add(word); //맨위에 넣지 않는이유는 첫번째 나오자마자 중복체크카 되어서
            
             if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0]=(i+1) % n;
                if(answer[0]==0){
                    answer[0]=n;
                    answer[1]=(i+1) /n;
                }else{
                    answer[1]=((i+1) /n )+1;
                }    
                return answer;
            }
    
        }
        return answer;
    }
}
