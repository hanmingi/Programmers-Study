package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 귤 {
    public static void main(String[] args) {
        Solution_귤 s = new Solution_귤();

        // result 3
        int k1 = 6;
        int[] t1 = {1, 3, 2, 5, 4, 5, 2, 3};

        // result 2
        int k2 = 4;
        int[] t2 = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(s.solution(k1, t1));
        System.out.println(s.solution(k2, t2));
    }
}

class Solution_귤 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());

        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for(Integer key : keySet){
            k -= map.get(key);
            answer++;
            if(k <= 0) break;
        }

        return answer;
    }
}
