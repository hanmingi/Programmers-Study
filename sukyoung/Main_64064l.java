import java.util.*; 

class Solution {
        ArrayList<String>[] idList;
        Set<String> used;
        Set<String> answer;

        public int solution(String[] user_id, String[] banned_id) {
            idList = new ArrayList[banned_id.length];
            used = new TreeSet();
            answer = new HashSet<>();

            for (int i = 0; i < banned_id.length; i++) {
                String regex = banned_id[i].replace("*", ".");

                idList[i] = new ArrayList<>();
                for (int j = 0; j < user_id.length; j++) {
                    if (user_id[j].matches(regex))
                        idList[i].add(user_id[j]); //idList[0] 에는 frodo fradi / idList[1] 에는 abc123 
                }
            }
            cnt(0);

            return answer.size();
        }

        public void cnt(int idx) {
            if (idx == idList.length) {
                answer.add(used.toString());
                return;
            }

            for (int i = 0; i < idList[idx].size(); i++) { //모든경우의수돌아야하니까 첫번째예시 2x1경우의수를 다돈다
                if (used.add(idList[idx].get(i))) { //treeset은 hashset처럼 중복허용안한다 그리고 used에서 이미사용한것을 또 사용하는 경우 예를들어 banned에 xrodo xrodo 가 있으면 frodo는 하나인데 중복허용안해서 add가 어차피 안됨
                    
                    //treeset을 쓰면 일단 hashset써도 되지않냐 할수 있지만
                    //정답이 나중에 frodo fradi abc123  / fradi frodo abc123 이거 중복이다
                    //그래서 정렬후 문자열처럼 만들어버린후  answer hashset에서 제거
                    cnt(idx + 1);
                    used.remove(idList[idx].get(i));
                }
            }

        }
    }
