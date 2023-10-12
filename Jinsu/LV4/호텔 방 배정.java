import java.util.*;
class Solution {
    HashMap<Long,Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        //손님수만큼 탐색
        for(int i = 0 ; i <room_number.length; i++)
        {
            answer[i] = find(room_number[i]);
        }
        return answer;
    }

    long find(long roomNumber)
    {
        long room = roomNumber;
        //이미 배정된방일경우 재귀로 다시탐색
        if(map.containsKey(room))
        {
            room = find(map.get(room));
        }
        map.put(roomNumber, room +1);   //같은번호로 들어오는경우에는 방번호+1로 늘려줌
        return room;
    }
}