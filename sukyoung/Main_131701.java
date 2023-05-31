import java.util.*;

class Solution {
        public int solution(int[] elements) {
            HashMap<Integer,Integer> count = new HashMap<>();
            int[] p = new int[elements.length];
            for(int len = 1;len <= elements.length; len++){
                for(int i = 0;i<elements.length;i++){
                    p[i]= p[i]+ elements[(len+i-1)%elements.length]; // % 하는 이유는 그길이 만큼의 합을 넘어가면 안되기때문에 
                    count.put(p[i], count.getOrDefault(count.get(p[i]), 0) + 1);
                }
            }
            return count.size();
        }
}
