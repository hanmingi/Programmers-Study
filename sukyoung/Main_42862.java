import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+1];
        int answer = n;
        for(int i=0;i<=n;i++){
            students[i]=1;
        }
        for(int l : lost) {
            students[l] =students[l]-1;
        }
        for(int r : reserve) {
            students[r] = students[r]+1;
        }
        for(int i=1; i<=n; i++){
            if(students[i] == 2){
                if(i!=1 && students[i-1] == 0) {
                    students[i-1] += 1;
                }    
                else if(i!=n && students[i+1] == 0) {
                    students[i+1] += 1;
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            if(students[i] == 0) {
                answer = answer-1;
            }
        }
        return answer;
    }
}