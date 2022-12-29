package programmers;// https://school.programmers.co.kr/learn/courses/30/lessons/77486
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매 {
    public static void main(String[] args) {
        Solution_칫솔 s = new Solution_칫솔();

        String[] e1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] r1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] s1 = {"young", "john", "tod", "emily", "mary"};
        int[] a1 = {12, 4, 2, 5, 10};
        //result = [360, 958, 108, 0, 450, 18, 180, 1080];

        System.out.println(Arrays.toString(s.solution(e1, r1, s1, a1)));
    }
}

class Solution_칫솔 {
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, String> order = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        for(int i = 0; i < enroll.length; i++){
            order.put(enroll[i], referral[i]);
            map.put(enroll[i], i);
        }

        for(int i = 0; i < seller.length; i++){
            String name = seller[i];
            int price = amount[i] * 100;

            while(!name.equals("-")){
                int change = price / 10;
                int realPrice = price - change;

                answer[map.get(name)] += realPrice;

                name = order.get(name);
                price = change;

                if(price < 1) break;
            }
        }


        return answer;
    }
}
