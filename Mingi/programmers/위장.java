import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> countClothes = new HashMap<>();

        for(int i = 0; i < clothes.length; i++){
            countClothes.put(clothes[i][1], countClothes.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;

        for(String keys : countClothes.keySet()){
            answer *= countClothes.get(keys) + 1;
            //System.out.println(answer);
        }

        return answer - 1;
    }
}

public class 위장 {
    public static void main(String[] args){
        Solution s = new Solution();

        String[][] t1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses","eyewear"}, {"green_truban", "headgear"}};
        String[][] t2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(s.solution(t1)); // 5
        System.out.println(s.solution(t2)); // 3
    }
}
