import java.util.*;

class Solution_SuccessiveNumArray {
    public int solution(int[] elements) {

        // 배열의 끝부분과 앞부분의 연속수열 합 구할 수 있도록 elements 2번 반복하는 배열 선언
        int[] elementsDouble = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            elementsDouble[i] = elementsDouble[i + elements.length] = elements[i];
        }

        // 중복 허용하지 않아야 하므로 set에 담는다
        HashSet<Integer> set_tot = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) { // 합계 시작할 인덱스
                int num = 0; // set에 넣을 숫자
                for (int k = 0; k < i; k++) { // k개(=i)의 합 구하기
                    num += elementsDouble[j + k];
                }
                set_tot.add(num);
            }
        }
        int answer = set_tot.size();
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