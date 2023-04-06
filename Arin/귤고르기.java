import java.util.*;

class Solution_pickingTangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        //Arrays.sort(tangerine);
        // for(int i = 0; i<tangerine.length; i++){
        //     System.out.print(tangerine[i]+",");
        // }
        HashMap<Integer,Integer> hm = new HashMap<>();
        // for(int i = 0; i<tangerine.length; i++){
        //     if(!hm.containsKey(tangerine[i])) hm.put(tangerine[i],1);
        //     else hm.replace(tangerine[i], hm.get(tangerine[i])+1);
        // }
        for(int t : tangerine){
            hm.put(t, hm.getOrDefault(t,0)+1);
        }
        // for(Integer keyy: hm.keySet()){
        //     System.out.print(keyy+":"+hm.get(keyy)+" / "); //자동 오름차순이네?!
        // }
        
        //
        List<Integer> sizeLi = new ArrayList<>(hm.keySet());
        sizeLi.sort((o1,o2) -> hm.get(o2) - hm.get(o1));
        //Collections.sort(sizeLi, Collections.reverseOrder());
        for(int i = 0; i < sizeLi.size(); i++)
            System.out.print(hm.get(sizeLi.get(i))+"!");
        int i = 0;
        while(k>0){
            k -= hm.get(sizeLi.get(i));
            System.out.print("sizeLi.get("+i+"):"+sizeLi.get(i)+" / ");
            answer++;
            i++;
        }
        
        return answer;
    }
}

public class 귤고르기 {
    public static void main(String[] args) {
        Solution_pickingTangerine sol = new Solution_pickingTangerine();
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3 };
        sol.solution(k, tangerine);
    }
}