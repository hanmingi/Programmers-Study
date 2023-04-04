package programmers;

import java.util.HashSet;

public class 불량사용자 {
    public static void main(String[] args){
        Solution_불량사용자 s = new Solution_불량사용자();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        System.out.println(s.solution(user_id, banned_id)); // 2
    }
}

class Solution_불량사용자 {
    static String[] userId;
    static String[] banId;

    HashSet<HashSet<String>> result;

    public int solution(String[] user_id, String[] banned_id) {

        // dfs 함수에서 아래 2개의 String 형 배열을 사용해야 하기 때문에
        // static 으로 선언 후 대입하여 공용으로 사용
        userId = user_id;
        banId = banned_id;

        // 결과 리스트를 담을 HashSet 선언
        result = new HashSet<>();

        // 각 케이스를 담을 때 쓸 HashSet -> dfs 내부 함수에서 사용
        // caseSet 에 담긴 결과를 result 에 담으면서 정답 출력
        HashSet<String> caseSet = new HashSet<>();

        // 모든 경우의 수를 구해야 하기 때문에 재귀를 사용
        dfs(caseSet, 0);

        // result 에 들어있는 한개의 hashSet 이 1개의 case 가 되기 때문에
        // result 의 size 를 리턴하면 모든 case 의 갯수를 알 수 있다.
        return result.size();
    }

    void dfs(HashSet<String> hashSet, int count){
        // count 는 벤이 될 수 있는 아이디의 갯수를 저장한 변수
        // 따라서 banId의 길이와 count 가 같으면 한개으 경우의 수를 완성했다고 판단
        if(count == banId.length){

            // hashSet 에는 벤이 될 수 있는 한개의 케이스가 들어있기 때문에 result에 추가
            result.add(hashSet);
            return;
        }

        // userId 를 기준으로 반복 진행
        for (String s : userId) {
            // 아이디가 중복으로 들어가 있으면 스킵
            if (hashSet.contains(s)) continue;

            // 현재 타겟인 userId 가 밴이 될 대상인지 아닌지 체크
            // 여기서 요점은 * 일때는 비교를 하지 않고 *이 아닐때만 userid 와 banId 가 동일한지 체크하면 된다.
            if (check(s, banId[count])) {
                // true 가 리턴 되었다면 해당 아이디는 밴이 될 수 있다는 의미이기 때문에 hashSet 에 추가한다.
                hashSet.add(s);

                // 그리고 다른 경우의 수를 찾아야 하니 count 1 증가 이후에 밴 아이디가 저장된 hashset 을 인자로 던진다.
                dfs(new HashSet<>(hashSet), count + 1);

                // 해당 인원으로 탐색이 끝났으면 remove 하여 hashSet 을 다음 타겟을 위해 비워준다.
                hashSet.remove(s);
            }
        }
    }

    boolean check(String u, String b){
        // 디폴트 true
        boolean checkString = true;

        // 글자의 길이가 다르면 애초에 체크할 필요가 없음
        if(u.length() != b.length()) return false;

        // 한개의 String 을 기준으로 한단어씩 반복문을 사용하여 비교
        // * 일때는 비교자체를 안해도 되기 때문에 *이 아닌데 두개의 알파벳이 다를땐 false 리턴
        for(int i = 0; i < u.length(); i++){
            if(b.charAt(i) != '*' && u.charAt(i) != b.charAt(i)){
                checkString = false;
                break;
            }
        }
        return checkString;
    }

}