import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer;
        int number;
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> groups = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            number = i;
            answer = 0;
            // if(visited[number]=false){
            //     groups.add(answer);
            //     break;
            // }
            while (!visited[number]) {
                answer++;
                visited[number] = true;
                number = cards[number] - 1;

            }
            groups.add(answer);
        }
        Collections.sort(groups, Comparator.reverseOrder());
                
        // if(groups.size() == 1){
        //     System.out.println("1");
        //     return 0;
        // }
        // 생각해보니 원래 사이즈가 한개가 나오면 0이 나오게하는게 만드는 조건을 넣었는데 실제 돌릴때 size는 2보다크고 나머지부분은 0으로 넣었기 때문에 사이즈가 하나인경우는 무조건 곱하기했을때 0 이 나올 것이라서 없어도 됨 시간다축 굳
        // else{
            return groups.get(0)*groups.get(1);
        //}

    }
}
