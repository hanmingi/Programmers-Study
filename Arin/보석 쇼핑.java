import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int kind = new HashSet<>(Arrays.asList(gems)).size(); // 보석 종류의 수
        Map<String, Integer> hmGemCnt = new HashMap<>(); // 보석이름, 보석 수 담을 맵
        int[] answer = new int[2];
        int length = Integer.MAX_VALUE; // 구입할 구간(가장 짧은 구간 찾아야 함)
        int start = 0;

        for (int idx = 0; idx < gems.length; idx++) {
            hmGemCnt.put(gems[idx], hmGemCnt.getOrDefault(gems[idx], 0) + 1); // 해당 보석의 개수를 value에 담음

            while (hmGemCnt.get(gems[start]) > 1) { // 맨앞부터 보석이 2개 이상 있는 경우를 찾아
                hmGemCnt.put(gems[start], hmGemCnt.get(gems[start++]) - 1); // 개수 하나 빼주고, start 갱신한다
            }

            if (hmGemCnt.size() == kind && length > (idx - start)) { // 맵에 보석종류가 다 들어가 있고,
                                                                     // 구매할 구간이 이전 구간보다 짧으면 갱신한다
                answer[0] = start + 1;
                answer[1] = idx + 1;
                length = idx - start;
            }
        }
        return answer;
    }
}