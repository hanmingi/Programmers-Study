class Solution_go {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++) {
            String pre = skill_trees[i].replaceAll("[^"+skill+"]", "");
            System.out.println(pre);
            String need = skill.substring(0, pre.length());
            System.out.println(":"+need);
            if(pre.equals(need)) {
                answer++;
            }
        }
        return answer;
    }
}

public class Main_333 {
    public static void main(String[] args) {
        Solution_go sol = new Solution_go();
        String skill = "AB";
        String[] skill_trees = { "AB", "BC"};
        System.out.println(sol.solution(skill, skill_trees));
    }
}
