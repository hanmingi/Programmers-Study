package programmers;

import java.util.HashSet;

import static java.lang.System.arraycopy;

public class 등대 {
    public static void main(String[] args) {
        Solution_등대 s = new Solution_등대();

        int n = 8;
        int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};

        System.out.println(s.solution(n, lighthouse));
    }
}

class Solution_등대 {
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        HashSet<Integer> edge = new HashSet<>();
        HashSet<Integer> turn = new HashSet<>();

        for(int i = 0; i < n; i++){
            int[] link = new int[n + 1];
            int[][] remain = new int[lighthouse.length][2];
            int cnt = 0;

            for (int[] ints : lighthouse) {
                link[ints[0]]++;
                link[ints[1]]++;
            }

//            System.out.println(Arrays.toString(link));

            for(int j = 0; j < link.length; j++){
                if(link[j] == 1){
                    edge.add(j);
                }
            }

//            System.out.println(Collections.unmodifiableSet(edge));

            for (int[] ints : lighthouse) {
                if(edge.contains(ints[0]) || edge.contains(ints[1])){
                    if (edge.contains(ints[0])) turn.add(ints[1]);
                    else turn.add(ints[0]);
                }
            }

//            System.out.println(Collections.unmodifiableSet(turn));

            for (int[] ints : lighthouse) {
                if (!turn.contains(ints[0]) && !turn.contains(ints[1])) {
                    remain[cnt] = ints;
                    cnt++;
                }
            }

            if(cnt == 0) break;
//            System.out.println("cnt = " + cnt);

            if(cnt == 1) {
                answer += 1;
                break;
            }

            if(cnt < lighthouse.length){
                lighthouse = new int[cnt][2];
                arraycopy(remain, 0, lighthouse, 0, cnt);
            }
        }
        //System.out.println(Arrays.toString(link));

        answer += turn.size();

        return answer;
    }
}