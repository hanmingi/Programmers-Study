import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        // 뒤에서부터(큰 숫자부터) 비교한다
        int idxB = B.length - 1;
        for (int idxA = A.length - 1; idxA >= 0; idxA--) {
            if (A[idxA] < B[idxB]) { // B가 이기면
                answer++;
                idxB--; // 다음으로 큰 숫자로 이동
            } // B가 못 이기면 -> 어차피 idx 이동해도 더 작은 숫자밖에 없으므로
              // B가 이기는 상황까지 A의 idx만 이동하고, B의 idx는 이동하지 않는다.
        }
        return answer;
    }
}