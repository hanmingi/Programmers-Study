import java.util.*;

class Solution_SuccessiveNumArray {
    public int solution(int[] elements) {
        int[] elementsDouble = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            elementsDouble[i] = elementsDouble[i + elements.length] = elements[i];
        }
        HashSet<Integer> tot = new HashSet<>();

        for (int i = 0; i < elements.length; i++) { // 길이가 i인 연속 부분 수열
            for (int j = 0; j < elements.length; j++) { // 합계 시작할 인덱스
                int num = 0;
                for (int k = 0; k < i; k++) {
                    num += elementsDouble[j + k];
                }
                tot.add(num);
            }
        }
        int answer = tot.size();
        return answer;
    }
}

public class 연속부분수열합의개수 {
    public static void main(String[] args) {
        Solution_SuccessiveNumArray sol = new Solution_SuccessiveNumArray();
        int[] elements = { 7, 9, 1, 1, 4 };
        System.out.println(sol.solution(elements));
    }
}