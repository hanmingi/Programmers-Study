package programmers;

import java.util.Arrays;

public class 숫자게임 {
    public static void main(String[] args) {
        Solution_숫자게임 s = new Solution_숫자게임();
        int[] A = {1, 3, 5, 7};
        int[] B = {2, 2, 6, 8};

        System.out.println(s.solution(A, B));

    }
}

class Solution_숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int adx = 0, bdx = 0;
        // A, B 를 작은 순서대로 정렬한다.
        Arrays.sort(A);
        Arrays.sort(B);

        // 문제의 조건 중 A 와 B 의 길이는 같기 때문에 반복문 길이의 중점을
        // 어떤 배열로 잡아도 문제 없음
        for(int i = 0; i < A.length; i++){
            // 수를 비교하면 3가지 경우의 수밖에 나오지 않음
            // A 가 클때, 같을 때, B 가 클때
            if(A[adx] > B[bdx]){
                bdx++;
            } else if (A[adx] == B[bdx]) {
                bdx++;
            } else {
                adx++;
                bdx++;
                answer++;
            }
        }
        return answer;
    }
}