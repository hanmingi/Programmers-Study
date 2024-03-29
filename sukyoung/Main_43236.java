import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer= 0;
        int start= 0;
        int end= distance;       
        Arrays.sort(rocks);
        while(start <= end) {
            int mid= (start+end) / 2;
            int trash= 0;
            int prev= 0;
            for(int i = 0; i < rocks.length; i++) {
                if (rocks[i]-prev < mid)
                    trash++;
                else
                    prev = rocks[i];
            }
            if(distance - rocks[rocks.length-1] < mid)
                trash++;
            if(trash<= n) {
                answer = mid;
                start = mid + 1;
            }
            else
                end= mid - 1;
        }
        return answer;
    }
}
