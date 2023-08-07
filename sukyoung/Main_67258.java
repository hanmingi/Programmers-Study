package sukyoung;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(gems));
        Queue<String> quedia = new LinkedList<>();
        int length = 100000;
        int quediaStart = 0; // 구간시작 지점
        int tempquediaStart = 0; // 카운트할 구간시작 지점
        
        for(int i = 0; i < gems.length; i++) {
            String gemName = gems[i];

            // 구간에 늘리며 보석 추가
            hashMap.put(gemName, hashMap.getOrDefault(gemName, 0) + 1);
            quedia.offer(gemName);

            while(true) {
                String temp = quedia.peek(); // 구간 첫번째 보석

                // 구간 첫번째 같은 보석이 2개 이상인 경우
                if (hashMap.get(temp) >= 2) {

                    hashMap.put(temp, hashMap.get(temp) - 1); //제거갯수한개뺌
                    quedia.poll();                     // 구간 맨앞에 보석을 제거

                    // 구간시작지점을 다음 지점플러스해서 변경
                    tempquediaStart++;
                }else {
                    break;
                }
            }
            // 구간에 등록된 보석 종류의 수와 전체 보석 종류 수가 같야하고
            // 이전에 해당 조건을 충족한 구간의 길이보다 더 짧은 경우
            if(hashMap.size() == hashSet.size() && length > quedia.size()) {
                length = quedia.size();
                quediaStart = tempquediaStart;
            }
        }

        return new int[]{quediaStart + 1, quediaStart + length};
    }
}
