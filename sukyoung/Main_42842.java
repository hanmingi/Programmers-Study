import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        int a,b;
        for(int i=1;i<=yellow;i++){
            if(yellow%i==0){
                a=i;
                b=yellow/a;
                if((a+2)*(b+2)==(brown+yellow) && a>=b){
                    answer[0]=a+2;
                    answer[1]=b+2;
                    break;
                }
            }
        }
        return answer;
    }
}
