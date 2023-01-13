import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> arr = new ArrayList<>();
        List<String> brr = new ArrayList<>();
        List<String> qrr = new ArrayList<>();
        for (int i = 0; i < skill.length(); i++) {
            arr.add(skill.charAt(i) + "");
        }
        
        for (int i = 0; i < skill_trees.length; i++) {
            String skill_tree=skill_trees[i];
            for (int j = 0; j < skill_trees[i].length(); j++) {
                for (int x = 0; x < arr.size(); x++) {
                    String crr = arr.get(x).toString();
                    String drr = (String.valueOf(skill_trees[i].charAt(j)));
                    
                    if (crr.equals(drr)) {
                        brr.add(crr);
                        break;
                    }
                }
            }
            for(int y=skill.length();y>0;y--){
                    String s= skill.substring(0,y);
                    String[]krr =s.split("");
                    for(String v : krr){
                        qrr.add(v);
                    }
                    
                    System.out.println(qrr);
                    System.out.println(brr);
                    String trr=qrr.toString();
                    String err=brr.toString();
                    // System.out.println(brr);
                    // System.out.println(qrr);
                    if(trr.equals(err)){
                        System.out.println("같아용");
                        answer++;
                    }
                    qrr.clear();
            }
            if(brr.isEmpty()){
                answer++;
            }
            brr.clear();
        }
        return answer;
    }
}

