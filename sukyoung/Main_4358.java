import java.util.*;
import java.io.*;

public class Main_4358{
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> trees = new HashMap<>();
        int count = 0;

        while(sc.hasNextLine()){
            String temp = sc.nextLine();
            if(temp == null || temp.length() == 0) break;
            trees.put(temp, trees.getOrDefault(temp, 0) + 1); 
            count++;
        }
        List<String> treeName = new ArrayList<>(trees.keySet()); //trees hash에서 나무 이름만 받아서 정렬하기
        treeName.sort((s1, s2) -> s1.compareTo(s2));

        for(String name : treeName){
            System.out.println(name + " " + String.format("%.4f",(double)trees.get(name) / count * 100));  //format해서 소수점 4자리까지만 나오게 하기
        }
 
    }
}
