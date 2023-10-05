=====================================================무지의 먹방
  import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
        long sum = 0;
        int len = food_times.length;
        int[] sortedItem = new int[food_times.length];

        for (int i = 0; i < len; i++) {
            sortedItem[i] = food_times[i];
            sum += food_times[i];
        }
        if (sum <= k) { // 만약 장애전에 이미 다돌아버리면 -1리턴하라함
            return -1;
        }

        Arrays.sort(sortedItem); //정렬해주기
        int minIndex = 0;
        int width = len;
        long round = 0;

        // 효율성생각해줘야함    그래서 장애오기전에 한바퀴씩 도는거 whiel문으로 해줘야함
        while (k >= width) {
            k -= width;
            round++;

            while(sortedItem[minIndex] - round == 0) { //만약 hap이 바퀴 돈것인데 그것을 뺐을때 0이되면 그음식은 끝이기 때문에
                minIndex++;
                width--;
            }
        }

        for (int i = 0; i < len; i++) {
            food_times[i] -= round;
        }

        // 남은 시간은 순차적으로 계산
        int i = 0;
        while (k-- > 0) {
            while (food_times[i] <= 0) { // 음식이 있을때까지 인덱스 넘김
                i = (i + 1) % food_times.length; // 음식이 남아있던 말던 i에다가 다음 인덱스 넣어준다
            }
            food_times[i]--;  //0보다크면 하나빼고 다음 인덱스 넣어주기
            i = (i + 1) % food_times.length;
        }

        // 네트워크 장애 이후 다음번째 음식이 있을때까지 인덱스 넘김
        while (food_times[i] <= 0) {
            i = (i + 1) % food_times.length;
        }

        return i +1; // 인덱스니까 1더하기
    }
}

=====================================================3차 자동완성(다시 시도해봐야함)
  import java.util.*;
class Solution {
  public int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);     //단어 사전순으로 정렬된다 알파벳
        String a = words[0];
        String b = words[1];
        if(b.contains(a)) answer = a.length();     //포함한다면 그 길이 그대로
        else{
            for(int j = 0 ; j < a.length(); j++){   //포함 아니면 단어를 하나씩자르면서 포함안될때까지 계속for
                if(a.charAt(j) != b.charAt(j)) {
                    answer = j+1;
                    break;
                }
            }
        }
        for(int i = 1; i < words.length-1; i++){
            int pre = 0, next = 0;
            String preword = words[i-1]; 
            String word = words[i];
            String nextword = words[i+1];
            if(pre == 0){
                int j = 0;
                for(j = 0 ; j < word.length(); j++){
                    next = j+1;
                    if(word.charAt(j) != nextword.charAt(j)) { //첫번째와 똑같이 다음단어가 앞의것과 잘랐을경우 같지않아지는 부분까지 구하고 break걸어주기
                        break;
                    }
                }
                //if(j == preword.length()) 
                //{
                //    next =j-1;
                //};
            }
            answer += next;
        }
        String word = words[words.length-2];
        String nextword = words[words.length-1];
        int str_length = word.length();
        int j = 0;
        for(j = 0 ; j < str_length; j++){
            if(word.charAt(j) != nextword.charAt(j)) {
                answer += j+1;  //단어의 뒤 단어와 겹치는 부분 같지않다면  + 1
                break;
            }
        }
        if(j == str_length) {
          answer=j+1;   
        }    
        return answer;
  }
}

=====================================================호텔 방 배정
  import java.util.*;
 
class Solution {
    static HashMap<Long, Long> roomInfo = new HashMap<>();
 
    public long findEmptyRoom(long wantRoom) {  //union_find 사용해서 완전 비대칭 트리구조일때 효율적으로 사용
        if (!roomInfo.containsKey(wantRoom)) { // 요청한 방이 비어있음
            roomInfo.put(wantRoom, wantRoom + 1); // 그러면 빈방에 대해서 미리 요청한방 다음으로 연결을해준다
            return wantRoom;
        }
 
        long next_room = roomInfo.get(wantRoom);
        long empty_room = findEmptyRoom(next_room);
        roomInfo.put(wantRoom, empty_room);
        return empty_room;
    }
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
 
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findEmptyRoom(room_number[i]);  //이렇게 되면 재귀 호출이 되어서 차있으면 계속 빈방이 나올때 까지 반복
        }
 
        return answer;
    }
}
