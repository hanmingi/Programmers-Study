package programmers;

import java.util.PriorityQueue;

public class 호텔대실 {
    public static void main(String[] args) {
        Solution_호텔대실 s = new Solution_호텔대실();
        String[][] book = {
                {"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}
        };

        System.out.println(s.solution(book)); // 3
    }
}

class Solution_호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;

        PriorityQueue<Integer> in = new PriorityQueue<>();
        PriorityQueue<Integer> out = new PriorityQueue<>();

        int cnt = 1;

        // 들어오는 예약 현황 하나씩 받기
        for(String[] b : book_time){
            in.offer(calcMin(b[0]));

            // 퇴실 이후 청소 10분이 있기 때문에
            // 다음 사람이 쓰기 위해서는 10분 뒤부터 입실 가능
            out.offer(calcMin(b[1]) + 10);
        }

        // 들어온 사람과 나갈 사람이 들어있는 큐가 빌때까지 반복
        while(!out.isEmpty() && !in.isEmpty()){

            // out 이 있는 경우는 한명이 들어온 경우
            int o_p = out.poll();

            // 사람이 나갔다는 가정 하에 cnt --
            cnt--;

            // 들어올 사람이 추가적으로 있으며
            // 나갈 사람보다 더 일찍 들어올 예정이면
            // cnt 를 하나 증가시켜 줘야 한다.
            while(!in.isEmpty() && in.peek() < o_p){
                in.poll();
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public int calcMin(String s){
        int min = 0;

        String[] time = s.split(":");

        // 시 -> 분
        min += Integer.parseInt(time[0]) * 60;

        // 분
        min += Integer.parseInt(time[1]);

        return min;
    }
}