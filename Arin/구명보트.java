import java.util.Arrays;

class Solution_lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int light = 0;
        for (int i = people.length-1; i > light; i--) {
            if (people[i] + people[light] <= limit) {
                answer++;
                light++;
            } else {
                answer++;
            }
        }

        return answer;
    }
}

public class 구명보트 {
    public static void main(String[] args) {
        Solution_lifeboat sol = new Solution_lifeboat();
        int[] people = { 70, 50, 80, 50 };
        int limit = 100;
        System.out.println(sol.solution(people, limit));

    }
}