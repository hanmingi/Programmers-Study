class Solution_targetNumber { // 타겟넘버
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    // 깊이 우선 탐색
    public void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) { // 주어진 numbers배열의 마지막 노드(depth)까지 탐색한 경우
            if (target == sum) // 합계와 target이 같으면 answer 증가
                answer++;
        } else { // target과 같은 숫자 만들기 위해 numbers배열의 숫자들을 더하거나 빼야 함
            dfs(numbers, depth + 1, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
            dfs(numbers, depth + 1, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
        }
    }

}

public class 타겟넘버 {
    public static void main(String[] args) {

        Solution_targetNumber s = new Solution_targetNumber();
        int[] numbers = { 4, 1, 2, 1 };
        int target = 4;
        System.out.println(s.solution(numbers, target));
    }
}