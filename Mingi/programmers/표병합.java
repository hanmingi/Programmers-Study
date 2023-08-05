package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 표병합 {
    public static void main(String[] args) {

        Solution_표병합 s = new Solution_표병합();

        String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};

        System.out.println(Arrays.toString(s.solution(commands)));
    }
}

class Solution_표병합 {
    // 50 * 50
    public int[] parent = new int[2501];
    public String[] value = new String[2501];

    // UNION-FIND 알고리즘
    public int find(int a){
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }


    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();

        // 초기값 세팅
        initSolution();

        for(String command : commands){
            String[] data = command.split(" ");

            //data[0] -> command 문구
            // data[0] null -> equals 상수 또는 무조건 null 앞에다가
            if("UPDATE".equals(data[0])){
                // UPDATE 값1 값2
                if(data.length == 3) {
                    String a = data[1];
                    String b = data[2];

                    for(int i = 0; i <= 2500; i++){
                        if(a.equals(value[i])){
                            value[i] = b;
                        }
                    }
                }
                // UPDATE x좌표 y좌표 바꿀값
                else{
                    int x = Integer.parseInt(data[1]);
                    int y = Integer.parseInt(data[2]);
                    String v = data[3];

                    int num = findNum(x, y);
                    value[find(num)] = v;
                }

            }

            else if("MERGE".equals(data[0])){
                int x1 = Integer.parseInt(data[1]);
                int y1 = Integer.parseInt(data[2]);
                int x2 = Integer.parseInt(data[3]);
                int y2 = Integer.parseInt(data[4]);
                int num1 = findNum(x1, y1);
                int num2 = findNum(x2, y2);

                int parent1 = find(num1);
                int parent2 = find(num2);

                System.out.println("num1 = " + num1);
                System.out.println("num2 = " + num2);
                System.out.println("parent1 = " + parent1);
                System.out.println("parent2 = " + parent2);

                if(parent1 == parent2) continue;

                String parentString = "";
                if(value[parent1].equals("")) parentString = value[parent2];
                else parentString = value[parent1];

                System.out.println("parentString = " + parentString);

                value[parent1] = "";
                value[parent2] = "";

                union(parent1, parent2);

                value[parent1] = parentString;
            }

            else if("UNMERGE".equals(data[0])){
                int x = Integer.parseInt(data[1]);
                int y = Integer.parseInt(data[2]);

                int num = findNum(x, y);
                int r = find(num);

                String parentString = value[r];
                value[r] = "";
                value[num] = parentString;

                List<Integer> d = new ArrayList<>();
                for(int i =0 ; i <= 2500; i++){
                    if(find(i) == r) d.add(i);
                }
                for(Integer i : d) parent[i] = i;
            }

            else if("PRINT".equals(data[0])){
                int x = Integer.parseInt(data[1]);
                int y = Integer.parseInt(data[2]);

                int n = findNum(x, y);

                int r = find(n);

                if(value[r].equals("")) answer.add("EMPTY");
                else answer.add(value[r]);
            }
            System.out.println("value = " + Arrays.toString(value));
        }

        System.out.println("answer = " + answer);
        Print();
        return answer.toArray(new String[0]);
    }

    // 초기값 세팅
    private void initSolution()
    {
        // 50 * 50
        for(int i = 1; i <= 2500; i++) {
            parent[i] = i;
            value[i] = "";
        }
    }

    private int findNum(int x, int y){
        int result = 50 * (x - 1);
        return result + y;
    }

    private void Print() {
        for(int i = 1; i <= 50; i++){
            for(int j = 1; j <= 50; j++){
                if(value[findNum(i, j)].equals("")) System.out.print(" NULL ");
                else System.out.print(" " + value[findNum(i, j)] + " ");
            }
            System.out.println();
        }
    }
}