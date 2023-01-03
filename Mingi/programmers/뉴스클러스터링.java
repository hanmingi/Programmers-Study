package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        Solution_news s = new Solution_news();

        String s1 = "FRANCE";
        String s2 = "french";

        System.out.println(s.solution(s1, s2));
    }
}
class Solution_news {
    public int solution(String str1, String str2) {

        ArrayList<String> set1 = new ArrayList<>();
        ArrayList<String> set2 = new ArrayList<>();

        ArrayList<String> inter = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);

            if(checkAlpha(c1) && checkAlpha(c2))
            {
                set1.add(c1 + "" + c2);
            }
        }

        for(int i = 0; i < str2.length() - 1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);

            if(checkAlpha(c1) && checkAlpha(c2)){
                set2.add(c1 + "" + c2);
            }
        }

        Collections.sort(set1);
        Collections.sort(set2);

        for(String s1 : set1){
            if(set2.remove(s1)){
                inter.add(s1);
            }
            union.add(s1);
        }

        union.addAll(set2);

        double answer;

        if(union.size() == 0){
            answer = 1;
        }
        else{
            answer = (double) inter.size() / (double) union.size();
        }

        return (int)(answer * 65536);
    }

    static boolean checkAlpha(char c){
        return 'a' <= c && c <= 'z';
    }
}