import java.util.*; 

class Solution {

        public int solution(String[] user_id, String[] banned_id) {
            ArrayList<Integer>[] idList;
            Set<String> used;
            Set<String> answer;

            idList = new ArrayList[banned_id.length];
            int count = 0 ;
            int answer = 1 ;
            for (int i = 0; i < banned_id.length; i++) {
                String ch = banned_id[i].replace("*", ".");

                idList[i] = new ArrayList<>();
                for (int j = 0; j < user_id.length; j++) {
                    if (user_id[j].matches(ch))
                        count++;
                }
                idList[i].add(count);
            }
            for ( int i = 0 ; i<idList.length;i++){
                answer = (answer * idList[i]); 
            }
            
            Set<String> set = new HashSet<String>(list);
            for (int i = 0 ; i<idList.length;i++){   //for문 수정해주기
                if(set.size()!=banned_id.length){
                    answer--;  //값을 빼주는게 id가 같은경우 빼주어야하는데 지금보니 index값으로 비교를 하니 다른값이나옴
                }
            }
            
            return answer;
        }
}
