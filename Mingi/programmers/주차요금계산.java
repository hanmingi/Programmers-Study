package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 주차요금계산 {
    public static void main(String[] args) {
        Solution_주차요금 s = new Solution_주차요금();

        int[] f1 = {180, 5000, 10, 600};
        String[] r1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] results = s.solution(f1, r1);
        for (int result : results) {
            System.out.println(result);
        }

    }
}

class Solution_주차요금 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> fee = new HashMap<>();

        for (String record : records) {
            fee.put(record.split(" ")[1], 0);
        }

        for(String record : records){
            String[] info = record.split(" ");

            if(map.containsKey(info[1])){
                String[] inTime = map.remove(info[1]).split(":");
                String[] outTime = info[0].split(":");

                int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
                int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);

                fee.replace(info[1], fee.get(info[1]) + 60 * hour + minute);
            }
            else{
                map.put(info[1], info[0]);
            }
        }

        for(String key : map.keySet()){
            String[] inTime = map.get(key).split(":");

            int hour = 23 - Integer.parseInt(inTime[0]);
            int minute = 59 - Integer.parseInt(inTime[1]);

            fee.replace(key, fee.get(key) + 60 * hour + minute);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(fee.entrySet());
        list.sort((o1, o2) -> {
            return (Integer.compare(Integer.parseInt(o1.getKey()), Integer.parseInt(o2.getKey())));
        });

        answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = calc_car(list.get(i).getValue(), fees);
        }

        return answer;
    }

    static int calc_car(int time, int[] fees){
        int money = 0;

        if(time > fees[0]) money = fees[1] + (int) Math.ceil((time - fees[0]) / (double)fees[2]) * fees[3];
        else money = fees[1];
        return money;
    }
}