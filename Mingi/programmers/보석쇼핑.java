package programmers;

import java.util.*;

public class 보석쇼핑 {
    public static void main(String[] args) {
        Solution_보석쇼핑 s = new Solution_보석쇼핑();

        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

        System.out.println(Arrays.toString(s.solution(gems)));
    }
}

class Solution_보석쇼핑 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2]; // 정답은 무조건 두자리
        int cnt = 0; // 보석 리스트에서 뺀 보석의 갯수
        int len = Integer.MAX_VALUE;
        int start = 0;
        HashMap<String, Integer> hm = new HashMap<>();

        // 보석 종류 중복값 제거
        // 최소 1개라도 구매해야 하는 보석
        HashSet<String> hs = new HashSet<>(Arrays.asList(gems));

        System.out.println("hm = " + hm);
        System.out.println("hs = " + hs);

        Queue<String> q = new LinkedList<>();

        for(int i= 0; i < gems.length; i++){
            // 보석명 : 보석 갯수
            hm.put(gems[i], hm.getOrDefault(gems[i], 0) + 1);
            q.add(gems[i]);
            System.out.println("hm = " + hm);
            System.out.println("hs = " + hs);
            while(hm.get(q.peek()) > 1){
                String temp = q.poll();
                hm.put(temp, hm.get(temp) -1);
                cnt++;
            }

            // 모든 보석을 구매하였는지 확인
            // 최소값인지 확인
            System.out.println("i = " + i);
            System.out.println("cnt = " + cnt);

            if(hm.size() == hs.size() && len > (i - cnt)){
                len = i - cnt;
                start = cnt + 1;
            }
        }

        answer[0] = start;
        answer[1] = start + len;

        return answer;
    }
}
