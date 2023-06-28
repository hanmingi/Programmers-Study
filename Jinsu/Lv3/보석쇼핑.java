package LV3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GemsShopping {
    public int[] solution(String[] gems) {
        
        HashMap<String, Integer> map = new HashMap<>(); //보석을 출현 빈도수 체크용 맵
        HashSet<String> set = new HashSet<>();  //보석 종류 구하는 해시셋     
        Queue<String> que = new LinkedList<>(); //보석 진열대탐색

        
        
        //보석 종류 Distinct, 보석 중복체크, 진열대 입력
        for(String gemName : gems)
        {
            set.add(gemName);   
            // que.add(gemName);
            // map.put(gemName, map.getOrDefault(gemName, 0)+1);
        }
        int gemsCount = set.size(); //보석 종류 개수      

        int left = 0; //계산용
        // int right = 0;  //계산용

        int leftToRight = Integer.MAX_VALUE;    //정답반환용
        int answerLeft = 0;                      //정답반환용


        for (String gemName : gems) 
        {
            que.add(gemName);
            map.put(gemName, map.getOrDefault(gemName, 0) + 1);

            //투포인터 이용하여 범위 탐색
            while (true) {
                String nowLeftGem = que.peek();    //현재 가장 좌측 보석

                //현재 가장 좌측에있는 보석이 구간범위에 중복값이면, 좌측 포인터를 한칸 이동함
                if (map.get(nowLeftGem) > 1) 
                {
                    que.poll(); //좌측보석 삭제
                    map.put(nowLeftGem, map.get(nowLeftGem) - 1);   //맵에서 갯수하나 빼줌
                    left++;
                }
                //범위가 확정되면, 루프문 탈출
                else 
                {
                    break;
                }
            }

            //맵의 사이즈와, 해쉬셋의 사이즈가 같으면, 모든 보석을 다 담은것
            // 이때의 큐의 시작지점과, 끝지점을 구한다.
            if (map.size() ==set.size() && leftToRight > que.size()) {
                answerLeft = left;
                leftToRight = que.size();
            }
        }
        
        //정답 반환
        int[] answer = {answerLeft+1,answerLeft + leftToRight};
        return answer;
    }
    
}
