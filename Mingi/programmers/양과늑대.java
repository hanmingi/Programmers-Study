package programmers;

import java.util.ArrayList;
import java.util.List;

public class 양과늑대 {
    public static void main(String[] args) {
        Solution_양과늑대 s = new Solution_양과늑대();

        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

        System.out.println(s.solution(info, edges));
    }
}

class Solution_양과늑대 {

    static ArrayList<Integer>[] childs;
    static int[] temp_info;
    static int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        temp_info = info;
        childs = new ArrayList[temp_info.length];

        for(int[] edge : edges){
            int parent = edge[0];
            int child = edge[1];

            if(childs[parent] == null){
                childs[parent] = new ArrayList<>();
            }
            childs[parent].add(child);
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0,0,0,list);

        return maxSheep;
    }

    private static void dfs(int idx, int sheep, int wolf, List<Integer> next){
        if(temp_info[idx] == 0) sheep++;
        else wolf++;

        if(wolf >= sheep) return;
        maxSheep = Math.max(sheep, maxSheep);

        List<Integer> list = new ArrayList<>();
        list.addAll(next);

        list.remove(Integer.valueOf(idx));

        if(childs[idx] != null){
            for(int child : childs[idx]){
                list.add(child);
            }
        }

        for(int n : list){
            dfs(n, sheep, wolf, list);
        }
    }
}