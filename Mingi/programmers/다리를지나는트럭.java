//package develope;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        Solution_트럭 s = new Solution_트럭();

        int b1 = 2;
        int w1 = 10;
        int[] t1 = {7, 4, 5, 6};

        System.out.println(s.solution(b1, w1, t1));
    }
}

class Solution_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;

        Queue<Integer> bridge = new LinkedList<>();

        for(int i = 0; i < truck_weights.length; i++){
            int truck = truck_weights[i];

            while(true){
                // 전체적인 시간 1씩 증가
                //answer++;
                
                // 큐가 비어있을 때
                if(bridge.isEmpty()){
                    bridge.add(truck);
                    sum += truck;
                    answer ++;
                    break;
                }

                //이미 다리위에 트럭이 가득 차있을 때
                else if(bridge.size() == bridge_length){
                    sum -= bridge.poll();
                }

                // 한대라도 올라가 있는 경우
                // 현재 있는 트럭들의 총 합과 새로 올라갈 트럭의 합이 
                // 다리의 최대 무게 보다 가벼워야 함
                else{
                    // 현재 다리위에 있는 트럭의 무게와 올릴 트럭의 무게의 합이
                    // weight보다 작거나 같다면 트럭을 올릴 수 있음
                    if(sum + truck <= weight){
                        bridge.add(truck);
                        sum += truck;
                        answer++;
                        break;
                    }

                    // 0을 추가해줌으로 써 이미 들어가 있는 트럭을 뺄 수 있도록 한다.
                    else{
                        bridge.add(0);
                        answer++;
                    }
                }
            }
        }

        return answer + bridge_length;
    }
}
