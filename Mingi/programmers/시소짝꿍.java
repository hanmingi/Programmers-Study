package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소짝꿍 {
    public static void main(String[] args) {

        Solution_시소 s = new Solution_시소();

        int[] weights = {100, 180, 360, 100, 270};

        System.out.println(s.solution(weights)); // 4
    }
}

class Solution_시소 {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);

        for(int weight : weights){
            answer += siso(weight, map);
        }

        return answer;
    }

    public long siso(int w, Map<Double, Integer> map){
        long answer = 0;


        double d1 = w * 1.0;
        double d2 = (w * 2.0) / 3.0;
        double d3 = (w * 1.0) / 2.0;
        double d4 = (w * 3.0) / 4.0;

//            System.out.println("w = " + w);
//            System.out.println("d2 = " + d2);
//            System.out.println("d3 = " + d3);
//            System.out.println("d4 = " + d4);

        if(map.containsKey(d1)) answer += map.get(d1);
        if(map.containsKey(d2)) answer += map.get(d2);
        if(map.containsKey(d3)) answer += map.get(d3);
        if(map.containsKey(d4)) answer += map.get(d4);

        map.put(w * 1.0, map.getOrDefault(w * 1.0, 0) + 1);
//
//        System.out.println("map = " + map);
//        System.out.println("answer = " + answer);

        return answer;
    }
}